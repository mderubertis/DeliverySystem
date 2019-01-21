package views;

import java.awt.EventQueue;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.SystemColor;
import java.beans.PropertyVetoException;

/**
 * 
 */

/**
 * ProjectGUI
 * 
 * @author Michael De Rubertis <m.derubertis@hotmail.com>
 * @date Jan. 21, 2019
 *
 */
public class AdminView extends JFrame {

	private JDesktopPane contentPane;
	private JMenuBar menuBar;

	@Override
	public JDesktopPane getContentPane() {
		return contentPane;
	}

	/**
	 * Create the frame.
	 */
	public AdminView() {
		setTitle("Delivery System: [USER] (Administrator)");
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 931, 597);
		contentPane = new JDesktopPane();
		contentPane.setBackground(SystemColor.control);

		setContentPane(contentPane);
	}
}
