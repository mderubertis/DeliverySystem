package delivery_system.controller;

import delivery_system.model.menu.*;
import delivery_system.model.menu.Menu;
import delivery_system.model.restaurants.Restaurant;
import delivery_system.model.restaurants.Restaurants;
import delivery_system.views.RestoManageView;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

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
    boolean editAllTimes = false;
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

        JScrollPane scrPane = new JScrollPane(this.view.getMainPanel(), ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.view.getContentPane().add(scrPane);
        this.view.setSize(600, 600);

        this.view.getBtnModifyAllTimes().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editAllTimes = !editAllTimes;

                for (int i = 1; i < view.getOpenHoursPanel().getComponents().length; i++) {
                    Component component = view.getOpenHoursPanel().getComponents()[i];
                    if (component instanceof JComboBox && i != 2) {
                        if (editAllTimes) {
                            component.setEnabled(false);
                            view.getCmbMonOHrs().setSelectedItem(view.getCmbSunOHrs().getSelectedItem());
                            view.getCmbTuesOHrs().setSelectedItem(view.getCmbSunOHrs().getSelectedItem());
                            view.getCmbWedOHrs().setSelectedItem(view.getCmbSunOHrs().getSelectedItem());
                            view.getCmbThursOHrs().setSelectedItem(view.getCmbSunOHrs().getSelectedItem());
                            view.getCmbFriOHrs().setSelectedItem(view.getCmbSunOHrs().getSelectedItem());
                            view.getCmbSatOHrs().setSelectedItem(view.getCmbSunOHrs().getSelectedItem());

                            view.getCmbMonOHrs2().setSelectedItem(view.getCmbSunOHrs2().getSelectedItem());
                            view.getCmbTuesOHrs2().setSelectedItem(view.getCmbSunOHrs2().getSelectedItem());
                            view.getCmbWedOHrs2().setSelectedItem(view.getCmbSunOHrs2().getSelectedItem());
                            view.getCmbThursOHrs2().setSelectedItem(view.getCmbSunOHrs2().getSelectedItem());
                            view.getCmbFriOHrs2().setSelectedItem(view.getCmbSunOHrs2().getSelectedItem());
                            view.getCmbSatOHrs2().setSelectedItem(view.getCmbSunOHrs2().getSelectedItem());
                        } else
                            component.setEnabled(true);
                    }
                }

                for (int i = 1; i < view.getClosedHoursPanel().getComponents().length; i++) {
                    Component component = view.getClosedHoursPanel().getComponents()[i];
                    if (component instanceof JComboBox && i != 2) {
                        if (editAllTimes) {
                            component.setEnabled(false);
                            view.getCmbMonCHrs().setSelectedItem(view.getCmbSunCHrs().getSelectedItem());
                            view.getCmbTuesCHrs().setSelectedItem(view.getCmbSunCHrs().getSelectedItem());
                            view.getCmbWedCHrs().setSelectedItem(view.getCmbSunCHrs().getSelectedItem());
                            view.getCmbThursCHrs().setSelectedItem(view.getCmbSunCHrs().getSelectedItem());
                            view.getCmbFriCHrs().setSelectedItem(view.getCmbSunCHrs().getSelectedItem());
                            view.getCmbSatCHrs().setSelectedItem(view.getCmbSunCHrs().getSelectedItem());

                            view.getCmbMonCHrs2().setSelectedItem(view.getCmbSunCHrs2().getSelectedItem());
                            view.getCmbTuesCHrs2().setSelectedItem(view.getCmbSunCHrs2().getSelectedItem());
                            view.getCmbWedCHrs2().setSelectedItem(view.getCmbSunCHrs2().getSelectedItem());
                            view.getCmbThursCHrs2().setSelectedItem(view.getCmbSunCHrs2().getSelectedItem());
                            view.getCmbFriCHrs2().setSelectedItem(view.getCmbSunCHrs2().getSelectedItem());
                            view.getCmbSatCHrs2().setSelectedItem(view.getCmbSunCHrs2().getSelectedItem());
                        } else
                            component.setEnabled(true);
                    }
                }

                if (editAllTimes) {
                    view.getCmbSunOHrs().addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JComboBox cmbBox = (JComboBox) e.getSource();
                            view.getCmbMonOHrs().setSelectedItem(cmbBox.getSelectedItem());
                            view.getCmbTuesOHrs().setSelectedItem(cmbBox.getSelectedItem());
                            view.getCmbWedOHrs().setSelectedItem(cmbBox.getSelectedItem());
                            view.getCmbThursOHrs().setSelectedItem(cmbBox.getSelectedItem());
                            view.getCmbFriOHrs().setSelectedItem(cmbBox.getSelectedItem());
                            view.getCmbSatOHrs().setSelectedItem(cmbBox.getSelectedItem());
                        }
                    });

                    view.getCmbSunOHrs2().addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JComboBox cmbBox = (JComboBox) e.getSource();
                            view.getCmbMonOHrs2().setSelectedItem(cmbBox.getSelectedItem());
                            view.getCmbTuesOHrs2().setSelectedItem(cmbBox.getSelectedItem());
                            view.getCmbWedOHrs2().setSelectedItem(cmbBox.getSelectedItem());
                            view.getCmbThursOHrs2().setSelectedItem(cmbBox.getSelectedItem());
                            view.getCmbFriOHrs2().setSelectedItem(cmbBox.getSelectedItem());
                            view.getCmbSatOHrs2().setSelectedItem(cmbBox.getSelectedItem());
                        }
                    });

                    view.getCmbSunCHrs().addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JComboBox cmbBox = (JComboBox) e.getSource();
                            view.getCmbMonCHrs().setSelectedItem(cmbBox.getSelectedItem());
                            view.getCmbTuesCHrs().setSelectedItem(cmbBox.getSelectedItem());
                            view.getCmbWedCHrs().setSelectedItem(cmbBox.getSelectedItem());
                            view.getCmbThursCHrs().setSelectedItem(cmbBox.getSelectedItem());
                            view.getCmbFriCHrs().setSelectedItem(cmbBox.getSelectedItem());
                            view.getCmbSatCHrs().setSelectedItem(cmbBox.getSelectedItem());
                        }
                    });

                    view.getCmbSunCHrs2().addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JComboBox cmbBox = (JComboBox) e.getSource();
                            view.getCmbMonCHrs2().setSelectedItem(cmbBox.getSelectedItem());
                            view.getCmbTuesCHrs2().setSelectedItem(cmbBox.getSelectedItem());
                            view.getCmbWedCHrs2().setSelectedItem(cmbBox.getSelectedItem());
                            view.getCmbThursCHrs2().setSelectedItem(cmbBox.getSelectedItem());
                            view.getCmbFriCHrs2().setSelectedItem(cmbBox.getSelectedItem());
                            view.getCmbSatCHrs2().setSelectedItem(cmbBox.getSelectedItem());
                        }
                    });
                } else {
                    view.getCmbSunOHrs().removeActionListener(view.getCmbSunOHrs().getActionListeners()[0]);
                    view.getCmbSunOHrs2().removeActionListener(view.getCmbSunOHrs2().getActionListeners()[0]);

                    view.getCmbSunCHrs().removeActionListener(view.getCmbSunCHrs().getActionListeners()[0]);
                    view.getCmbSunCHrs2().removeActionListener(view.getCmbSunCHrs2().getActionListeners()[0]);
                }
            }
        });

        this.view.getBtnAddDeliveryArea().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] arrDevAreas = view.getTxtDevAreas().getText().split(", ");
                ArrayList<String> devAreas = new ArrayList<>(Arrays.asList(arrDevAreas));
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
                ArrayList<String> devAreas = new ArrayList<>(Arrays.asList(arrDevAreas));

                for (int i = 0; i < devAreas.size(); i++)
                    if (devAreas.get(i).equals(view.getTxtAddDevArea().getText()))
                        devAreas.remove(i);

                view.getTxtDevAreas().setText(String.join(", ", devAreas));
            }
        });

        this.view.getBtnSave().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (valid()) {
                    StringBuilder messageBuilder = new StringBuilder("Restaurant Name: " + view.getTxtRestoName().getText() + "\n" + "Restaurant Address: " + view.getTxtRestoAddr().getText()
                            + "\n" + "Telephone Number: " + view.getFtxtTelParsed()
                            + "\n\nHours of Operation:\n");

                    JSONObject opened = hoursToJSON().getJSONObject("opened");
                    JSONObject closed = hoursToJSON().getJSONObject("closed");

                    messageBuilder.append("Sunday: " + opened.get("sunday").toString().split(":")[0] + "h" + opened.get("sunday").toString().split(":")[1] + " to " + closed.get("sunday").toString().split(":")[0] + "h" + closed.get("sunday").toString().split(":")[1] + "\n");
                    messageBuilder.append("Monday: " + opened.get("monday").toString().split(":")[0] + "h" + opened.get("monday").toString().split(":")[1] + " to " + closed.get("monday").toString().split(":")[0] + "h" + closed.get("monday").toString().split(":")[1] + "\n");
                    messageBuilder.append("Tuesday: " + opened.get("tuesday").toString().split(":")[0] + "h" + opened.get("tuesday").toString().split(":")[1] + " to " + closed.get("tuesday").toString().split(":")[0] + "h" + closed.get("tuesday").toString().split(":")[1] + "\n");
                    messageBuilder.append("Wednesday: " + opened.get("wednesday").toString().split(":")[0] + "h" + opened.get("wednesday").toString().split(":")[1] + " to " + closed.get("wednesday").toString().split(":")[0] + "h" + closed.get("wednesday").toString().split(":")[1] + "\n");
                    messageBuilder.append("Thursday: " + opened.get("thursday").toString().split(":")[0] + "h" + opened.get("thursday").toString().split(":")[1] + " to " + closed.get("thursday").toString().split(":")[0] + "h" + closed.get("thursday").toString().split(":")[1] + "\n");
                    messageBuilder.append("Friday: " + opened.get("friday").toString().split(":")[0] + "h" + opened.get("friday").toString().split(":")[1] + " to " + closed.get("friday").toString().split(":")[0] + "h" + closed.get("friday").toString().split(":")[1] + "\n");
                    messageBuilder.append("Saturday: " + opened.get("saturday").toString().split(":")[0] + "h" + opened.get("saturday").toString().split(":")[1] + " to " + closed.get("saturday").toString().split(":")[0] + "h" + closed.get("saturday").toString().split(":")[1] + "\n");

                    messageBuilder.append("\nDelivery Areas: " + view.getTxtDevAreas().getText() + "\n\n"
                            + (edit ? "Edit" : "Save") + " this restaurant?");

                    int response = JOptionPane.showConfirmDialog(view,
                            messageBuilder.toString(),
                            (edit ? "Edit" : "Save") + " restaurant", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                    if (response == JOptionPane.YES_OPTION) {
                        String[] devArea = view.getTxtDevAreas().getText().split(", ");

                        if (!edit)
                            model.addRestaurant(new Restaurant(view.getTxtRestoName().getText(), view.getTxtRestoAddr().getText(), view.getFtxtTelParsed(), hoursToJSON(), devArea, new Menu()));
                        else
                            model.editRestaurant(currentResto, new Restaurant(view.getTxtRestoName().getText(), view.getTxtRestoAddr().getText(), view.getFtxtTelParsed(), hoursToJSON(), devArea, new Menu()));

                        setCurrentResto(null);
                        setEdit(false);
                        clear();
                        showView();
                    }
                } else {
                    JOptionPane.showMessageDialog(view, "Invalid fields in form", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private boolean valid() {
        int combosValid = 0;
        for (Component component : view.getOpenHoursPanel().getComponents()) {
            if (component instanceof JComboBox)
                if (((JComboBox) component).getSelectedIndex() >= 1)
                    combosValid++;
                else
                    combosValid--;
        }

        for (Component component : view.getClosedHoursPanel().getComponents()) {
            if (component instanceof JComboBox)
                if (((JComboBox) component).getSelectedIndex() >= 1)
                    combosValid++;
                else
                    combosValid--;
        }

//        System.out.println(combosValid);
//        System.out.println(view.getTxtRestoName().getText().length());
//        System.out.println(view.getTxtRestoAddr().getText().length());
//        System.out.println(view.getFtxtTelParsed().replace("(", "").replace(")", "").replace("-", "").trim().length());
//        System.out.println(view.getTxtDevAreas().getText().length());

        if (combosValid == 28 && view.getTxtRestoName().getText().length() >= 4 && view.getTxtRestoAddr().getText().length() >= 4 && view.getFtxtTelParsed().replace("(", "").replace(")", "").replace("-", "").trim().length() - 1 == 10 && view.getTxtDevAreas().getText().length() >= 3)
            return true;
        else
            return false;
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

            JSONObject hours = currentResto.getHours();
            JSONObject openedHours = hours.getJSONObject("opened");
            JSONObject closedHours = hours.getJSONObject("closed");

            for (Iterator<String> it = openedHours.keys(); it.hasNext(); ) {
                String key = it.next();
                String hour = openedHours.get(key).toString().split(":")[0];
                String min = openedHours.get(key).toString().split(":")[1];

                switch (key) {
                    case "sunday":
                        view.getCmbSunOHrs().setSelectedItem(hour);
                        view.getCmbSunOHrs2().setSelectedItem(min);
                        break;
                    case "monday":
                        view.getCmbMonOHrs().setSelectedItem(hour);
                        view.getCmbMonOHrs2().setSelectedItem(min);
                        break;
                    case "tuesday":
                        view.getCmbTuesOHrs().setSelectedItem(hour);
                        view.getCmbTuesOHrs2().setSelectedItem(min);
                        break;
                    case "wednesday":
                        view.getCmbWedOHrs().setSelectedItem(hour);
                        view.getCmbWedOHrs2().setSelectedItem(min);
                        break;
                    case "thursday":
                        view.getCmbThursOHrs().setSelectedItem(hour);
                        view.getCmbThursOHrs2().setSelectedItem(min);
                        break;
                    case "friday":
                        view.getCmbFriOHrs().setSelectedItem(hour);
                        view.getCmbFriOHrs2().setSelectedItem(min);
                        break;
                    case "saturday":
                        view.getCmbSatOHrs().setSelectedItem(hour);
                        view.getCmbSatOHrs2().setSelectedItem(min);
                        break;
                }
            }

            for (Iterator<String> it = closedHours.keys(); it.hasNext(); ) {
                String key = it.next();
                String hour = closedHours.get(key).toString().split(":")[0];
                String min = closedHours.get(key).toString().split(":")[1];

                switch (key) {
                    case "sunday":
                        view.getCmbSunCHrs().setSelectedItem(hour);
                        view.getCmbSunCHrs2().setSelectedItem(min);
                        break;
                    case "monday":
                        view.getCmbMonCHrs().setSelectedItem(hour);
                        view.getCmbMonCHrs2().setSelectedItem(min);
                        break;
                    case "tuesday":
                        view.getCmbTuesCHrs().setSelectedItem(hour);
                        view.getCmbTuesCHrs2().setSelectedItem(min);
                        break;
                    case "wednesday":
                        view.getCmbWedCHrs().setSelectedItem(hour);
                        view.getCmbWedCHrs2().setSelectedItem(min);
                        break;
                    case "thursday":
                        view.getCmbThursCHrs().setSelectedItem(hour);
                        view.getCmbThursCHrs2().setSelectedItem(min);
                        break;
                    case "friday":
                        view.getCmbFriCHrs().setSelectedItem(hour);
                        view.getCmbFriCHrs2().setSelectedItem(min);
                        break;
                    case "saturday":
                        view.getCmbSatCHrs().setSelectedItem(hour);
                        view.getCmbSatCHrs2().setSelectedItem(min);
                        break;
                }
            }

            view.getTxtDevAreas().setText(Arrays.toString(currentResto.getDelieveryArea()).substring(1, Arrays.toString(currentResto.getDelieveryArea()).length() - 1));
        } else {
            view.getLblViewTitle().setText("Add Restaurant");
            view.setTitle((view.getTitle().contains("EDIT") || view.getTitle().contains("ADD") ? view.getTitle().replace("[EDIT]", "[ADD]") : view.getTitle() + " [ADD]"));
            clear();
        }

        this.view.setVisible(true);
    }

    private JSONObject hoursToJSON() {
        JSONObject hours = new JSONObject();

        JSONObject openedHours = new JSONObject();
        openedHours.put("sunday", view.getCmbSunOHrs().getSelectedItem() + ":" + view.getCmbSunOHrs2().getSelectedItem());
        openedHours.put("monday", view.getCmbMonOHrs().getSelectedItem() + ":" + view.getCmbMonOHrs2().getSelectedItem());
        openedHours.put("tuesday", view.getCmbTuesOHrs().getSelectedItem() + ":" + view.getCmbTuesOHrs2().getSelectedItem());
        openedHours.put("wednesday", view.getCmbWedOHrs().getSelectedItem() + ":" + view.getCmbWedOHrs2().getSelectedItem());
        openedHours.put("thursday", view.getCmbThursOHrs().getSelectedItem() + ":" + view.getCmbThursOHrs2().getSelectedItem());
        openedHours.put("friday", view.getCmbFriOHrs().getSelectedItem() + ":" + view.getCmbFriOHrs2().getSelectedItem());
        openedHours.put("saturday", view.getCmbSatOHrs().getSelectedItem() + ":" + view.getCmbSatOHrs2().getSelectedItem());

        JSONObject closedHours = new JSONObject();
        closedHours.put("sunday", view.getCmbSunCHrs().getSelectedItem() + ":" + view.getCmbSunCHrs2().getSelectedItem());
        closedHours.put("monday", view.getCmbMonCHrs().getSelectedItem() + ":" + view.getCmbMonCHrs2().getSelectedItem());
        closedHours.put("tuesday", view.getCmbTuesCHrs().getSelectedItem() + ":" + view.getCmbTuesCHrs2().getSelectedItem());
        closedHours.put("wednesday", view.getCmbWedCHrs().getSelectedItem() + ":" + view.getCmbWedCHrs2().getSelectedItem());
        closedHours.put("thursday", view.getCmbThursCHrs().getSelectedItem() + ":" + view.getCmbThursCHrs2().getSelectedItem());
        closedHours.put("friday", view.getCmbFriCHrs().getSelectedItem() + ":" + view.getCmbFriCHrs2().getSelectedItem());
        closedHours.put("saturday", view.getCmbSatCHrs().getSelectedItem() + ":" + view.getCmbSatCHrs2().getSelectedItem());

        hours.put("closed", closedHours);
        hours.put("opened", openedHours);
        return hours;
    }

    private void clear() {
        editAllTimes = false;
        for (Component component : view.getOpenHoursPanel().getComponents()) {
            if (component instanceof JComboBox) {
                JComboBox cmbBox = (JComboBox) component;
                cmbBox.setSelectedIndex(0);
                cmbBox.setEnabled(true);
            }
        }

        for (Component component : view.getClosedHoursPanel().getComponents()) {
            if (component instanceof JComboBox) {
                JComboBox cmbBox = (JComboBox) component;
                cmbBox.setSelectedIndex(0);
                cmbBox.setEnabled(true);
            }
        }

        view.getTxtRestoName().setText("");
        view.getTxtRestoAddr().setText("");
        view.getFtxtTel1().setValue("");
        view.getFtxtTel2().setValue("");
        view.getFtxtTel3().setValue("");
        view.getTxtDevAreas().setText("");
        view.getTxtAddDevArea().setText("");
    }
}
