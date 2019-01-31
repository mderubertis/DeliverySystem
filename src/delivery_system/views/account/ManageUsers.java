/**
 * 
 */
package delivery_system.views.account;

import delivery_system.Main;
import delivery_system.model.restaurants.Restaurant;
import delivery_system.model.users.Roles;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Dialog.ModalityType;

/**
 * Mod4Project
 * 
 * @author Michael De Rubertis <m.derubertis@hotmail.com>
 * @date Jan. 30, 2019
 *
 */
public class ManageUsers extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPanel panel_1;
	private JPanel panel;

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
		{
			panel_1 = new JPanel();
			panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				JLabel lblSelectRestaurant = new JLabel("Select restaurant");
				panel_1.add(lblSelectRestaurant);
			}
			{
				JComboBox comboBox = new JComboBox();
				panel_1.add(comboBox);
				comboBox.setModel(new DefaultComboBoxModel(new String[] { "Select restaurant" }));
				for (Restaurant restaurant : Main.getRestaurants().getRestaurants()) {
				    comboBox.addItem(restaurant.getName());
                }
			}
		}
		{
			panel = new JPanel();
			{
				JLabel lblSelectUser = new JLabel("Select User");
				panel.add(lblSelectUser);
			}
			{
				JComboBox comboBox = new JComboBox();
				comboBox.setModel(new DefaultComboBoxModel(new String[] { "Select user" }));
				panel.add(comboBox);
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

		JLabel lblRole = new JLabel("Role");
		panel.add(lblRole);

		JComboBox comboBox = new JComboBox(new DefaultComboBoxModel(new String[]{"Select role", Roles.ADMINISTRATOR, Roles.MANAGER, Roles.RESTAURATEUR}));
		panel.add(comboBox);

		JButton btnAdd = new JButton("Add");
		panel_2.add(btnAdd);

		JButton btnEdit = new JButton("Edit");
		panel_2.add(btnEdit);

		JButton btnDelete = new JButton("Delete");
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
