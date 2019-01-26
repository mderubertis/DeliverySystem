/**
 *
 */
package delivery_system.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.text.ParseException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

/**
 * Mod4Project
 *
 * @author Michael De Rubertis <m.derubertis@hotmail.com>
 * @date Jan. 26, 2019
 */
public class MenuView extends JPanel {
    private final JPanel mainPanel;
    private final JLabel lblViewTitle;
    private JTable table;
    private JTextField txtItem;

    /**
     * Create the panel.
     */
    public MenuView() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));

        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(0, 15, 0, 15));
        mainPanel.add(panel);
        panel.setLayout(new GridLayout(1, 2, 0, 0));

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new EmptyBorder(5, 0, 15, 0));
        panel.add(panel_1);
        panel_1.setLayout(new BorderLayout(0, 5));

        JLabel lblRestaurants = new JLabel("Restaurants");
        lblRestaurants.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblRestaurants.setHorizontalAlignment(SwingConstants.CENTER);
        panel_1.add(lblRestaurants, BorderLayout.NORTH);

        JList list = new JList();
        list.setModel(new AbstractListModel() {
            String[] values = new String[]{"test"};

            public int getSize() {
                return values.length;
            }

            public Object getElementAt(int index) {
                return values[index];
            }
        });
        panel_1.add(list);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JPanel panel_3 = new JPanel();
        panel_3.setBorder(new EmptyBorder(5, 30, 5, 30));
        panel.add(panel_3);
        panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));

        JPanel panel_10 = new JPanel();
        panel_3.add(panel_10);

        lblViewTitle = new JLabel("Create Menu");
        panel_10.add(lblViewTitle);
        lblViewTitle.setFont(new Font("Consolas", Font.BOLD, 30));

        JPanel panel_6 = new JPanel();
        panel_6.setPreferredSize(new Dimension(345, 250));
        panel_3.add(panel_6);
        panel_6.setLayout(new BorderLayout(0, 5));

        table = new JTable();
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setShowHorizontalLines(false);
        table.setModel(new DefaultTableModel(new Object[][]{{"Test", new Double(9.99)},},
                new String[]{"Item", "Price"}) {
            Class[] columnTypes = new Class[]{String.class, Double.class};

            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
        });
        table.getColumnModel().getColumn(1).setPreferredWidth(40);
        table.getColumnModel().getColumn(1).setMaxWidth(40);
        panel_6.add(table);

        JButton btnCreateMenu = new JButton("Create Menu");
        panel_6.add(btnCreateMenu, BorderLayout.SOUTH);

        JPanel panel_2 = new JPanel();
        panel_3.add(panel_2);
        panel_2.setLayout(new BorderLayout(0, 5));

        JLabel lblNewLabel_10 = new JLabel("Add Item");
        lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
        panel_2.add(lblNewLabel_10, BorderLayout.NORTH);
        lblNewLabel_10.setFont(new Font("Consolas", Font.BOLD, 22));

        JPanel panel_4 = new JPanel();
        panel_2.add(panel_4, BorderLayout.CENTER);

        JLabel lblItem = new JLabel("Item:");

        txtItem = new JTextField();
        txtItem.setText("item");
        txtItem.setColumns(10);

        JLabel lblPrice = new JLabel("Price:");

        JFormattedTextField frmtdtxtfldDouble = new JFormattedTextField();
        frmtdtxtfldDouble.setText("double");

        JButton btnAddItem = new JButton("Add Item");
        GroupLayout gl_panel_4 = new GroupLayout(panel_4);
        gl_panel_4.setHorizontalGroup(gl_panel_4.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(gl_panel_4
                .createSequentialGroup().addContainerGap()
                .addGroup(gl_panel_4.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(gl_panel_4.createSequentialGroup()
                        .addGroup(gl_panel_4
                                .createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(lblPrice).addComponent(lblItem))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(gl_panel_4.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(frmtdtxtfldDouble, GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                                .addComponent(txtItem, GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)))
                        .addComponent(btnAddItem, GroupLayout.Alignment.TRAILING))
                .addContainerGap()));
        gl_panel_4.setVerticalGroup(gl_panel_4.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(gl_panel_4
                .createSequentialGroup().addContainerGap()
                .addGroup(gl_panel_4.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(lblItem).addComponent(txtItem,
                        GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(gl_panel_4.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(lblPrice).addComponent(
                        frmtdtxtfldDouble, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                        GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(btnAddItem)
                .addContainerGap(126, Short.MAX_VALUE)));
        panel_4.setLayout(gl_panel_4);
    }

}
