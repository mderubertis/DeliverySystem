package delivery_system.controller.resto;

import delivery_system.model.restaurants.Restaurants;
import delivery_system.views.RestoManageView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

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
        this.view.setSize(600, 400);
    }

    public boolean isEdit() {
        return edit;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }

    public void showView() {
        this.view.getBtnSave().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                JOptionPane.showConfirmDialog(view,
//                        "Restaurant Name: " + resname.getText() + "\n" + "Restaurant Address: " + resadd.getText()
//                                + "\n" + "Telephone Number: " + "(" + jtf.getText() + ")"
//                                + jtf1.getText() + "-" + jtf2.getText() + "\n" + "\n"
//                                + "                               Opening Hours" + "\n" + "Sunday:                   "
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
//                                + "Postal Area Cover by this Restaurant: " + jtf3.getText() + "\n" + "\n"
//                                + "Would you Like to save this Restaurant?",
                        "Save",
                        "Confirm", JOptionPane.YES_NO_OPTION);

            }
        });
        this.view.setVisible(true);
    }
}
