package delivery_system.controller;

import delivery_system.Main;
import delivery_system.model.users.User;
import delivery_system.model.users.Users;
import delivery_system.views.account.LoginView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

/**
 * Delivery System
 *
 * @author Michael De Rubertis <m.derubertis@hotmail.com>
 * @version 1.0
 * @date 2019-01-17
 */

public class LoginController {
    Users model = new Users();
    LoginView view;

    public LoginController(Users model, LoginView view) {
        this.model = model;
        this.view = view;

        view.getBtnConnect().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    User user = model.getUser(view.getTxtUsername().getText());
                    if (user.getPassword().equals(view.getPwdPassword().getText())) {
                        model.setActiveUser(user);
                        Main.login();
                    } else {
                        JOptionPane.showMessageDialog(view, "Invalid password", "Login Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NullPointerException npe) {
                    npe.printStackTrace();
                    JOptionPane.showMessageDialog(view, "Invalid username", "Login Error",
                            JOptionPane.ERROR_MESSAGE);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

        view.getBtnQuit().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.shutdown();
            }
        });
    }
}
