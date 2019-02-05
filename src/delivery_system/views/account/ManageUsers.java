/**
 *
 */
package delivery_system.views.account;

import delivery_system.Main;
import delivery_system.model.restaurants.Restaurant;
import delivery_system.model.users.Roles;
import delivery_system.model.users.User;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * Delivery System
 *
 * @author Michael De Rubertis <m.derubertis@hotmail.com>
 * @date Jan. 30, 2019
 */
public class ManageUsers extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private ArrayList<String> users = new ArrayList<>();
    private JPanel panel_1;
    private JPanel panel;
    private final JComboBox cmbRestaurants;
    private final JComboBox cmbUsers;
    private final JButton btnAdd;
    private final JButton btnEdit;
    private final JButton btnDelete;
    private String mode;

    /**
     * Create the dialog.
     */
    public ManageUsers() {
        setTitle("Manage Users");
        setResizable(false);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setModal(true);
        setModalityType(ModalityType.APPLICATION_MODAL);
        setMaximumSize(new Dimension(450, 195));
        setSize(new Dimension(450, 195));
        setLocationRelativeTo(getParent());
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);

        users.add("Select a user");

        {
            panel_1 = new JPanel();
            panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
            {
                JLabel lblSelectRestaurant = new JLabel("Select restaurant");
                panel_1.add(lblSelectRestaurant);
            }
            {
                cmbRestaurants = new JComboBox();
                panel_1.add(cmbRestaurants);
                cmbRestaurants.setModel(new DefaultComboBoxModel(new String[]{"Select restaurant"}));
                for (Restaurant restaurant : Main.getRestaurants().getRestaurants()) {
                    cmbRestaurants.addItem(restaurant.getName());
                }
                cmbRestaurants.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        users.clear();
                        users.add("Select a user");
                        if (cmbRestaurants.getSelectedIndex() > 0)
                            for (User user : Main.getUsers().getUsers()) {
                                if (user.getRestaurants() != null)
                                    for (Restaurant restaurant : user.getRestaurants()) {
                                        if (restaurant.getName() == cmbRestaurants.getSelectedItem())
                                            users.add(user.getName() + " (" + user.getUsername() + ")");
                                    }
                            }
                        cmbUsers.setModel(new DefaultComboBoxModel(users.toArray()));
                        cmbUsers.setEnabled(users.size() > 1);
                        btnAdd.setEnabled(cmbRestaurants.getSelectedIndex() > 0);
                        btnEdit.setEnabled(cmbUsers.getSelectedIndex() > 0);
                        btnDelete.setEnabled(cmbUsers.getSelectedIndex() > 0);
                    }
                });
            }
        }
        {
            panel = new JPanel();
            {
                JLabel lblSelectUser = new JLabel("Select User");
                panel.add(lblSelectUser);
            }
            {
                cmbUsers = new JComboBox();
                cmbUsers.setModel(new DefaultComboBoxModel(users.toArray()));
                cmbUsers.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        btnEdit.setEnabled(cmbUsers.getSelectedIndex() > 0);
                        btnDelete.setEnabled(cmbUsers.getSelectedIndex() > 0);
                    }
                });
                cmbUsers.setEnabled(false);
                panel.add(cmbUsers);
            }
        }

        JPanel panel_2 = new JPanel();
        GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
        gl_contentPanel.setHorizontalGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
                .addGroup(gl_contentPanel.createSequentialGroup().addContainerGap()
                        .addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
                                .addComponent(panel, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                                .addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                                .addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE))
                        .addContainerGap()));
        gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPanel
                .createSequentialGroup()
                .addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE)));

//        JLabel lblRole = new JLabel("Role");
//        panel.add(lblRole);
//
//        JComboBox comboBox = new JComboBox(new DefaultComboBoxModel(new String[]{"Select role", Roles.ADMINISTRATOR, Roles.MANAGER, Roles.RESTAURATEUR}));
//        comboBox.setEnabled(false);
//        panel.add(comboBox);

        AccountDialog accountDialog = new AccountDialog();
        ImageIcon taken = new ImageIcon(getClass().getResource("/delivery_system/assets/icons8-cancel-24.png"));
        ImageIcon available = new ImageIcon(getClass().getResource("/delivery_system/assets/icons8-ok-24.png"));

        accountDialog.getTxtUsername().addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                JTextField txtUsername = (JTextField) e.getSource();
                User userSearch = Main.getUsers().getUser(txtUsername.getText());
                if (userSearch != null && userSearch.getUsername().equals(txtUsername.getText())) {
                    accountDialog.getLblAvailable().setIcon(taken);
                } else {
                    accountDialog.getLblAvailable().setIcon(available);
                }
            }
        });

        accountDialog.getOkButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User newUser = new User(Roles.CLIENT, accountDialog.getTxtFname().getText() + " " + accountDialog.getTxtLname().getText(), accountDialog.getTxtUsername().getText(), accountDialog.getPasswordField().getPassword().toString(), accountDialog.getTxtEmail().getText(), accountDialog.getTxtAddress().getText(), accountDialog.getPhone());
                switch (mode) {
                    case "add":
                        String[] rolesAvailable = { Roles.MANAGER, Roles.RESTAURATEUR, Roles.DELIVERY_MAN };
                        String selectedValue = (String) JOptionPane.showInputDialog( accountDialog, "Select the desired role for the user", "User role",
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                rolesAvailable,
                                rolesAvailable[ 0 ] );
                        newUser.setAccessLvl(selectedValue);
                        System.out.println(newUser.getAccessLvl());
                        break;
                }
            }
        });

        btnAdd = new JButton("Add");
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mode = "add";
                accountDialog.setVisible(true);
            }
        });
        btnAdd.setEnabled(false);
        panel_2.add(btnAdd);

        btnEdit = new JButton("Edit");
        btnEdit.setEnabled(false);
        panel_2.add(btnEdit);

        btnDelete = new JButton("Delete");
        btnDelete.setEnabled(false);
        panel_2.add(btnDelete);
        contentPanel.setLayout(gl_contentPanel);
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setBorder(new MatteBorder(1, 0, 0, 0, (Color) Color.LIGHT_GRAY));
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton cancelButton = new JButton("Cancel");
                cancelButton.setActionCommand("Cancel");
                buttonPane.add(cancelButton);
            }
        }
    }
}
