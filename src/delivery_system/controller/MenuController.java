package delivery_system.controller;

import delivery_system.Main;
import delivery_system.model.menu.*;
import delivery_system.model.menu.Menu;
import delivery_system.model.restaurants.Restaurant;
import delivery_system.model.restaurants.Restaurants;
import delivery_system.views.MenuView;
import delivery_system.views.RestoManageView;
import org.json.JSONObject;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.URL;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;

/**
 * Delivery System
 *
 * @author Michael De Rubertis <m.derubertis@hotmail.com>
 * @version 1.0
 * @date 2019-01-26
 */
public class MenuController {
    Restaurants model = new Restaurants();
    MenuView view;
    boolean noRestos = false;
    boolean edit = false;
    Restaurant currentResto;
    private final DefaultTableModel tblMenuModel;
    private DefaultListModel<String> listModel;

    public MenuController(Restaurants model, MenuView view) {
        this.model = model;
        this.view = view;

        String[] restos = new String[model.getRestaurants().size()];

        if (model.getRestaurants().size() == 0) {
            noRestos = true;
            restos = new String[1];
            restos[0] = "No restaurants";
        } else {
            noRestos = false;
            for (int i = 0; i < model.getRestaurants().size(); i++)
                restos[i] = model.getRestaurant(i).getName();

        }

        tblMenuModel = new DefaultTableModel(new Object[][]{}, new String[]{"Item", "Price"}) {
            Class[] columnTypes = new Class[]{String.class, Double.class};

            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
        };

        try {
            URL iconURL = getClass().getResource("/delivery_system/assets/icons8-maintenance-48.png");
            view.setFrameIcon(new ImageIcon(iconURL));
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.view.getContentPane().add(this.view.getMainPanel(), BorderLayout.CENTER);
        this.view.setSize(600, 600);

        this.view.getTblMenu().setModel(tblMenuModel);
        this.view.getTblMenu().getColumnModel().getColumn(1).setMaxWidth(40);

        listModel = new DefaultListModel<>();
        for (Restaurant s : model.getRestaurants()) {
            listModel.addElement(s.getName());
        }
        this.view.getListRestaurants().setModel(listModel);
        this.view.getListRestaurants().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting())
                    updateMenu(view.getListRestaurants().getSelectedIndex());
            }
        });

        this.view.getBtnCreateMenu().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (edit) {
                    Menu newMenu = new Menu();
                    for (int i = 0; i < tblMenuModel.getRowCount(); i++) {
                        newMenu.addItem(new Item(tblMenuModel.getValueAt(i, 0).toString(), Double.parseDouble(tblMenuModel.getValueAt(i, 1).toString())));
                    }
                    model.getRestaurant(view.getListRestaurants().getSelectedIndex()).setMenu(newMenu);
                    System.out.println(model.getRestaurant(view.getListRestaurants().getSelectedIndex()).toString());
                }
            }
        });
    }

    public void updateMenu(int restoIndex) {
        edit = false;
        view.getLblViewTitle().setText("Create Menu");
        view.getBtnCreateMenu().setText("Create Menu");

        for (int i = 0; i < tblMenuModel.getRowCount(); i++) {
            tblMenuModel.removeRow(i);
        }
        delivery_system.model.menu.Menu menuForSelectedResto = model.getRestaurant(restoIndex).getMenu();

        if (menuForSelectedResto.getMenu().size() > 0 && menuForSelectedResto.getMenu() != null) {
            edit = true;
            view.getLblViewTitle().setText("Edit Menu");
            view.getBtnCreateMenu().setText("Edit Menu");
            for (Item item : menuForSelectedResto.getMenu()) {
                tblMenuModel.addRow(new Object[]{item.getName(), item.getPrice()});
            }
        }
    }

    public void showView() {
        listModel.clear();
        for (Restaurant s : model.getRestaurants()) {
            listModel.addElement(s.getName());
        }

        this.view.setVisible(true);
    }
}
