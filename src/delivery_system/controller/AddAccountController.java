package delivery_system.controller;

import delivery_system.model.users.User;
import delivery_system.model.users.Users;
import delivery_system.views.account.AccountDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Delivery System
 *
 * @author Michael De Rubertis <m.derubertis@hotmail.com>
 * @version 1.0
 * @date 2019-01-28
 */
public class AddAccountController {
    Users model;
    AccountDialog view;

    public AddAccountController(Users model, AccountDialog view) {
        this.model = model;
        this.view = view;

        ImageIcon taken = new ImageIcon(getClass().getResource("/delivery_system/assets/icons8-cancel-24.png"));
        ImageIcon available = new ImageIcon(getClass().getResource("/delivery_system/assets/icons8-ok-24.png"));

        this.view.getTxtUsername().addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                JTextField txtUsername = (JTextField) e.getSource();
                User userSearch = model.getUser(txtUsername.getText());
                if (userSearch != null && userSearch.getUsername().equals(txtUsername.getText())) {
                    view.getLblAvailable().setIcon(taken);
                } else {
                    view.getLblAvailable().setIcon(available);
                }
            }
        });

        this.view.getOkButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isValid()) {

                }
            }
        });

        this.view.setVisible(true);
    }

    private boolean isValid() {
        ArrayList<String> valid = new ArrayList<>();
        int phonePos = 0;

        for (Component component : this.view.getPanForm().getComponents()) {
            boolean fieldError = false;

            if (component instanceof JPanel) {
                for (Component field : ((JPanel) component).getComponents()) {
                    if (field instanceof JTextField) {
                        if (component.getName().equals("panPhone")) {
                            if (((JTextField) field).getText().trim().length() < 3 && phonePos < 2)
                                fieldError = true;
                            else if (((JTextField) field).getText().trim().length() < 4 && phonePos == 2)
                                fieldError = true;
                            else
                                valid.add(component.getName());

                            phonePos++;
                        } else if (component.getName().equals("panPwd") || component.getName().equals("panPwdConf")) {
                            if (Arrays.equals(view.getPasswordField().getPassword(), view.getPwdConfirmPassowrd().getPassword()) && view.getPasswordField().getPassword().length >= 8)
                                valid.add(component.getName());
                            else
                                fieldError = true;
                        } else {
                            String fieldValue = ((JTextField) field).getText();
                            if (fieldValue.trim().length() < 5)
                                fieldError = true;
                            else
                                valid.add(component.getName());
                        }
                    }
                }
            }

            if (fieldError) {
                JOptionPane.showMessageDialog(null, "Error on field: " + component.getName().replace("pan", ""), "Field Value Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        return valid.size() == 10;
    }
}
