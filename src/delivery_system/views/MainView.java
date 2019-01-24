package delivery_system.views;

import javax.swing.*;
import java.awt.SystemColor;

/**
 * 
 */

/**
 * Delivery System
 * 
 * @author Michael De Rubertis <m.derubertis@hotmail.com>
 * @date Jan. 21, 2019
 *
 */
public class MainView extends JFrame {

	private JDesktopPane contentPane;
	private JMenuBar menuBar;

	@Override
	public JDesktopPane getContentPane() {
		return contentPane;
	}

	/**
	 * Create the frame.
	 */
	public MainView() {
		setTitle("Delivery System: [USER] (Administrator)");
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 720);
		contentPane = new JDesktopPane();
		contentPane.setBackground(SystemColor.control);

		setContentPane(contentPane);
	}
}
