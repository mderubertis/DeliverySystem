package delivery_system.controller;

import delivery_system.Main;
import delivery_system.model.menu.Item;
import delivery_system.model.menu.Menu;
import delivery_system.model.orders.Order;
import delivery_system.model.orders.Status;
import delivery_system.model.restaurants.Restaurant;
import delivery_system.model.restaurants.Restaurants;
import delivery_system.views.ClientOrder;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * Delivery System
 *
 * @author Michael De Rubertis <m.derubertis@hotmail.com>
 * @version 1.0
 * @date 2019-02-07
 */
public class ClientOrderController {
    Restaurants model;
    ClientOrder view;

    Restaurant selectedResto;
    private DefaultTableModel menuTableModel;
    private final DefaultTableModel orderTableModel;

    public ClientOrderController(Restaurants model, ClientOrder view) {
        this.model = model;
        this.view = view;

        view.setBounds(100, 100, 200, 200);
        view.setSize(view.getMaximumSize());

        menuTableModel = new DefaultTableModel(new Object[][]{}, new String[]{"Item", "Price"}) {
            Class[] columnTypes = new Class[]{String.class, Double.class};

            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };

        orderTableModel = new DefaultTableModel(new Object[][]{}, new String[]{"Item", "Quantity"}) {
            Class[] columnTypes = new Class[]{String.class, Integer.class};

            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return columnIndex != 0;
            }
        };
        orderTableModel.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                double total = 0;

                for (int i = 0; i < view.getOrderTable().getRowCount(); i++) {
                    for (Restaurant restaurant : model.getRestaurants()) {
                        for (Item item : restaurant.getMenu().getItems()) {
                            if (item.getName().equals(orderTableModel.getValueAt(i, 0)))
                                total += Double.parseDouble(orderTableModel.getValueAt(i, 1).toString()) * item.getPrice();
                        }
                    }
                }

                total = new Double(new DecimalFormat("#,###,###,##0.00").format(total));
                view.getTotalPrice().setText("$" + total);
            }
        });

        view.getMenuTable().setModel(menuTableModel);
        view.getMenuTable().getColumnModel().getColumn(1).setMaxWidth(40);
        view.getMenuTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                view.getBtnAdd().setEnabled(view.getMenuTable().getSelectedRow() >= 0);
            }
        });

        view.getOrderTable().setModel(orderTableModel);
        view.getOrderTable().getColumnModel().getColumn(1).setMaxWidth(55);
        view.getOrderTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                view.getBtnDelete().setEnabled(view.getOrderTable().getSelectedRow() >= 0);
                view.getBtnOrder().setEnabled(view.getOrderTable().getRowCount() >= 1);
            }
        });

        view.getListRestaurant().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    selectedResto = model.getRestaurant(view.getListRestaurant().getSelectedIndex());
                    orderTableModel.setRowCount(0);
                    populateMenu();
                }
            }
        });

        view.getBtnAdd().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (view.getOrderTable().getRowCount() >= 1 && view.getOrderTable().getValueAt(view.getOrderTable().getRowCount() - 1, 0).equals(selectedResto.getMenu().getItem(view.getMenuTable().getSelectedRow()).getName())) {
                    if (menuTableModel.getRowCount() >= 1) {
                        orderTableModel.setValueAt(view.getDeliveryQuanity().getValue(), view.getOrderTable().getRowCount() - 1, 1);
                    }
                } else {
                    if (menuTableModel.getRowCount() >= 1) {
                        orderTableModel.addRow(new Object[]{selectedResto.getMenu().getItem(view.getMenuTable().getSelectedRow()).getName(), view.getDeliveryQuanity().getValue()});
                    }
                }
            }
        });

        view.getBtnDelete().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (view.getOrderTable().getSelectedRow() >= 0)
                    orderTableModel.removeRow(view.getOrderTable().getSelectedRow());
            }
        });

        view.getBtnOrder().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int respoonse = JOptionPane.showConfirmDialog(view, "Are you sure you want to place your order? Your total amount is: " + view.getTotalPrice().getText(), "Confirm order", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                if (respoonse == JOptionPane.YES_OPTION) {
                    String deliveryDateTime = new SimpleDateFormat("yyyy/MM/dd HH:mm").format(view.getSnDate().getValue());
                    if (view.getSnDate().getValue() != new Date(0) && !view.getDeliveryAddress().getText().trim().equals("") && orderTableModel.getRowCount() >= 1 && !view.getPostalcode().getValue().toString().trim().isEmpty()) {
                        Item[] items = new Item[view.getOrderTable().getRowCount()];
                        for (int i = 0; i < view.getOrderTable().getRowCount(); i++) {
                                for (Item item : selectedResto.getMenu().getItems()) {
                                    if (item.getName().equals(orderTableModel.getValueAt(i, 0))) {
                                        items[i] = item;
                                        items[i].setQuantity(Double.parseDouble(String.valueOf(orderTableModel.getValueAt(i, 1))));
                                    }
                                }
                        }

                        Main.getOrders().addOrder(new Order(Status.WAITING, deliveryDateTime.split(" ")[0], deliveryDateTime.split(" ")[1], selectedResto, items, "(000) 000-0000", view.getPostalcode().getText(), view.getDeliveryAddress().getText()));
                    }
                }
            }
        });
    }

    public void showView() {
        populateRestaurants();

        view.setVisible(true);
    }

    public void populateRestaurants() {
        DefaultListModel listModel = new DefaultListModel();

        for (Restaurant restaurant : model.getRestaurants()) {
            listModel.addElement(restaurant.getName());
        }

        view.getListRestaurant().setModel(listModel);
    }

    public void populateMenu() {
        menuTableModel.setNumRows(0);
        Menu menu = selectedResto.getMenu();

        if (menu.getItems().size() > 0 && menu.getItems() != null) {
            for (Item items : menu.getItems()) {
                menuTableModel.addRow(new Object[]{items.getName(), items.getPrice()});
            }
        }
    }
}
