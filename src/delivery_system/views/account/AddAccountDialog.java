/**
 * 
 */
package delivery_system.views.account;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

/**
 * Mod4Project
 * 
 * @author Michael De Rubertis <m.derubertis@hotmail.com>
 * @date Jan. 28, 2019
 *
 */
public class AddAccountDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtUsername;
	private JPasswordField passwordField;
	private JPasswordField pwdConfirmPassowrd;
	private JTextField txtFname;
	private JTextField txtLname;
	private JTextField txtAddress;
	private JTextField txtEmail;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
    private final JButton okButton;
    private final JLabel lblAvailable;
    private final JPanel panForm;

    /**
	 * Create the dialog.
	 */
	public AddAccountDialog() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\mderubertis\\Dropbox\\Project\\DeliverySystem\\src\\delivery_system\\assets\\icons8-customer-48.png"));
		setTitle("Create Account");
		setResizable(false);
		setModal(true);
		setMaximumSize(new Dimension(500, 480));
		setSize(445, 470);
		setLocationRelativeTo(getParent());
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        {
            JLabel lblCreateAnAccount = new JLabel("Create an account");
            lblCreateAnAccount.setFont(new Font("Segoe UI", Font.BOLD, 18));
            contentPanel.add(lblCreateAnAccount);
        }
        {
            panForm = new JPanel();
            contentPanel.add(panForm);
            panForm.setLayout(new GridLayout(0, 1, 5, 0));
            {
                JPanel panUsername = new JPanel();
                panUsername.setName("panUsername");
                panUsername.setBorder(new EmptyBorder(15, 0, 15, 6));
                panForm.add(panUsername);
                panUsername.setLayout(new BorderLayout(0, 0));
                {
                    JLabel lblName = new JLabel("Name");
                    lblName.setBorder(new EmptyBorder(0, 0, 0, 24));
                    panUsername.add(lblName, BorderLayout.WEST);
                }
                {
                    txtUsername = new JTextField();
                    panUsername.add(txtUsername);
                    txtUsername.setColumns(16);
                }
                {
                    lblAvailable = new JLabel("");
                    lblAvailable.setBorder(new EmptyBorder(0, 16, 0, 0));
                    panUsername.add(lblAvailable, BorderLayout.EAST);
                    lblAvailable.setIcon(new ImageIcon(getClass().getResource("/delivery_system/assets/icons8-ok-24.png")));
                }
            }
            {
                JPanel panPwd = new JPanel();
                panPwd.setName("panPwd");
                panPwd.setBorder(new EmptyBorder(16, 0, 16, 6));
                panForm.add(panPwd);
                panPwd.setLayout(new BorderLayout(0, 0));
                {
                    JLabel lblPassword = new JLabel("Password");
                    lblPassword.setHorizontalAlignment(SwingConstants.TRAILING);
                    lblPassword.setBorder(new EmptyBorder(0, 0, 0, 6));
                    panPwd.add(lblPassword, BorderLayout.WEST);
                }
                {
                    passwordField = new JPasswordField();
                    passwordField.setColumns(16);
                    panPwd.add(passwordField);
                }
            }
            {
                JPanel panPwdConf = new JPanel();
                panPwdConf.setName("panPwdConf");
                panPwdConf.setBorder(new EmptyBorder(16, 0, 16, 6));
                panForm.add(panPwdConf);
                panPwdConf.setLayout(new BorderLayout(0, 0));
                {
                    JLabel lblConfirmPassword = new JLabel("Confirm Password");
                    lblConfirmPassword.setBorder(new EmptyBorder(0, 0, 0, 6));
                    panPwdConf.add(lblConfirmPassword, BorderLayout.WEST);
                }
                {
                    pwdConfirmPassowrd = new JPasswordField();
                    panPwdConf.add(pwdConfirmPassowrd);
                    pwdConfirmPassowrd.setColumns(16);
                }
            }
            {
                JPanel panName = new JPanel();
                panName.setName("panName");
                panName.setBorder(new EmptyBorder(16, 0, 16, 6));
                panForm.add(panName);
                panName.setLayout(new BoxLayout(panName, BoxLayout.X_AXIS));
                {
                    JLabel lblFirstName = new JLabel("First Name");
                    lblFirstName.setBorder(new EmptyBorder(0, 0, 0, 6));
                    panName.add(lblFirstName);
                }
                {
                    txtFname = new JTextField();
                    panName.add(txtFname);
                    txtFname.setColumns(10);
                }
                {
                    JLabel lblLastName = new JLabel("Last Name");
                    lblLastName.setBorder(new EmptyBorder(0, 6, 0, 6));
                    panName.add(lblLastName);
                }
                {
                    txtLname = new JTextField();
                    panName.add(txtLname);
                    txtLname.setColumns(10);
                }
            }
            {
                JPanel panAddr = new JPanel();
                panAddr.setName("panAddr");
                FlowLayout flowLayout = (FlowLayout) panAddr.getLayout();
                flowLayout.setAlignment(FlowLayout.LEADING);
                panForm.add(panAddr);
                {
                    JLabel lblAddress = new JLabel("Address");
                    panAddr.add(lblAddress);
                }
                {
                    txtAddress = new JTextField();
                    panAddr.add(txtAddress);
                    txtAddress.setColumns(16);
                }
            }
            {
                JPanel panEmail = new JPanel();
                panEmail.setName("panEmail");
                FlowLayout flowLayout = (FlowLayout) panEmail.getLayout();
                flowLayout.setAlignment(FlowLayout.LEADING);
                panForm.add(panEmail);
                {
                    JLabel lblEmail = new JLabel("Email");
                    panEmail.add(lblEmail);
                }
                {
                    txtEmail = new JTextField();
                    panEmail.add(txtEmail);
                    txtEmail.setColumns(24);
                }
            }
            {
                JPanel panPhone = new JPanel();
                panPhone.setName("panPhone");
                FlowLayout flowLayout = (FlowLayout) panPhone.getLayout();
                flowLayout.setAlignment(FlowLayout.LEADING);
                panForm.add(panPhone);
                {
                    JLabel lblPhone = new JLabel("Phone");
                    panPhone.add(lblPhone);
                }
                {
                    JLabel label = new JLabel("(");
                    panPhone.add(label);
                }
                {
                    textField = new JTextField();
                    textField.setMaximumSize(new Dimension(2147483630, 2147483647));
                    textField.setMargin(new Insets(2, 0, 2, 0));
                    textField.setColumns(3);
                    panPhone.add(textField);
                }
                {
                    JLabel label = new JLabel(")");
                    panPhone.add(label);
                }
                {
                    textField_1 = new JTextField();
                    textField_1.setColumns(3);
                    panPhone.add(textField_1);
                }
                {
                    JLabel label = new JLabel("-");
                    panPhone.add(label);
                }
                {
                    textField_2 = new JTextField();
                    textField_2.setColumns(4);
                    panPhone.add(textField_2);
                }
            }
        }
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setBorder(new MatteBorder(1, 0, 0, 0, (Color) Color.LIGHT_GRAY));
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                okButton = new JButton("Create");
                okButton.setActionCommand("OK");
                buttonPane.add(okButton);
                getRootPane().setDefaultButton(okButton);
            }
            {
                JButton cancelButton = new JButton("Cancel");
                cancelButton.setActionCommand("Cancel");
                buttonPane.add(cancelButton);
            }
        }
	}

    public JPanel getPanForm() {
        return panForm;
    }

    public JPanel getContentPanel() {
        return contentPanel;
    }

    public JTextField getTxtUsername() {
        return txtUsername;
    }

    public JLabel getLblAvailable() {
        return lblAvailable;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public JPasswordField getPwdConfirmPassowrd() {
        return pwdConfirmPassowrd;
    }

    public JTextField getTxtFname() {
        return txtFname;
    }

    public JTextField getTxtLname() {
        return txtLname;
    }

    public JTextField getTxtAddress() {
        return txtAddress;
    }

    public JTextField getTxtEmail() {
        return txtEmail;
    }

    public JButton getOkButton() {
        return okButton;
    }
}
