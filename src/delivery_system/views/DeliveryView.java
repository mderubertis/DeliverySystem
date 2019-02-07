package delivery_system.views;

import java.awt.*;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class DeliveryView extends JInternalFrame{
    private final JTable table;
    private final JList listOrders;
    private final JButton btnAccept;
    private final JButton btnDelivered;

    /**
	 * Initialize the contents of the frame.
	 */
    public DeliveryView() {
		setTitle("Delivery Management");
		setIconifiable(true);
		setMaximizable(true);
		setRootPaneCheckingEnabled(false);
		setResizable(true);
		setClosable(true);
		setBounds(100, 100, 480, 460);
		setDefaultCloseOperation(HIDE_ON_CLOSE);

        JLabel lbl_ViewDelivery_Order = new JLabel("Order");
        lbl_ViewDelivery_Order.setFont(new Font("Tahoma", Font.BOLD, 13));

        listOrders = new JList();
        listOrders.setBorder(new LineBorder(Color.LIGHT_GRAY));

        JLabel lbl_ViewDelivery = new JLabel("View Delivery");
        lbl_ViewDelivery.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_ViewDelivery.setFont(new Font("Tahoma", Font.BOLD, 16));

        JPanel panel = new JPanel();
        panel.setBorder(new MatteBorder(1, 0, 0, 0, (Color) Color.LIGHT_GRAY));
        FlowLayout flowLayout = (FlowLayout) panel.getLayout();
        flowLayout.setAlignment(FlowLayout.TRAILING);

        table = new JTable();
        table.setBorder(new LineBorder(Color.LIGHT_GRAY));
        table.setShowHorizontalLines(false);
        table.setShowVerticalLines(false);
        table.setEnabled(false);
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addGap(35)
                                                .addComponent(lbl_ViewDelivery_Order))
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(listOrders, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
                                        .addComponent(lbl_ViewDelivery, GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
                                        .addComponent(table, GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE))
                                .addContainerGap())
                        .addComponent(panel, GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
        );
        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(10)
                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lbl_ViewDelivery_Order)
                                        .addComponent(lbl_ViewDelivery, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
                                        .addComponent(listOrders, GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
                                        .addComponent(table, GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(panel, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        btnAccept = new JButton("Accept");
        btnAccept.setEnabled(false);
        panel.add(btnAccept);

        btnDelivered = new JButton("Delivered");
        btnDelivered.setEnabled(false);
        panel.add(btnDelivered);

		getContentPane().setLayout(groupLayout);
	}

    public JTable getTable() {
        return table;
    }

    public JList getListOrders() {
        return listOrders;
    }

    public JButton getBtnAccept() {
        return btnAccept;
    }

    public JButton getBtnDelivered() {
        return btnDelivered;
    }
}
