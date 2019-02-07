package delivery_system.controller;

import delivery_system.Main;
import delivery_system.model.menu.Item;
import delivery_system.model.orders.Order;
import delivery_system.model.orders.Orders;
import delivery_system.model.orders.Status;
import delivery_system.model.restaurants.Restaurant;
import delivery_system.model.users.User;
import delivery_system.views.DeliveryView;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Delivery System
 *
 * @author Michael De Rubertis <m.derubertis@hotmail.com>
 * @version 1.0
 * @date 2019-02-06
 */
public class DeliveryController {
    private final DefaultListModel listModel;
    User activeUser = Main.getUsers().getActiveUser();
    DeliveryView view;
    Orders model;
    ArrayList<Order> userOrders = new ArrayList<>();
    private Order currentOrder;

    public DeliveryController(Orders model, DeliveryView view) {
        this.model = model;
        this.view = view;

        listModel = new DefaultListModel<>();
        if (activeUser.getRestaurants() != null) {
            for (Restaurant restaurant : activeUser.getRestaurants()) {
                for (Order order : model.getOrders()) {
                    if (order.getRestaurant() == restaurant) {
                        listModel.addElement(order.getDeliveryDate() + " " + order.getDeliveryTime());
                        userOrders.add(order);
                    }
                }
            }
        }

        this.view.getListOrders().setModel(listModel);
        this.view.getListOrders().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    currentOrder = userOrders.get(view.getListOrders().getSelectedIndex());
                    updateView();
                }
            }
        });

        ActionListener btnListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton btn = (JButton) e.getSource();

                if (btn == view.getBtnAccept()) {
                    currentOrder.setStatus(Status.ACCEPTED);
                } else if (btn == view.getBtnDelivered()) {
                    currentOrder.setStatus(Status.DELIVERED);
                }

                updateView();
            }
        };

        this.view.getBtnAccept().addActionListener(btnListener);
        this.view.getBtnDelivered().addActionListener(btnListener);
    }

    private void updateView() {
        switch (currentOrder.getStatus()) {
            case Status.READY:
                view.getBtnAccept().setEnabled(true);
                view.getBtnDelivered().setEnabled(false);
                break;
            case Status.ACCEPTED:
                view.getBtnDelivered().setEnabled(true);
                view.getBtnAccept().setEnabled(false);
                break;
            default:
                view.getBtnAccept().setEnabled(false);
                view.getBtnDelivered().setEnabled(false);
                break;
        }

        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnCount(2);
        tableModel.addRow(new Object[]{"Order #", model.getOrders().indexOf(currentOrder)});
        tableModel.addRow(new Object[]{"Order Status", currentOrder.getStatus()});
        tableModel.addRow(new Object[]{"Restaurant", currentOrder.getRestaurant().getName()});
        tableModel.addRow(new Object[]{"Delivery Address", currentOrder.getDeliveryAddress()});
        tableModel.addRow(new Object[]{"Delivery Area", currentOrder.getDeliveryArea()});

        int items = 0;
        for (Item item : currentOrder.getItems()) {
            items += item.getQuantity();
        }

        tableModel.addRow(new Object[]{"Items in order", items});

        view.getTable().setModel(tableModel);

        if (currentOrder.getStatus().equals(Status.DELIVERED))
            JOptionPane.showMessageDialog(view, "Order is complete", "Order Complete", JOptionPane.INFORMATION_MESSAGE);
    }

    public void showView() {
        this.view.setVisible(true);
    }
}
