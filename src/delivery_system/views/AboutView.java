package delivery_system.views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 *
 */

/**
 * Delivery System
 *
 * @author Michael De Rubertis <m.derubertis@hotmail.com>
 * @date Jan. 22, 2019
 */
public class AboutView extends JDialog {

    private final JPanel contentPanel = new JPanel();

    /**
     * Create the dialog.
     */
    public AboutView() {
        setBounds(100, 100, 450, 300);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new GridLayout(3, 1, 0, 0));
        {
            JLabel lblRDS = new JLabel("Restaurant Delivery System");
            lblRDS.setHorizontalAlignment(SwingConstants.CENTER);
            lblRDS.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
            contentPanel.add(lblRDS);
        }
        {
            JLabel lblCreatedBy = new JLabel("Michael De Rubertis, TJ, Mayur");
            lblCreatedBy.setHorizontalAlignment(SwingConstants.CENTER);
            contentPanel.add(lblCreatedBy);
        }
        {
            JLabel lblHerzingCollege = new JLabel("Herzing College 2019");
            lblHerzingCollege.setHorizontalAlignment(SwingConstants.CENTER);
            contentPanel.add(lblHerzingCollege);
        }
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton okButton = new JButton("OK");
                okButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        dispose();
                    }
                });
                okButton.setActionCommand("OK");
                buttonPane.add(okButton);
                getRootPane().setDefaultButton(okButton);
            }
        }
    }

}
