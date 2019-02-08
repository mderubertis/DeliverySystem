package delivery_system.views;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.MatteBorder;
import javax.swing.table.JTableHeader;
import javax.swing.text.DateFormatter;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 * Delivery System
 *
 * @author Michael De Rubertis <m.derubertis@hotmail.com>
 * @version 1.0
 * @date 2019-02-07
 */
public class ClientOrder extends JInternalFrame {

    private final JPanel mainPanel;
    private final JList listRestaurant;
    private final JTable menuTable;
    private final JTable orderTable;
    private final JTextField totalPrice;
    private final JButton btnOrder;
    private final JButton btnAdd;
    private final JButton btnDelete;
    private final JSpinner deliveryQuanity;
    private final JSpinner snDate;
    private JFormattedTextField postalcode;
    private final JTextField deliveryAddress;

    public ClientOrder() {
        super("Create an order", true, true, true, true);
//        setTitle("Client Order");
//        setIconifiable(true);
//        setMaximizable(true);
//        setRootPaneCheckingEnabled(false);
//        setResizable(true);
//        setClosable(true);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setMaximumSize(new Dimension(595, 490));

        mainPanel = new JPanel();
        // Creating Panel for restaurant area List

        listRestaurant = new JList();
        listRestaurant.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listRestaurant.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.LIGHT_GRAY));
        listRestaurant.setBackground(Color.WHITE);

        JScrollPane menuScrollPane = new JScrollPane();
        menuTable = new JTable();
        menuTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        menuTable.setFillsViewportHeight(true);
        menuTable.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.LIGHT_GRAY));
        menuTable.setBackground(Color.WHITE);
        menuScrollPane.setViewportView(menuTable);

        JTableHeader menuTableHeader = menuTable.getTableHeader();
        menuTableHeader.setReorderingAllowed(false);
        menuTableHeader.setResizingAllowed(false);
        menuScrollPane.setColumnHeaderView(menuTableHeader);

        JScrollPane orderScrollPane = new JScrollPane();
        orderTable = new JTable();
        orderTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        orderTable.setFillsViewportHeight(true);
        orderTable.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.LIGHT_GRAY));
        orderTable.setBackground(Color.WHITE);
        orderScrollPane.setViewportView(orderTable);

        JTableHeader orderTableHeader = orderTable.getTableHeader();
        orderTableHeader.setReorderingAllowed(false);
        orderTableHeader.setResizingAllowed(false);
        orderScrollPane.setColumnHeaderView(orderTableHeader);

        JLabel DeliveryDate = new JLabel("Delivery Date: ");

        JLabel quantity = new JLabel("Quantity: ");

        JLabel TotalPrice = new JLabel("Total:");

        totalPrice = new JTextField("$0.00");
        totalPrice.setEditable(false);
        //// buttons

        btnOrder = new JButton("Order");
        btnOrder.setEnabled(false);

        btnAdd = new JButton("Add");
        btnAdd.setEnabled(false);

        btnDelete = new JButton("Delete");
        btnDelete.setEnabled(false);

        JLabel PostalCode = new JLabel("Postal Code: ");

        JLabel DerliverAdd = new JLabel("Delivery Address: ");

        JLabel Restaurant = new JLabel("Restaurant");
        Restaurant.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel lblOrder = new JLabel("Order\r\n");

        JLabel lblMenu = new JLabel("Menu");
        lblMenu.setHorizontalAlignment(SwingConstants.CENTER);

        ///// textfield and combobox

        deliveryQuanity = new JSpinner();
        deliveryQuanity.setModel(new SpinnerNumberModel(1, 1, 15, 1));
        ///////

        //////


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        snDate = new JSpinner(new SpinnerDateModel());
        snDate.setValue(new Date(0));
        JSpinner.DateEditor editor = new JSpinner.DateEditor(snDate, sdf.toPattern());
        snDate.setEditor(editor);
        DateFormatter formatter = (DateFormatter) editor.getTextField().getFormatter();
        formatter.setAllowsInvalid(false);
        formatter.setOverwriteMode(true);


        try {
            postalcode = new JFormattedTextField(new MaskFormatter("#U#"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        setLayout(new BorderLayout(0, 0));

        deliveryAddress = new JTextField();

        this.add(mainPanel);
        GroupLayout gl_mainPanel = new GroupLayout(mainPanel);
        gl_mainPanel.setHorizontalGroup(
                gl_mainPanel.createParallelGroup(Alignment.TRAILING)
                        .addGroup(gl_mainPanel.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING, false)
                                        .addGroup(gl_mainPanel.createSequentialGroup()
                                                .addGap(210)
                                                .addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(DeliveryDate, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(gl_mainPanel.createSequentialGroup()
                                                                .addGap(10)
                                                                .addComponent(PostalCode, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)))
                                                .addGap(5)
                                                .addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(snDate, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(postalcode, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(gl_mainPanel.createSequentialGroup()
                                                .addGap(185)
                                                .addComponent(DerliverAdd, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                                                .addGap(5)
                                                .addComponent(deliveryAddress, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(btnOrder, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(gl_mainPanel.createSequentialGroup()
                                                .addGap(18)
                                                .addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING, false)
                                                        .addComponent(Restaurant, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(listRestaurant, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE))
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING, false)
                                                        .addComponent(lblMenu, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(menuScrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE))
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addGroup(gl_mainPanel.createParallelGroup(Alignment.TRAILING, false)
                                                        .addGroup(gl_mainPanel.createSequentialGroup()
                                                                .addComponent(quantity)
                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                .addComponent(deliveryQuanity, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(6))
                                                        .addGroup(gl_mainPanel.createSequentialGroup()
                                                                .addGroup(gl_mainPanel.createParallelGroup(Alignment.TRAILING, false)
                                                                        .addComponent(btnDelete, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(btnAdd, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(ComponentPlacement.RELATED))
                                                        .addGroup(gl_mainPanel.createSequentialGroup()
                                                                .addComponent(TotalPrice)
                                                                .addGap(4)))
                                                .addGroup(gl_mainPanel.createParallelGroup(Alignment.TRAILING, false)
                                                        .addComponent(orderScrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                                                        .addComponent(totalPrice, Alignment.LEADING)
                                                        .addComponent(lblOrder, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addContainerGap())
        );
        gl_mainPanel.setVerticalGroup(
                gl_mainPanel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_mainPanel.createSequentialGroup()
                                .addGap(24)
                                .addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
                                        .addComponent(DeliveryDate, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(gl_mainPanel.createSequentialGroup()
                                                .addGap(24)
                                                .addComponent(PostalCode, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_mainPanel.createSequentialGroup()
                                                .addGap(1)
                                                .addComponent(snDate, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                                                .addGap(2)
                                                .addComponent(postalcode, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)))
                                .addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
                                        .addComponent(DerliverAdd, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(gl_mainPanel.createSequentialGroup()
                                                .addGap(1)
                                                .addComponent(deliveryAddress, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)))
                                .addGap(27)
                                .addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(Restaurant, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblMenu, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblOrder, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_mainPanel.createSequentialGroup()
                                                .addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
                                                        .addGroup(gl_mainPanel.createSequentialGroup()
                                                                .addGap(31)
                                                                .addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE)
                                                                        .addComponent(quantity, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(deliveryQuanity, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(orderScrollPane, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE)
                                                        .addComponent(totalPrice, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(TotalPrice, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(listRestaurant, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(menuScrollPane, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnOrder, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                .addGap(64))
        );
        mainPanel.setLayout(gl_mainPanel);
    }

    public JList getListRestaurant() {
        return listRestaurant;
    }

    public JTable getMenuTable() {
        return menuTable;
    }

    public JTable getOrderTable() {
        return orderTable;
    }

    public JTextField getTotalPrice() {
        return totalPrice;
    }

    public JButton getBtnOrder() {
        return btnOrder;
    }

    public JButton getBtnAdd() {
        return btnAdd;
    }

    public JButton getBtnDelete() {
        return btnDelete;
    }

    public JSpinner getDeliveryQuanity() {
        return deliveryQuanity;
    }

    public JSpinner getSnDate() {
        return snDate;
    }

    public JFormattedTextField getPostalcode() {
        return postalcode;
    }

    public JTextField getDeliveryAddress() {
        return deliveryAddress;
    }
}
