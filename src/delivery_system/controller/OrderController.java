package delivery_system.controller;

import delivery_system.Main;
import delivery_system.model.menu.Item;
import delivery_system.model.orders.Order;
import delivery_system.model.orders.Orders;
import delivery_system.model.orders.Status;
import delivery_system.model.restaurants.Restaurant;
import delivery_system.model.restaurants.Restaurants;
import delivery_system.model.users.Roles;
import delivery_system.model.users.User;
import delivery_system.views.OrderView;
import delivery_system.views.RestoManageView;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Date;

/**
 * Delivery System
 *
 * @author Michael De Rubertis <m.derubertis@hotmail.com>
 * @version 1.0
 * @date 2019-01-30
 */
class OrderController {
    private boolean noOrders;
    private DefaultListModel listModel;
    private DefaultTableModel orderTbl;
    Orders model;
    OrderView view;
    Order currentOrder;
    User activeUser = Main.getUsers().getActiveUser();
    private String[] orders;

    OrderController(Orders model, OrderView view) {
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
        this.view.setSize(new Dimension(825, 585));

        listModel = new DefaultListModel<>();
        for (Restaurant restaurant : activeUser.getRestaurants()) {
            for (Order order : model.getOrders()) {
                if (order.getRestaurant() == restaurant) {
                    listModel.addElement(order.getDeliveryDate() + " " + order.getDeliveryTime());
                }
            }
        }

        this.view.getList().setModel(listModel);
        this.view.getList().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    viewUpdate();
                }
            }
        });

        orderTbl = new DefaultTableModel(new Object[][]{{null, null},}, new String[]{"Item", "Quantity"}) {
            Class[] columnTypes = new Class[]{String.class, Double.class};

            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
        };

        this.view.getTable().setModel(orderTbl);
        this.view.getTable().getColumnModel().getColumn(0).setResizable(false);
        this.view.getTable().getColumnModel().getColumn(0).setPreferredWidth(175);
        this.view.getTable().getColumnModel().getColumn(1).setResizable(false);
        this.view.getTable().getColumnModel().getColumn(1).setPreferredWidth(55);
        this.view.getTable().getColumnModel().getColumn(1).setMaxWidth(55);

        this.view.getBtnAcceptOrder().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentOrder.setStatus(Status.ACCEPTED);
                viewUpdate();
            }
        });

        this.view.getBtnOrderReady().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentOrder.setStatus(Status.READY);
                viewUpdate();
            }
        });
    }

    private void viewUpdate() {
        orderTbl.setNumRows(0);
        currentOrder = model.getOrder(view.getList().getSelectedIndex());
        for (int i = 0; i < currentOrder.getItems().length; i++) {
            orderTbl.addRow(new Object[]{currentOrder.getItems()[i].getName(), currentOrder.getItems()[i].getQuantity()});
            orderTbl.fireTableDataChanged();
        }

        view.getSnDate().setValue(new Date(currentOrder.getDeliveryDate() + " " + currentOrder.getDeliveryTime()));
        view.getFtxtPostal().setValue(currentOrder.getDeliveryArea());
        view.getTxtStatus().setText(currentOrder.getStatus());
        switch (currentOrder.getStatus()) {
            case Status.WAITING:
                view.getBtnAcceptOrder().setEnabled(true);
                view.getBtnOrderReady().setEnabled(false);
                break;
            case Status.ACCEPTED:
                view.getBtnAcceptOrder().setEnabled(false);
                view.getBtnOrderReady().setEnabled(true);
                break;
            case Status.READY:
                view.getBtnAcceptOrder().setEnabled(false);
                view.getBtnOrderReady().setEnabled(false);
                break;
        }
    }

    public void showView() {
        this.view.setVisible(true);
    }
}
