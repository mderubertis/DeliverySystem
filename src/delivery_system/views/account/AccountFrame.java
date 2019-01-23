package delivery_system.views.account;

import delivery_system.controller.account.LoginController;
import delivery_system.model.users.Users;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AccountFrame {
	private Users users;
	private JFrame frame;
	public JButton btnConnect;
	public JButton btnNewClient;
	public JButton btnQuit;

	/**
	 * Create the application.
	 */
	public AccountFrame(Users model) {
		this.users = model;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
        frame.setResizable(false);
		frame.setTitle("User Authentication");
		frame.setBounds(100, 100, 895, 689);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		LoginView loginView = new LoginView();
        LoginController loginController = new LoginController(users, loginView);
		loginView.getBtnNewClient().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("New Account");
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
