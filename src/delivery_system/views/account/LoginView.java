package delivery_system.views.account;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class LoginView extends JPanel {
	private JTextField txtUsername;
	private JPasswordField pwdPassword;
	public JButton btnConnect;
	public JButton btnNewClient;

    public JTextField getTxtUsername() {
        return txtUsername;
    }

    public JPasswordField getPwdPassword() {
        return pwdPassword;
    }

    public JButton getBtnNewClient() {
        return btnNewClient;
    }

    public JButton btnQuit;

	public JButton getBtnConnect() {
		return btnConnect;
	}

	public JButton getBtnQuit() {
		return btnQuit;
	}

	public LoginView() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        setLayout(new BorderLayout(0, 0));
        JPanel panel = new JPanel();
        this.add(panel, BorderLayout.NORTH);

        JLabel lblDeliverySystem = new JLabel("Delivery System");
        lblDeliverySystem.setFont(new Font("Consolas", Font.PLAIN, 35));
        lblDeliverySystem.setPreferredSize(new Dimension(300, 45));
        panel.add(lblDeliverySystem);

        JPanel panel_1 = new JPanel();
        panel_1.setAlignmentX(Component.RIGHT_ALIGNMENT);
        this.add(panel_1, BorderLayout.SOUTH);
        panel_1.setLayout(new BorderLayout(0, 0));

        JPanel panel_3 = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
        flowLayout.setAlignment(FlowLayout.RIGHT);
        panel_1.add(panel_3, BorderLayout.SOUTH);

        btnConnect = new JButton("Connect");
        panel_3.add(btnConnect);

        btnNewClient = new JButton("New Clients");
        panel_3.add(btnNewClient);

        btnQuit = new JButton("Quit");
        panel_3.add(btnQuit);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBorder(new EmptyBorder(30, 0, 30, 0));
        this.add(panel_2);
        panel_2.setLayout(new GridLayout(0, 1, 0, 0));

        JPanel panel_4 = new JPanel();
        panel_4.setPreferredSize(new Dimension(10, 40));
        panel_2.add(panel_4);

        JLabel lblUsername = new JLabel("Username: ");
        panel_4.add(lblUsername);

        txtUsername = new JTextField();
        panel_4.add(txtUsername);
        txtUsername.setColumns(10);

        JPanel panel_5 = new JPanel();
        panel_5.setPreferredSize(new Dimension(10, 40));
        panel_2.add(panel_5);

        JLabel lblPassword = new JLabel("Password: ");
        panel_5.add(lblPassword);

        pwdPassword = new JPasswordField();
        panel_5.add(pwdPassword);
        pwdPassword.setColumns(10);

	}



}
