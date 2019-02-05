/**
 *
 */
package delivery_system.views;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;

/**
 * Delivery System
 *
 * @author Michael De Rubertis <m.derubertis@hotmail.com>
 * @date Jan. 26, 2019
 */
public class MenuView extends JInternalFrame {
    private final JPanel mainPanel;
    private JTable tblMenu;
    private JTextField txtItem;
    private final JButton btnCreateMenu;
    private JFormattedTextField ftxtPrice;
    private final JButton btnDeleteMenu;
    private final JLabel lblViewTitle;
    private final JList listRestaurants;
    private NumberFormat priceFormat;
    private double price = 0.0;
    private final JButton btnAddItem;
    private final JPanel menuPanel;

    /**
     * Create the panel.
     */
    public MenuView() {
        setTitle("Menu Management");
        setIconifiable(true);
        setMaximizable(true);
        setRootPaneCheckingEnabled(false);
        setResizable(true);
        setClosable(true);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setMaximumSize(new Dimension(540, 460));

        mainPanel = new JPanel();
        getContentPane().add(mainPanel, BorderLayout.CENTER);

        JPanel panel = new JPanel();

        menuPanel = new JPanel();

        JSeparator separator = new JSeparator();
        separator.setOrientation(SwingConstants.VERTICAL);
        GroupLayout gl_mainPanel = new GroupLayout(mainPanel);
        gl_mainPanel.setHorizontalGroup(gl_mainPanel.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(gl_mainPanel.createSequentialGroup().addContainerGap()
                        .addComponent(panel, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)
                        .addGap(7).addComponent(menuPanel, GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                        .addContainerGap()));
        gl_mainPanel.setVerticalGroup(gl_mainPanel.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(gl_mainPanel
                .createSequentialGroup().addContainerGap()
                .addGroup(gl_mainPanel.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(menuPanel, GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                        .addComponent(separator, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                        .addComponent(panel, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE))
                .addGap(9)));
        menuPanel.setLayout(new BorderLayout(5, 5));

        JPanel panel_3 = new JPanel();
        menuPanel.add(panel_3, BorderLayout.WEST);

        lblViewTitle = new JLabel("Create Menu");
        lblViewTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblViewTitle.setFont(new Font("Segoe UI", Font.BOLD, 18));

        JScrollPane scrollPane = new JScrollPane();
        tblMenu = new JTable();
        tblMenu.setShowHorizontalLines(false);
        tblMenu.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblMenu.setFillsViewportHeight(true);
        tblMenu.setBorder(new LineBorder(Color.LIGHT_GRAY));
        scrollPane.setViewportView(tblMenu);

        JTableHeader tableHeader = tblMenu.getTableHeader();
        tableHeader.setReorderingAllowed(false);
        tableHeader.setResizingAllowed(false);
        scrollPane.setColumnHeaderView(tableHeader);

        GroupLayout gl_panel_3 = new GroupLayout(panel_3);
        gl_panel_3.setHorizontalGroup(gl_panel_3.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                .addGroup(gl_panel_3.createSequentialGroup().addGap(33).addComponent(lblViewTitle).addContainerGap(34,
                        Short.MAX_VALUE)));
        gl_panel_3.setVerticalGroup(gl_panel_3.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(gl_panel_3.createSequentialGroup()
                        .addComponent(lblViewTitle, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)));
        panel_3.setLayout(gl_panel_3);

        JPanel panel_2 = new JPanel();
        menuPanel.add(panel_2, BorderLayout.SOUTH);

        btnCreateMenu = new JButton("Create Menu");
        panel_2.add(btnCreateMenu);

        btnDeleteMenu = new JButton("Delete Menu");
        panel_2.add(btnDeleteMenu);

        JPanel panel_4 = new JPanel();
        menuPanel.add(panel_4, BorderLayout.CENTER);

        JLabel lblAddItem = new JLabel("Add Item");
        lblAddItem.setHorizontalAlignment(SwingConstants.CENTER);
        lblAddItem.setFont(new Font("Segoe UI", Font.BOLD, 16));

        JPanel panel_5 = new JPanel();
        panel_5.setLayout(new GridLayout(0, 1, 5, 5));

        JPanel panel_6 = new JPanel();
        panel_5.add(panel_6);
        panel_6.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JLabel lblItem = new JLabel("Item");
        panel_6.add(lblItem);
        lblItem.setHorizontalAlignment(SwingConstants.CENTER);
        lblItem.setHorizontalTextPosition(SwingConstants.LEADING);

        txtItem = new JTextField();
        panel_6.add(txtItem);
        txtItem.setColumns(10);

        JPanel panel_7 = new JPanel();
        panel_5.add(panel_7);

        JLabel lblPrice = new JLabel("Price $");
        panel_7.add(lblPrice);
        lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
        lblPrice.setHorizontalTextPosition(SwingConstants.LEADING);

        priceFormat = NumberFormat.getNumberInstance();
        priceFormat.setMinimumFractionDigits(2);

        ftxtPrice = new JFormattedTextField(priceFormat);
        ftxtPrice.setValue(price);
        ftxtPrice.setColumns(10);
        ftxtPrice.addPropertyChangeListener("value", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                ((Number) ftxtPrice.getValue()).doubleValue();
            }
        });
        panel_7.add(ftxtPrice);


        btnAddItem = new JButton("Add Item");
        GroupLayout gl_panel_4 = new GroupLayout(panel_4);
        gl_panel_4.setHorizontalGroup(
                gl_panel_4.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_panel_4.createSequentialGroup()
                                .addGap(67)
                                .addComponent(lblAddItem, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(62))
                        .addGroup(gl_panel_4.createSequentialGroup()
                                .addGap(63)
                                .addComponent(btnAddItem, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(59))
                        .addGroup(gl_panel_4.createSequentialGroup()
                                .addGap(37)
                                .addComponent(panel_5, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                                .addGap(25))
        );
        gl_panel_4.setVerticalGroup(
                gl_panel_4.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_panel_4.createSequentialGroup()
                                .addGap(5)
                                .addComponent(lblAddItem)
                                .addGap(5)
                                .addComponent(panel_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(5)
                                .addComponent(btnAddItem)
                                .addContainerGap(259, Short.MAX_VALUE))
        );
        panel_4.setLayout(gl_panel_4);
        panel.setLayout(new BorderLayout(0, 5));

        JLabel lblRestaurants = new JLabel("Restaurants");
        lblRestaurants.setHorizontalAlignment(SwingConstants.CENTER);
        lblRestaurants.setFont(new Font("Segoe UI", Font.BOLD, 14));
        panel.add(lblRestaurants, BorderLayout.NORTH);

        listRestaurants = new JList();
        listRestaurants.setBorder(new LineBorder(Color.LIGHT_GRAY));

        panel.add(listRestaurants);
        mainPanel.setLayout(gl_mainPanel);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JLabel getLblViewTitle() {
        return lblViewTitle;
    }

    public JTable getTblMenu() {
        return tblMenu;
    }

    public JPanel getMenuPanel() {
        return menuPanel;
    }

    public JButton getBtnAddItem() {
        return btnAddItem;
    }

    public JButton getBtnDeleteMenu() {
        return btnDeleteMenu;
    }

    public JList getListRestaurants() {
        return listRestaurants;
    }

    public JTextField getTxtItem() {
        return txtItem;
    }

    public JFormattedTextField getFtxtPrice() {
        return ftxtPrice;
    }

    public JButton getBtnCreateMenu() {
        return btnCreateMenu;
    }
}
