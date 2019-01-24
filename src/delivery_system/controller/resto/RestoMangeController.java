package delivery_system.controller.resto;

import delivery_system.model.restaurants.Restaurant;
import delivery_system.model.restaurants.Restaurants;
import delivery_system.views.RestoManageView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Delivery System
 *
 * @author Michael De Rubertis <m.derubertis@hotmail.com>
 * @version 1.0
 * @date 2019-01-21
 */
public class RestoMangeController {
    Restaurants model = new Restaurants();
    RestoManageView view;
    boolean edit = false;
    Restaurant currentResto;

    public RestoMangeController(Restaurants model, RestoManageView view) {
        this.model = model;
        this.view = view;

        try {
            URL iconURL = getClass().getResource("/delivery_system/assets/icons8-maintenance-48.png");
            view.setFrameIcon(new ImageIcon(iconURL));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane scrPane = new JScrollPane(this.view.getPanel_16(), ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.view.getContentPane().add(scrPane);
        this.view.setSize(600, 600);

        this.view.getBtnAddDeliveryArea().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] arrDevAreas = view.getTxtDevAreas().getText().split(", ");
                ArrayList<String> devAreas = new ArrayList<>(Arrays.asList(arrDevAreas)) ;
                boolean exists = false;

                for (String devArea : devAreas)
                    if (devArea.equals(view.getTxtAddDevArea().getText()))
                        exists = true;

                if (devAreas.size() < 24 && !exists && view.getTxtAddDevArea().getText().trim().length() > 0)
                    view.getTxtDevAreas().setText(view.getTxtDevAreas().getText() + (!view.getTxtDevAreas().getText().equals("") ? ", " : "") + view.getTxtAddDevArea().getText());
            }
        });

        this.view.getBtnDeleteDeliveryArea().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] arrDevAreas = view.getTxtDevAreas().getText().split(", ");
                ArrayList<String> devAreas = new ArrayList<>(Arrays.asList(arrDevAreas)) ;

                for (int i = 0; i < devAreas.size(); i++)
                    if (devAreas.get(i).equals(view.getTxtAddDevArea().getText()))
                        devAreas.remove(i);

                view.getTxtDevAreas().setText(String.join(", ", devAreas));
            }
        });

        this.view.getBtnSave().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                int response = JOptionPane.showConfirmDialog(view,
                        "Restaurant Name: " + view.getTxtRestoName().getText() + "\n" + "Restaurant Address: " + view.getTxtRestoAddr().getText()
                                + "\n" + "Telephone Number: " + view.getFtxtTelParsed()
                                + "\n" + "\n"
//                                + "Opening Hours" + "\n" + "Sunday:                   "
//                                + comboBox.getSelectedIndex() + " h " + comboBox_1.getSelectedIndex() + " - "
//                                + comboBox1.getSelectedIndex() + " h " + comboBox2.getSelectedIndex() + "\n"
//                                + "Monday:                   " + comboBox_2.getSelectedIndex() + " h "
//                                + comboBox_3.getSelectedIndex() + " - " + comboBox3.getSelectedIndex() + " h "
//                                + comboBox4.getSelectedIndex() + "\n" + "Tuesday:                  "
//                                + comboBox_4.getSelectedIndex() + " h " + comboBox_5.getSelectedIndex() + " - "
//                                + comboBox5.getSelectedIndex() + " h " + comboBox6.getSelectedIndex() + "\n"
//                                + "Wednesday:            " + comboBox_6.getSelectedIndex() + " h "
//                                + comboBox_7.getSelectedIndex() + " - " + comboBox7.getSelectedIndex() + " h "
//                                + comboBox8.getSelectedIndex() + "\n" + "Thursday:                 "
//                                + comboBox_8.getSelectedIndex() + " h " + comboBox_9.getSelectedIndex() + " - "
//                                + comboBox9.getSelectedIndex() + " h " + comboBox10.getSelectedIndex() + "\n"
//                                + "Friday:                       " + comboBox_10.getSelectedIndex() + " h "
//                                + comboBox_11.getSelectedIndex() + " - " + comboBox11.getSelectedIndex() + " h "
//                                + comboBox12.getSelectedIndex() + "\n" + "Saturday:                  "
//                                + comboBox_12.getSelectedIndex() + " h " + comboBox_13.getSelectedIndex() + " - "
//                                + comboBox13.getSelectedIndex() + " h " + comboBox14.getSelectedIndex() + "\n" + "\n"
                                + "Postal Area Cover by this Restaurant: " + view.getTxtDevAreas().getText() + "\n" + "\n"
                                + "Would you Like to " + (edit ? "edit" : "save") + " this Restaurant?",
                        (edit ? "Edit" : "Save"), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                if (response == JOptionPane.YES_OPTION) {
                    String[] hours = new String[1];
                    hours[0] = "";

                    String[] devArea = view.getTxtDevAreas().getText().split(", ");

                    System.out.println(new Restaurant(view.getTxtRestoName().getText(), view.getTxtRestoAddr().getText(), view.getFtxtTelParsed(), hours, devArea).toString());

                    if (!edit)
                        model.addRestaurant(new Restaurant(view.getTxtRestoName().getText(), view.getTxtRestoAddr().getText(), view.getFtxtTelParsed(), hours, devArea));
                    else
                        model.editRestaurant(currentResto, new Restaurant(view.getTxtRestoName().getText(), view.getTxtRestoAddr().getText(), view.getFtxtTelParsed(), hours, devArea));

                    setCurrentResto(null);
                    setEdit(false);
                    clear();
                    showView();
                }
            }
        });
    }

    public boolean isEdit() {
        return edit;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }

    public Restaurant getCurrentResto() {
        return currentResto;
    }

    public void setCurrentResto(Restaurant currentResto) {
        this.currentResto = currentResto;
    }

    public void showView() {
        if (isEdit() && currentResto != null) {
            view.getLblViewTitle().setText("Edit Restaurant");
            view.setTitle((view.getTitle().contains("ADD") || view.getTitle().contains("EDIT") ? view.getTitle().replace("[ADD]", "[EDIT]") : view.getTitle() + " [EDIT]"));
            view.getTxtRestoName().setText(currentResto.getName());
            view.getTxtRestoAddr().setText(currentResto.getAddress());
            view.getFtxtTel1().setValue(currentResto.getPhone().substring(1, 4));
            view.getFtxtTel2().setValue(currentResto.getPhone().substring(6, 9));
            view.getFtxtTel3().setValue(currentResto.getPhone().substring(10, 14));
            view.getTxtDevAreas().setText(Arrays.toString(currentResto.getDelieveryArea()).substring(1, Arrays.toString(currentResto.getDelieveryArea()).length() - 1));
        } else {
            view.getLblViewTitle().setText("Add Restaurant");
            view.setTitle((view.getTitle().contains("EDIT") || view.getTitle().contains("ADD") ? view.getTitle().replace("[EDIT]", "[ADD]") : view.getTitle() + " [ADD]"));
            clear();
        }

        this.view.setVisible(true);
    }

    private void clear() {
        view.getTxtRestoName().setText("");
        view.getTxtRestoAddr().setText("");
        view.getFtxtTel1().setValue("");
        view.getFtxtTel2().setValue("");
        view.getFtxtTel3().setValue("");
        view.getTxtDevAreas().setText("");
        view.getTxtAddDevArea().setText("");
    }
}
