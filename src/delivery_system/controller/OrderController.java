package delivery_system.controller;

import delivery_system.model.menu.Item;
import delivery_system.model.orders.Order;
import delivery_system.model.orders.Orders;
import delivery_system.model.restaurants.Restaurant;
import delivery_system.model.restaurants.Restaurants;
import delivery_system.views.OrderView;
import delivery_system.views.RestoManageView;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.net.URL;

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

        String[] orders = new String[model.getOrders().size()];
        if (model.getOrders().size() == 0) {
            noOrders = true;
            orders = new String[1];
            orders[0] = "No restaurants";
        } else {
            noOrders = false;
            for (int i = 0; i < model.getOrders().size(); i++)
                orders[i] = (i + 1) + " - " + model.getOrder(i).getDeliveryDate() + " " + model.getOrder(i).getDeliveryTime();

        }

        listModel = new DefaultListModel<>();
        for (String s : orders) {
            listModel.addElement(s);
        }
        this.view.getList().setModel(listModel);
        this.view.getList().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    orderTbl.setNumRows(0);
                    Order order = model.getOrder(view.getList().getSelectedIndex());
                    for (int i = 0; i < order.getItems().length; i++) {
                        orderTbl.addRow(new Object[]{order.getItems()[i].getName(), order.getItems()[i].getPrice()});
                        orderTbl.fireTableDataChanged();
                    }
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
    }

    public void showView() {
        this.view.setVisible(true);
    }
}
