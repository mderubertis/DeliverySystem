package delivery_system.views.account;

import delivery_system.controller.AddAccountController;
import delivery_system.controller.LoginController;
import delivery_system.model.users.Users;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.swing.*;

public class AccountFrame {
    private Users model;
    private JFrame frame;
    public JButton btnConnect;
    public JButton btnNewClient;
    public JButton btnQuit;

    /**
     * Create the application.
     */
    public AccountFrame(Users model) {
        this.model = model;
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setResizable(false);
        frame.setTitle("User Authentication");
        frame.setBounds(100, 100, 415, 230);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ArrayList<Image> images = new ArrayList<>();
        images.add(new ImageIcon(getClass().getResource("/delivery_system/assets/icons8-password-16.png")).getImage());
        images.add(new ImageIcon(getClass().getResource("/delivery_system/assets/icons8-meal-48.png")).getImage());

        try {
            Class<?> [] types = {java.util.List.class};
            Method method = Class.forName("java.awt.Window").getDeclaredMethod("setIconImages", types);

            Object [] parameters = {images};
            method.invoke(frame, parameters);
        } catch (Exception e) {
            frame.setIconImage(images.get(0));
        }

        LoginView loginView = new LoginView();
        LoginController loginController = new LoginController(model, loginView);
        loginView.getBtnNewClient().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                AccountDialog addAccountDialog = new AccountDialog();
                AddAccountController addAccountController = new AddAccountController(model, addAccountDialog);
            }
        });
        frame.add(loginView, BorderLayout.CENTER);
        frame.setVisible(true);

        JRootPane rootPane = SwingUtilities.getRootPane(loginView);
        rootPane.setDefaultButton(loginView.getBtnConnect());
    }


    public void dispose() {
        frame.dispose();
    }
}
