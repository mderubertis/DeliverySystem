package delivery_system.views;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

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
public class RestoManageView extends JInternalFrame {
    private final JTextField textField;
    private final JTextField textField_1;
    private JTextField resname;
    private JTextField resadd;
    private JFormattedTextField textField_2;
    private JFormattedTextField textField_3;
    private JFormattedTextField textField_4;
    private JFormattedTextField jtf;
    private JFormattedTextField jtf1;
    private JFormattedTextField jtf2;
    private JFormattedTextField jtf3;
    private JTextField textField_5;
    private JTextField textField_6;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JComboBox comboBox4;
    private JComboBox comboBox5;
    private JComboBox comboBox6;
    private JComboBox comboBox7;
    private JComboBox comboBox8;
    private JComboBox comboBox9;
    private JComboBox comboBox10;
    private JComboBox comboBox11;
    private JComboBox comboBox12;
    private JComboBox comboBox13;
    private JComboBox comboBox14;
    private JComboBox comboBox;
    private JComboBox comboBox_1;
    private JComboBox comboBox_2;
    private JComboBox comboBox_3;
    private JComboBox comboBox_4;
    private JComboBox comboBox_5;
    private JComboBox comboBox_6;
    private JComboBox comboBox_7;
    private JComboBox comboBox_8;
    private JComboBox comboBox_9;
    private JComboBox comboBox_10;
    private JComboBox comboBox_11;
    private JComboBox comboBox_12;
    private JComboBox comboBox_13;
    private final JButton btnSave;
    private final JPanel panel_16;

    public JPanel getPanel_16() {
        return panel_16;
    }

    /**
	 * Create the frame.
	 */
	public RestoManageView() {
		setTitle("Restaurant Management");
		setIconifiable(true);
		setMaximizable(true);
		setRootPaneCheckingEnabled(false);
		setResizable(true);
		setClosable(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
        setMaximumSize(new Dimension(895, 720));


        this.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        String[] hours = new String[13];
        String[] mins = new String[60];
        
        for (int i = 0; i < 13; i++)
            hours[i] = String.valueOf(i);

        for (int i = 0; i < 60; i++)
            mins[i] = String.valueOf(i);

        panel_16 = new JPanel();
        panel_16.setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        panel_16.add(panel, BorderLayout.NORTH);
        panel.setPreferredSize(new Dimension(10, 40));
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JLabel lblAddNewRestaurant = new JLabel("Add New Restaurant");
        lblAddNewRestaurant.setFont(new Font("Consolas", Font.BOLD, 30));
        panel.add(lblAddNewRestaurant);

        JPanel panel_3 = new JPanel();
        panel_16.add(panel_3, BorderLayout.SOUTH);
        panel_3.setBorder(new EmptyBorder(0, 100, 0, 100));
        panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));

        JPanel panel_14 = new JPanel();
        panel_3.add(panel_14);
        panel_14.setLayout(new GridLayout(0, 2, 0, 3));

        JLabel label = new JLabel("Restaurant Name:     ");
        panel_14.add(label);

        textField = new JTextField();
        getTextField().setMargin(new Insets(2, 2, 2, 80));
        getTextField().setColumns(10);
        panel_14.add(getTextField());

        JLabel label_1 = new JLabel("Restaurant Address: ");
        panel_14.add(label_1);

        textField_1 = new JTextField();
        getTextField_1().setMargin(new Insets(2, 2, 2, 80));
        getTextField_1().setColumns(10);
        panel_14.add(getTextField_1());

        JLabel label_2 = new JLabel("Telephone Number:               ");
        panel_14.add(label_2);

        JPanel panel_15 = new JPanel();
        panel_14.add(panel_15);

        JLabel label_3 = new JLabel("(");
        panel_15.add(label_3);

        textField_2 = new JFormattedTextField();
        getTextField_2().setMaximumSize(new Dimension(2147483630, 2147483647));
        getTextField_2().setMargin(new Insets(2, 0, 2, 0));
        getTextField_2().setColumns(3);
        panel_15.add(getTextField_2());

        JLabel label_4 = new JLabel(")");
        panel_15.add(label_4);

        textField_3 = new JFormattedTextField();
        getTextField_3().setColumns(3);
        panel_15.add(getTextField_3());

        JLabel label_5 = new JLabel("-");
        panel_15.add(label_5);

        textField_4 = new JFormattedTextField();
        getTextField_4().setColumns(4);
        panel_15.add(getTextField_4());

        JPanel panel_6 = new JPanel();
        panel_6.setPreferredSize(new Dimension(345, 250));
        panel_3.add(panel_6);
        panel_6.setLayout(new BorderLayout(0, 0));

        JPanel panel_1 = new JPanel();
        panel_6.add(panel_1, BorderLayout.NORTH);
        panel_1.setLayout(new GridLayout(2, 1, 0, 0));

        JPanel panel_4 = new JPanel();
        panel_1.add(panel_4);
        panel_4.setPreferredSize(new Dimension(345, 40));
        panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JLabel lblNewLabel = new JLabel("Openning Time");
        panel_4.add(lblNewLabel);
        lblNewLabel.setFont(new Font("Consolas", Font.BOLD, 27));

        JPanel panel_5 = new JPanel();
        FlowLayout flowLayout_3 = (FlowLayout) panel_5.getLayout();
        flowLayout_3.setVgap(0);
        panel_1.add(panel_5);
        panel_5.setPreferredSize(new Dimension(345, 25));

        JLabel lblNewLabel_1 = new JLabel("Day             ");
        lblNewLabel_1.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel_5.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Openning Time");
        lblNewLabel_2.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel_5.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("                 Closing Time");
        lblNewLabel_3.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel_5.add(lblNewLabel_3);

        JButton btnModifyAllTimes = new JButton("Modify all times at once");
        panel_5.add(btnModifyAllTimes);

        JPanel panel_17 = new JPanel();
        panel_6.add(panel_17, BorderLayout.CENTER);
        panel_17.setLayout(new BorderLayout(0, 0));

        JPanel panel_7 = new JPanel();
        FlowLayout flowLayout_2 = (FlowLayout) panel_7.getLayout();
        flowLayout_2.setVgap(9);
        panel_7.setPreferredSize(new Dimension(80, 10));
        panel_17.add(panel_7, BorderLayout.WEST);

        JLabel label_6 = new JLabel("Sunday");
        panel_7.add(label_6);

        JLabel label_7 = new JLabel("Monday");
        panel_7.add(label_7);

        JLabel label_8 = new JLabel("Tuesday");
        panel_7.add(label_8);

        JLabel label_9 = new JLabel("Wednesday");
        panel_7.add(label_9);

        JLabel label_10 = new JLabel("Thursday");
        panel_7.add(label_10);

        JLabel label_11 = new JLabel("Friday");
        panel_7.add(label_11);

        JLabel label_12 = new JLabel("Saturday");
        panel_7.add(label_12);

        JPanel panel_8 = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panel_8.getLayout();
        flowLayout.setVgap(2);
        panel_17.add(panel_8);

        JComboBox comboBox = new JComboBox(hours);
        comboBox.setPreferredSize(new Dimension(50, 22));
        panel_8.add(comboBox);

        JLabel label_13 = new JLabel("h");
        panel_8.add(label_13);

        JComboBox comboBox_1 = new JComboBox(mins);
        comboBox_1.setPreferredSize(new Dimension(50, 22));
        panel_8.add(comboBox_1);

        JComboBox comboBox_2 = new JComboBox(hours);
        comboBox_2.setPreferredSize(new Dimension(50, 22));
        panel_8.add(comboBox_2);

        JLabel label_14 = new JLabel("h");
        panel_8.add(label_14);

        JComboBox comboBox_3 = new JComboBox(mins);
        comboBox_3.setPreferredSize(new Dimension(50, 22));
        panel_8.add(comboBox_3);

        JComboBox comboBox_4 = new JComboBox(hours);
        comboBox_4.setPreferredSize(new Dimension(50, 22));
        panel_8.add(comboBox_4);

        JLabel label_15 = new JLabel("h");
        panel_8.add(label_15);

        JComboBox comboBox_5 = new JComboBox(mins);
        comboBox_5.setPreferredSize(new Dimension(50, 22));
        panel_8.add(comboBox_5);

        JComboBox comboBox_6 = new JComboBox(hours);
        comboBox_6.setPreferredSize(new Dimension(50, 22));
        panel_8.add(comboBox_6);

        JLabel label_16 = new JLabel("h");
        panel_8.add(label_16);

        JComboBox comboBox_7 = new JComboBox(mins);
        comboBox_7.setPreferredSize(new Dimension(50, 22));
        panel_8.add(comboBox_7);

        JComboBox comboBox_8 = new JComboBox(hours);
        comboBox_8.setPreferredSize(new Dimension(50, 22));
        panel_8.add(comboBox_8);

        JLabel label_17 = new JLabel("h");
        panel_8.add(label_17);

        JComboBox comboBox_9 = new JComboBox(mins);
        comboBox_9.setPreferredSize(new Dimension(50, 22));
        panel_8.add(comboBox_9);

        JComboBox comboBox_10 = new JComboBox(hours);
        comboBox_10.setPreferredSize(new Dimension(50, 22));
        panel_8.add(comboBox_10);

        JLabel label_18 = new JLabel("h");
        panel_8.add(label_18);

        JComboBox comboBox_11 = new JComboBox(mins);
        comboBox_11.setPreferredSize(new Dimension(50, 22));
        panel_8.add(comboBox_11);

        JComboBox comboBox_12 = new JComboBox(hours);
        comboBox_12.setPreferredSize(new Dimension(50, 22));
        panel_8.add(comboBox_12);

        JLabel label_19 = new JLabel("h");
        panel_8.add(label_19);

        JComboBox comboBox_13 = new JComboBox(mins);
        comboBox_13.setPreferredSize(new Dimension(50, 22));
        panel_8.add(comboBox_13);

        JPanel panel_9 = new JPanel();
        FlowLayout flowLayout_1 = (FlowLayout) panel_9.getLayout();
        flowLayout_1.setVgap(2);
        panel_9.setPreferredSize(new Dimension(130, 10));
        panel_17.add(panel_9, BorderLayout.EAST);

        JComboBox comboBox_14 = new JComboBox(hours);
        comboBox_14.setPreferredSize(new Dimension(50, 22));
        panel_9.add(comboBox_14);

        JLabel label_20 = new JLabel("h");
        panel_9.add(label_20);

        JComboBox comboBox_15 = new JComboBox(mins);
        comboBox_15.setPreferredSize(new Dimension(50, 22));
        panel_9.add(comboBox_15);

        JComboBox comboBox_16 = new JComboBox(hours);
        comboBox_16.setPreferredSize(new Dimension(50, 22));
        panel_9.add(comboBox_16);

        JLabel label_21 = new JLabel("h");
        panel_9.add(label_21);

        JComboBox comboBox_17 = new JComboBox(mins);
        comboBox_17.setPreferredSize(new Dimension(50, 22));
        panel_9.add(comboBox_17);

        JComboBox comboBox_18 = new JComboBox(hours);
        comboBox_18.setPreferredSize(new Dimension(50, 22));
        panel_9.add(comboBox_18);

        JLabel label_22 = new JLabel("h");
        panel_9.add(label_22);

        JComboBox comboBox_19 = new JComboBox(mins);
        comboBox_19.setPreferredSize(new Dimension(50, 22));
        panel_9.add(comboBox_19);

        JComboBox comboBox_20 = new JComboBox(hours);
        comboBox_20.setPreferredSize(new Dimension(50, 22));
        panel_9.add(comboBox_20);

        JLabel label_23 = new JLabel("h");
        panel_9.add(label_23);

        JComboBox comboBox_21 = new JComboBox(mins);
        comboBox_21.setPreferredSize(new Dimension(50, 22));
        panel_9.add(comboBox_21);

        JComboBox comboBox_22 = new JComboBox(hours);
        comboBox_22.setPreferredSize(new Dimension(50, 22));
        panel_9.add(comboBox_22);

        JLabel label_24 = new JLabel("h");
        panel_9.add(label_24);

        JComboBox comboBox_23 = new JComboBox(mins);
        comboBox_23.setPreferredSize(new Dimension(50, 22));
        panel_9.add(comboBox_23);

        JComboBox comboBox_24 = new JComboBox(hours);
        comboBox_24.setPreferredSize(new Dimension(50, 22));
        panel_9.add(comboBox_24);

        JLabel label_25 = new JLabel("h");
        panel_9.add(label_25);

        JComboBox comboBox_25 = new JComboBox(mins);
        comboBox_25.setPreferredSize(new Dimension(50, 22));
        panel_9.add(comboBox_25);

        JComboBox comboBox_26 = new JComboBox(hours);
        comboBox_26.setPreferredSize(new Dimension(50, 22));
        panel_9.add(comboBox_26);

        JLabel label_26 = new JLabel("h");
        panel_9.add(label_26);

        JComboBox comboBox_27 = new JComboBox(mins);
        comboBox_27.setPreferredSize(new Dimension(50, 22));
        panel_9.add(comboBox_27);


        JPanel panel_2 = new JPanel();
        panel_3.add(panel_2);
        panel_2.setLayout(new BorderLayout(0, 5));

        JPanel panel_11 = new JPanel();
        panel_2.add(panel_11, BorderLayout.NORTH);
        panel_11.setPreferredSize(new Dimension(343, 30));

        JLabel lblNewLabel_10 = new JLabel("Delivery Area");
        lblNewLabel_10.setFont(new Font("Consolas", Font.BOLD, 22));
        panel_11.add(lblNewLabel_10);

        JPanel panel_12 = new JPanel();
        panel_2.add(panel_12, BorderLayout.CENTER);
        panel_12.setPreferredSize(new Dimension(343, 70));
        panel_12.setLayout(new BorderLayout(0, 0));

        textField_5 = new JTextField();
        panel_12.add(getTextField_5(), BorderLayout.CENTER);
        getTextField_5().setColumns(10);

        JPanel panel_13 = new JPanel();
        panel_2.add(panel_13, BorderLayout.SOUTH);
        panel_13.setPreferredSize(new Dimension(343, 90));

        JLabel lblDeliveryArea = new JLabel("Delivery Area: ");
        panel_13.add(lblDeliveryArea);

        textField_6 = new JTextField();
        panel_13.add(getTextField_6());
        getTextField_6().setColumns(3);

        JButton btnAddDeliveryArea = new JButton("Add Delivery Area");
        panel_13.add(btnAddDeliveryArea);

        JButton btnDeleteDeliveryArea = new JButton("Delete Delivery Area");
        panel_13.add(btnDeleteDeliveryArea);

        btnSave = new JButton("Save");
        panel_13.add(btnSave);
	}

    public JButton getBtnSave() {
        return btnSave;
    }

    public JTextField getTextField() {
        return textField;
    }

    public JTextField getTextField_1() {
        return textField_1;
    }

    public JTextField getResname() {
        return resname;
    }

    public JTextField getResadd() {
        return resadd;
    }

    public JFormattedTextField getTextField_2() {
        return textField_2;
    }

    public JFormattedTextField getTextField_3() {
        return textField_3;
    }

    public JFormattedTextField getTextField_4() {
        return textField_4;
    }

    public JFormattedTextField getJtf() {
        return jtf;
    }

    public JFormattedTextField getJtf1() {
        return jtf1;
    }

    public JFormattedTextField getJtf2() {
        return jtf2;
    }

    public JFormattedTextField getJtf3() {
        return jtf3;
    }

    public JTextField getTextField_5() {
        return textField_5;
    }

    public JTextField getTextField_6() {
        return textField_6;
    }

    public JComboBox getComboBox1() {
        return comboBox1;
    }

    public JComboBox getComboBox2() {
        return comboBox2;
    }

    public JComboBox getComboBox3() {
        return comboBox3;
    }

    public JComboBox getComboBox4() {
        return comboBox4;
    }

    public JComboBox getComboBox5() {
        return comboBox5;
    }

    public JComboBox getComboBox6() {
        return comboBox6;
    }

    public JComboBox getComboBox7() {
        return comboBox7;
    }

    public JComboBox getComboBox8() {
        return comboBox8;
    }

    public JComboBox getComboBox9() {
        return comboBox9;
    }

    public JComboBox getComboBox10() {
        return comboBox10;
    }

    public JComboBox getComboBox11() {
        return comboBox11;
    }

    public JComboBox getComboBox12() {
        return comboBox12;
    }

    public JComboBox getComboBox13() {
        return comboBox13;
    }

    public JComboBox getComboBox14() {
        return comboBox14;
    }

    public JComboBox getComboBox() {
        return comboBox;
    }

    public JComboBox getComboBox_1() {
        return comboBox_1;
    }

    public JComboBox getComboBox_2() {
        return comboBox_2;
    }

    public JComboBox getComboBox_3() {
        return comboBox_3;
    }

    public JComboBox getComboBox_4() {
        return comboBox_4;
    }

    public JComboBox getComboBox_5() {
        return comboBox_5;
    }

    public JComboBox getComboBox_6() {
        return comboBox_6;
    }

    public JComboBox getComboBox_7() {
        return comboBox_7;
    }

    public JComboBox getComboBox_8() {
        return comboBox_8;
    }

    public JComboBox getComboBox_9() {
        return comboBox_9;
    }

    public JComboBox getComboBox_10() {
        return comboBox_10;
    }

    public JComboBox getComboBox_11() {
        return comboBox_11;
    }

    public JComboBox getComboBox_12() {
        return comboBox_12;
    }

    public JComboBox getComboBox_13() {
        return comboBox_13;
    }
}
