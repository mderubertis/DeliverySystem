/**
 * 
 */
package delivery_system.views.account;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.text.MaskFormatter;

/**
 * Delivery System
 *
 * @author Michael De Rubertis <m.derubertis@hotmail.com>
 * @date Jan. 28, 2019
 */
public class AccountDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
    private String title;
    private JTextField txtUsername;
	private JPasswordField passwordField;
	private JPasswordField pwdConfirmPassowrd;
	private JTextField txtFname;
	private JTextField txtLname;
	private JTextField txtAddress;
	private JTextField txtEmail;
	private JTextField tel1;
	private JTextField tel2;
	private JTextField tel3;
    private final JButton okButton;
    private final JLabel lblAvailable;
    private final JPanel panForm;
    private final JLabel lblViewTitle;

    /**
     * Create the dialog.
     */
    public AccountDialog() {
		setIconImage(new ImageIcon(getClass().getResource("/delivery_system/assets/icons8-customer-48.png")).getImage());
        title = "Create Account";
        setTitle(title);
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
            lblViewTitle = new JLabel(title);
            lblViewTitle.setFont(new Font("Segoe UI", Font.BOLD, 18));
            contentPanel.add(lblViewTitle);
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
                    JLabel lblUsername = new JLabel("Username");
                    lblUsername.setBorder(new EmptyBorder(0, 0, 0, 24));
                    panUsername.add(lblUsername, BorderLayout.WEST);
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
                    txtAddress.setColumns(45);
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
                    txtEmail.setColumns(45);
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
                    try {
                        tel1 = new JFormattedTextField(new MaskFormatter("###"));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    tel1.setMaximumSize(new Dimension(2147483630, 2147483647));
                    tel1.setMargin(new Insets(2, 0, 2, 0));
                    tel1.setColumns(3);
                    panPhone.add(tel1);
                }
                {
                    JLabel label = new JLabel(")");
                    panPhone.add(label);
                }
                {
                    try {
                        tel2 = new JFormattedTextField(new MaskFormatter("###"));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    tel2.setColumns(3);
                    panPhone.add(tel2);
                }
                {
                    JLabel label = new JLabel("-");
                    panPhone.add(label);
                }
                {
                    try {
                        tel3 = new JFormattedTextField(new MaskFormatter("####"));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    tel3.setColumns(4);
                    panPhone.add(tel3);
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

    /**
     * Gets pan form.
     *
     * @return the pan form
     */
    public JPanel getPanForm() {
        return panForm;
    }

    /**
     * Gets content panel.
     *
     * @return the content panel
     */
    public JPanel getContentPanel() {
        return contentPanel;
    }

    /**
     * Gets txt username.
     *
     * @return the txt username
     */
    public JTextField getTxtUsername() {
        return txtUsername;
    }

    /**
     * Gets lbl available.
     *
     * @return the lbl available
     */
    public JLabel getLblAvailable() {
        return lblAvailable;
    }

    /**
     * Gets password field.
     *
     * @return the password field
     */
    public JPasswordField getPasswordField() {
        return passwordField;
    }

    /**
     * Gets pwd confirm passowrd.
     *
     * @return the pwd confirm passowrd
     */
    public JPasswordField getPwdConfirmPassowrd() {
        return pwdConfirmPassowrd;
    }

    /**
     * Gets txt fname.
     *
     * @return the txt fname
     */
    public JTextField getTxtFname() {
        return txtFname;
    }

    /**
     * Gets txt lname.
     *
     * @return the txt lname
     */
    public JTextField getTxtLname() {
        return txtLname;
    }

    /**
     * Gets txt address.
     *
     * @return the txt address
     */
    public JTextField getTxtAddress() {
        return txtAddress;
    }

    /**
     * Gets txt email.
     *
     * @return the txt email
     */
    public JTextField getTxtEmail() {
        return txtEmail;
    }

    /**
     * Gets ok button.
     *
     * @return the ok button
     */
    public JButton getOkButton() {
        return okButton;
    }

    /**
     * Gets phone.
     *
     * @return the phone
     */
    public String getPhone() {
	    return "(" + tel1.getText() + ") " + tel2.getText() + " - " + tel3.getText();
    }

    /**
     * Sets title string.
     *
     * @param title the title
     */
    public void setTitleString(String title) {
        this.title = title;
        this.lblViewTitle.setText(title);
        setTitle(title);
    }
}
