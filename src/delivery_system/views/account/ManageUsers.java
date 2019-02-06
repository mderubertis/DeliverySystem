/**
 *
 */
package delivery_system.views.account;

import delivery_system.Main;
import delivery_system.controller.AddAccountController;
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
import javax.swing.text.MaskFormatter;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * Delivery System
 *
 * @author Michael De Rubertis <m.derubertis@hotmail.com>
 * @date Jan. 30, 2019
 */
public class ManageUsers extends JDialog implements ActionListener {

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
    private final AccountDialog accountDialog;
    private ArrayList<String> usernames = new ArrayList<>();
    private User selectedUser;

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

        users.add("Select a user"); usernames.add("");

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
                        populateUsers();
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

        accountDialog = new AccountDialog();
        AddAccountController addAccountController = new AddAccountController(Main.getUsers(), accountDialog, true);
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
                switch (mode) {
                    case "add":
                        if (addAccountController.isValid()) {
                            accountDialog.setVisible(false);
                            User newUser = new User(Roles.CLIENT, accountDialog.getTxtFname().getText() + " " + accountDialog.getTxtLname().getText(), accountDialog.getTxtUsername().getText(), String.valueOf(accountDialog.getPasswordField().getPassword()), accountDialog.getTxtEmail().getText(), accountDialog.getTxtAddress().getText(), accountDialog.getPhone(), new Restaurant[] {Main.getRestaurants().getRestaurant(cmbRestaurants.getSelectedIndex() - 1)});
                            String[] rolesAvailable = {Roles.MANAGER, Roles.RESTAURATEUR, Roles.DELIVERY_MAN};
                            String selectedRole = (String) JOptionPane.showInputDialog(contentPanel, "Select the desired role for the user", "User role",
                                    JOptionPane.QUESTION_MESSAGE,
                                    null,
                                    rolesAvailable,
                                    rolesAvailable[0]);
                            newUser.setAccessLvl(selectedRole);

                            if (selectedRole.equals(Roles.DELIVERY_MAN)) {
                                JFormattedTextField inputField =
                                        null;
                                try {
                                    inputField = new JFormattedTextField(new MaskFormatter("#U#"));
                                } catch (ParseException e1) {
                                    e1.printStackTrace();
                                }

                                int response = JOptionPane.showOptionDialog(contentPanel,
                                        new Object[] { "Enter a delivery area:\n", inputField },
                                        "Enter delivery area",
                                        JOptionPane.OK_CANCEL_OPTION,
                                        JOptionPane.QUESTION_MESSAGE,
                                        null, null, null);

                                if (response == JOptionPane.OK_OPTION)
                                    newUser.setDeliveryArea(new String[]{String.valueOf(inputField != null ? inputField.getValue() : null)});
                            }

                            Main.getUsers().addUser(newUser);
                            populateUsers();

                            accountDialog.clear();
                        }
                        break;
                    case "edit":
                        if (addAccountController.isValid()) {
                            accountDialog.setVisible(false);
                            User newUser = new User(Roles.CLIENT, accountDialog.getTxtFname().getText() + " " + accountDialog.getTxtLname().getText(), accountDialog.getTxtUsername().getText(), String.valueOf(accountDialog.getPasswordField().getPassword()), accountDialog.getTxtEmail().getText(), accountDialog.getTxtAddress().getText(), accountDialog.getPhone(), new Restaurant[] {Main.getRestaurants().getRestaurant(cmbRestaurants.getSelectedIndex() - 1)});
                            String[] rolesAvailable = {Roles.MANAGER, Roles.RESTAURATEUR, Roles.DELIVERY_MAN};
                            String selectedRole = (String) JOptionPane.showInputDialog(contentPanel, "Select the desired role for the user", "User role",
                                    JOptionPane.QUESTION_MESSAGE,
                                    null,
                                    rolesAvailable,
                                    rolesAvailable[0]);
                            newUser.setAccessLvl(selectedRole);

                            if (selectedRole.equals(Roles.DELIVERY_MAN)) {
                                ArrayList<String> areas = new ArrayList<>();
                                if (selectedUser.getDeliveryArea().length > 0)
                                    Collections.addAll(areas, selectedUser.getDeliveryArea());

                                JPanel panAreas = new JPanel();
                                panAreas.setLayout(new FlowLayout(FlowLayout.CENTER));
                                JTextArea currentAreas = new JTextArea("");
                                if (selectedUser.getDeliveryArea().length > 0)
                                    currentAreas = new JTextArea(Arrays.toString(areas.toArray()).substring(1, Arrays.toString(areas.toArray()).length() - 1));

                                currentAreas.setEnabled(false);
                                currentAreas.setColumns(16);

                                JFormattedTextField inputField =
                                        null;
                                try {
                                    inputField = new JFormattedTextField(new MaskFormatter("#U#"));
                                    inputField.setColumns(3);
                                } catch (ParseException e1) {
                                    e1.printStackTrace();
                                }
                                panAreas.add(currentAreas);
                                panAreas.add(inputField);

                                JPanel panBtns = new JPanel();
                                JButton btnAddArea = new JButton("Add");

                                JFormattedTextField finalInputField = inputField;
                                JTextArea finalCurrentAreas = currentAreas;
                                btnAddArea.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        if (!finalInputField.getText().isEmpty()) {
                                            boolean exists = false;
                                            for (String devArea : areas)
                                                if (finalCurrentAreas.getText().contains(finalInputField.getText()))
                                                    exists = true;

                                            if (areas.size() < 24 && !exists && finalCurrentAreas.getText().trim().length() < 16)
                                                finalCurrentAreas.setText(finalCurrentAreas.getText() + (!finalCurrentAreas.getText().equals("") ? ", " : "") + finalInputField.getText());
                                        }
                                    }
                                });

                                JButton btnDelArea = new JButton("Delete");
                                btnDelArea.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        if (!finalInputField.getText().isEmpty()) {
                                            for (int i = 0; i < areas.size(); i++)
                                                if (areas.get(i).equals(finalInputField.getText()))
                                                    areas.remove(i);

                                            finalCurrentAreas.setText(String.join(", ", areas));
                                        }
                                    }
                                });
                                panBtns.add(btnAddArea);
                                panBtns.add(btnDelArea);

                                int response = JOptionPane.showOptionDialog(contentPanel,
                                        new Object[] { panAreas, panBtns },
                                        "Enter delivery area",
                                        JOptionPane.OK_CANCEL_OPTION,
                                        JOptionPane.QUESTION_MESSAGE,
                                        null, null, null);

                                if (response == JOptionPane.OK_OPTION)
                                    newUser.setDeliveryArea(finalCurrentAreas.getText().split(", "));
                            }

                            Main.getUsers().editUser(selectedUser, newUser);
                            populateUsers();

                            accountDialog.clear();
                        }
                        break;
                }
            }
        });

        btnAdd = new JButton("Add");
        btnAdd.addActionListener(this);
        btnAdd.setEnabled(false);
        panel_2.add(btnAdd);

        btnEdit = new JButton("Edit");
        btnEdit.addActionListener(this);
        btnEdit.setEnabled(false);
        panel_2.add(btnEdit);

        btnDelete = new JButton("Delete");
        btnDelete.addActionListener(this);
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
                cancelButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dispose();
                    }
                });
                buttonPane.add(cancelButton);
            }
        }
    }

    private void populateUsers() {
        users.clear(); usernames.clear();
        users.add("Select a user"); usernames.add("");
        if (cmbRestaurants.getSelectedIndex() > 0)
            for (User user : Main.getUsers().getUsers()) {
                if (user.getRestaurants() != null)
                    for (Restaurant restaurant : user.getRestaurants()) {
                        if (restaurant.getName() == cmbRestaurants.getSelectedItem()) {
                            users.add(user.getName() + " (" + user.getUsername() + ")");
                            usernames.add(user.getUsername());
                        }
                    }
            }
        cmbUsers.setModel(new DefaultComboBoxModel(users.toArray()));
        cmbUsers.setEnabled(users.size() > 1);
        btnAdd.setEnabled(cmbRestaurants.getSelectedIndex() > 0);
        btnEdit.setEnabled(cmbUsers.getSelectedIndex() > 0);
        btnDelete.setEnabled(cmbUsers.getSelectedIndex() > 0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btnFunc = (JButton) e.getSource();

        switch (btnFunc.getText()) {
            case "Add":
                mode = "add";
                accountDialog.clear();
                this.accountDialog.setVisible(true);
                break;
            case "Edit":
                mode = "edit";
                selectedUser = Main.getUsers().getUser(usernames.get(cmbUsers.getSelectedIndex()));

                String[] name = selectedUser.getName().split("\\s+");
                String fname = name[0];
                String lname = Arrays.stream(name, 1, name.length).collect(Collectors.joining(" "));

                this.accountDialog.getLblAvailable().setVisible(false);

                this.accountDialog.getTxtUsername().setText(selectedUser.getUsername());
                this.accountDialog.getTxtUsername().setEnabled(false);
                this.accountDialog.getTxtAddress().setText(selectedUser.getAddress());
                this.accountDialog.getTxtEmail().setText(selectedUser.getEmail());
                this.accountDialog.getTxtFname().setText(fname);
                this.accountDialog.getTxtLname().setText(lname);

                this.accountDialog.getTel1().setText(selectedUser.getPhone().substring(1,4));
                this.accountDialog.getTel2().setText(selectedUser.getPhone().substring(6,9));
                this.accountDialog.getTel3().setText(selectedUser.getPhone().substring(10,14));

                this.accountDialog.setVisible(true);
                break;
            case "Delete":
                Main.getUsers().delUser(Main.getUsers().getUser(usernames.get(cmbUsers.getSelectedIndex())));
                populateUsers();
                break;
        }
    }
}
