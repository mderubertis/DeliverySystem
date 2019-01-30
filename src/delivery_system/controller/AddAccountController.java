package delivery_system.controller;

import delivery_system.model.users.User;
import delivery_system.model.users.Users;
import delivery_system.views.account.AddAccountDialog;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Delivery System
 *
 * @author Michael De Rubertis <m.derubertis@hotmail.com>
 * @version 1.0
 * @date 2019-01-28
 */
public class AddAccountController {
    Users model;
    AddAccountDialog view;

    public AddAccountController(Users model, AddAccountDialog view) {
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
        for (Component component : this.view.getPanForm().getComponents()) {
            System.out.println(component.getName());
            if (component instanceof JPanel) {
               for (Component field : ((JPanel) component).getComponents()) {

                   if (field instanceof JTextField)
                       System.out.println(field);
               }
           }

        }

        return false;
    }
}
