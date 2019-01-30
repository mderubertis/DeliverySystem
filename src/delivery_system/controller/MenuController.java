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
import java.util.ArrayList;
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
    private Menu menu;

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
            URL iconURL = getClass().getResource("/delivery_system/assets/icons8-restaurant-menu-48.png");
            view.setFrameIcon(new ImageIcon(iconURL));
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.view.getContentPane().add(this.view.getMainPanel(), BorderLayout.CENTER);
        this.view.setSize(600, 600);

        this.view.getTblMenu().setModel(tblMenuModel);
        this.view.getTblMenu().getColumnModel().getColumn(1).setMaxWidth(40);
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem deleteItem = new JMenuItem("Delete");
        deleteItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] options = {"Delete", "Cancel"};
                int response = JOptionPane.showOptionDialog(view,
                        "Are you sure you want to delete item \"" + tblMenuModel.getValueAt(view.getTblMenu().getSelectedRow(), 0) + "\"",
                        "Confirm deletion",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null, options, options[0]);

                if (response == 0) {
                    tblMenuModel.removeRow(view.getTblMenu().getSelectedRow());
                }
            }
        });
        popupMenu.add(deleteItem);
        this.view.getTblMenu().setComponentPopupMenu(popupMenu);
        popupMenu.addPopupMenuListener(new PopupMenuListener() {

            @Override
            public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        int rowAtPoint = view.getTblMenu().rowAtPoint(SwingUtilities.convertPoint(popupMenu, new Point(0, 0), view.getTblMenu()));
                        if (rowAtPoint > -1) {
                            view.getTblMenu().setRowSelectionInterval(rowAtPoint, rowAtPoint);
                        }
                    }
                });
            }

            @Override
            public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void popupMenuCanceled(PopupMenuEvent e) {
                // TODO Auto-generated method stub

            }
        });

        listModel = new DefaultListModel<>();
        for (Restaurant s : model.getRestaurants()) {
            listModel.addElement(s.getName());
        }

        this.view.getListRestaurants().setModel(listModel);
        this.view.getListRestaurants().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                boolean enabled = false;
                if (!e.getValueIsAdjusting())
                    if (view.getListRestaurants().getSelectedIndex() > -1) {
                        menu = model.getRestaurant(view.getListRestaurants().getSelectedIndex()).getMenu();
                        enabled = true;
                        updateMenu();
                    } else {
                        tblMenuModel.setNumRows(0);
                        enabled = false;
                        updateMode();
                    }

                view.getTxtItem().setEnabled(enabled);
                view.getFtxtPrice().setEnabled(enabled);
                view.getBtnAddItem().setEnabled(enabled);
            }
        });

        this.view.getBtnAddItem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tblMenuModel.addRow(new Object[]{view.getTxtItem().getText(), ((Number) view.getFtxtPrice().getValue()).doubleValue()});
            }
        });

        this.view.getBtnCreateMenu().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Iterator<Item> iter = menu.getItems().iterator();

                while (iter.hasNext()) {
                    Item itm = iter.next();
                    iter.remove();
                }

                for (int i = 0; i < tblMenuModel.getRowCount(); i++) {
                    menu.addItem(new Item(tblMenuModel.getValueAt(i, 0).toString(), Double.parseDouble(tblMenuModel.getValueAt(i, 1).toString())));
                }
                if (!edit)
                    JOptionPane.showMessageDialog(view, "Menu created successfully", "Menu creation", JOptionPane.INFORMATION_MESSAGE);
                else
                    JOptionPane.showMessageDialog(view, "Menu updated successfully", "Menu update", JOptionPane.INFORMATION_MESSAGE);

                updateMode();
            }
        });

        this.view.getBtnDeleteMenu().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] options = {"Delete", "Cancel"};
                int response = JOptionPane.showOptionDialog(view,
                        "Are you sure you want to delete the entire menu?",
                        "Confirm deletion",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null, options, options[0]);

                if (response == 0) {
                    tblMenuModel.setNumRows(0);
                    view.getBtnCreateMenu().doClick();
                    updateMenu();
                }
            }
        });
    }

    private void updateMenu() {
        tblMenuModel.setNumRows(0);
        updateMode();

        if (menu.getItems().size() > 0 && menu.getItems() != null) {
            this.view.getBtnDeleteMenu().setVisible(true);
            for (Item item : menu.getItems()) {
                tblMenuModel.addRow(new Object[]{item.getName(), item.getPrice()});
                tblMenuModel.fireTableDataChanged();
            }
        }
    }

    private void updateMode() {
        edit = false;
        view.getLblViewTitle().setText("Create Menu");
        view.getBtnCreateMenu().setText("Create Menu");
        this.view.getBtnDeleteMenu().setVisible(false);

        try {
            if (menu.getItems().size() > 0 && menu.getItems() != null) {
                edit = true;
                view.getLblViewTitle().setText("Edit Menu");
                view.getBtnCreateMenu().setText("Edit Menu");
                this.view.getBtnDeleteMenu().setVisible(true);
            }
        } catch (Exception e) { }

    }

    public void showView() {
        view.getTxtItem().setEnabled(false);
        view.getFtxtPrice().setEnabled(false);
        view.getBtnAddItem().setEnabled(false);

        view.getListRestaurants().clearSelection();
        listModel.clear();
        for (Restaurant s : model.getRestaurants()) {
            listModel.addElement(s.getName());
        }

        if (!edit)
            this.view.getBtnDeleteMenu().setVisible(false);
        else
            this.view.getBtnDeleteMenu().setVisible(true);

        this.view.setVisible(true);
    }
}
