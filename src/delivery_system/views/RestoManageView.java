package delivery_system.views;

import java.awt.*;
import java.text.ParseException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.text.MaskFormatter;

/**
 *
 */

/**
 * Delivery System
 *
 * @author Michael De Rubertis <m.derubertis@hotmail.com>
 * @date Jan. 21, 2019
 */
public class RestoManageView extends JInternalFrame {
    private final JTextField txtRestoName;
    private final JTextField txtRestoAddr;
    private JTextField resname;
    private JTextField resadd;
    private JFormattedTextField ftxtTel1;
    private JFormattedTextField ftxtTel2;
    private JFormattedTextField ftxtTel3;
    private JFormattedTextField jtf;
    private JFormattedTextField jtf1;
    private JFormattedTextField jtf2;
    private JFormattedTextField jtf3;
    private JTextArea txtDevAreas;
    private JTextField txtAddDevArea;
    private final JButton btnSave;
    private final JPanel panel_16;
    private MaskFormatter tel;
    private MaskFormatter tel4;
    private final JButton btnAddDeliveryArea;
    private final JButton btnDeleteDeliveryArea;
    private final JLabel lblViewTitle;
    private final JComboBox cmbSunOHrs;
    private final JComboBox cmbSunOHrs2;
    private final JComboBox cmbMonOHrs;
    private final JComboBox cmbMonOHrs2;
    private final JComboBox cmbTuesOHrs;
    private final JComboBox cmbTuesOHrs2;
    private final JComboBox cmbWedOHrs;
    private final JComboBox cmbWedOHrs2;
    private final JComboBox cmbThursOHrs;
    private final JComboBox cmbThursOHrs2;
    private final JComboBox cmbFriOHrs;
    private final JComboBox cmbFriOHrs2;
    private final JComboBox cmbSatOHrs;
    private final JComboBox cmbSatOHrs2;
    private final JComboBox cmbSunCHrs;
    private final JComboBox cmbSunCHrs2;
    private final JComboBox cmbMonCHrs;
    private final JComboBox cmbMonCHrs2;
    private final JComboBox cmbTuesCHrs;
    private final JComboBox cmbTuesCHrs2;
    private final JComboBox cmbWedCHrs;
    private final JComboBox cmbWedCHrs2;
    private final JComboBox cmbThursCHrs;
    private final JComboBox cmbThursCHrs2;
    private final JComboBox cmbFriCHrs;
    private final JComboBox cmbFriCHrs2;
    private final JComboBox cmbSatCHrs;
    private final JComboBox cmbSatCHrs2;
    private final JPanel openHours;
    private final JPanel closedHours;


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


        //this.getContentPane().setLayout();

        String[] hours = new String[13];
        String[] mins = new String[60];

        for (int i = 0; i < 13; i++)
            hours[i] = String.valueOf(i);

        for (int i = 0; i < 60; i++)
            mins[i] = String.valueOf(i);

        panel_16 = new JPanel();
        panel_16.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JPanel panel_3 = new JPanel();
        panel_16.add(panel_3, BorderLayout.CENTER);
        panel_3.setBorder(new EmptyBorder(0, 100, 0, 100));
        panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));

        JPanel panel_10 = new JPanel();
        panel_3.add(panel_10);

        lblViewTitle = new JLabel("Add New Restaurant");
        panel_10.add(lblViewTitle);
        lblViewTitle.setFont(new Font("Consolas", Font.BOLD, 30));

        JPanel panel_14 = new JPanel();
        panel_3.add(panel_14);
        panel_14.setLayout(new GridLayout(0, 2, 0, 3));

        JLabel label = new JLabel("Restaurant Name:     ");
        panel_14.add(label);

        txtRestoName = new JTextField();
        panel_14.add(getTxtRestoName());

        JLabel label_1 = new JLabel("Restaurant Address: ");
        panel_14.add(label_1);

        txtRestoAddr = new JTextField();
        panel_14.add(getTxtRestoAddr());

        JLabel label_2 = new JLabel("Telephone Number:               ");
        panel_14.add(label_2);

        JPanel panel_15 = new JPanel();
        panel_14.add(panel_15);

        JLabel label_3 = new JLabel("(");
        panel_15.add(label_3);

        try {
            tel = new MaskFormatter("###");
            tel4 = new MaskFormatter("####");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        ftxtTel1 = new JFormattedTextField(tel);
        ftxtTel1.setMaximumSize(new Dimension(2147483630, 2147483647));
        ftxtTel1.setMargin(new Insets(2, 0, 2, 0));
        ftxtTel1.setColumns(3);
        panel_15.add(ftxtTel1);

        JLabel label_4 = new JLabel(")");
        panel_15.add(label_4);

        ftxtTel2 = new JFormattedTextField(tel);
        ftxtTel2.setColumns(3);
        panel_15.add(ftxtTel2);

        JLabel label_5 = new JLabel("-");
        panel_15.add(label_5);

        ftxtTel3 = new JFormattedTextField(tel4);
        ftxtTel3.setColumns(4);
        panel_15.add(ftxtTel3);

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

        JLabel lblNewLabel_1 = new JLabel("Day                ");
        lblNewLabel_1.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel_5.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Opening Time");
        lblNewLabel_2.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel_5.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("                    Closing Time");
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

        openHours = new JPanel();
        FlowLayout flowLayout = (FlowLayout) openHours.getLayout();
        flowLayout.setVgap(2);
        panel_17.add(openHours);

        cmbSunOHrs = new JComboBox(hours);
        cmbSunOHrs.setPreferredSize(new Dimension(50, 22));
        openHours.add(cmbSunOHrs);

        JLabel label_13 = new JLabel("h");
        openHours.add(label_13);

        cmbSunOHrs2 = new JComboBox(mins);
        cmbSunOHrs2.setPreferredSize(new Dimension(50, 22));
        openHours.add(cmbSunOHrs2);

        cmbMonOHrs = new JComboBox(hours);
        cmbMonOHrs.setPreferredSize(new Dimension(50, 22));
        openHours.add(cmbMonOHrs);

        JLabel label_14 = new JLabel("h");
        openHours.add(label_14);

        cmbMonOHrs2 = new JComboBox(mins);
        cmbMonOHrs2.setPreferredSize(new Dimension(50, 22));
        openHours.add(cmbMonOHrs2);

        cmbTuesOHrs = new JComboBox(hours);
        cmbTuesOHrs.setPreferredSize(new Dimension(50, 22));
        openHours.add(cmbTuesOHrs);

        JLabel label_15 = new JLabel("h");
        openHours.add(label_15);

        cmbTuesOHrs2 = new JComboBox(mins);
        cmbTuesOHrs2.setPreferredSize(new Dimension(50, 22));
        openHours.add(cmbTuesOHrs2);

        cmbWedOHrs = new JComboBox(hours);
        cmbWedOHrs.setPreferredSize(new Dimension(50, 22));
        openHours.add(cmbWedOHrs);

        JLabel label_16 = new JLabel("h");
        openHours.add(label_16);

        cmbWedOHrs2 = new JComboBox(mins);
        cmbWedOHrs2.setPreferredSize(new Dimension(50, 22));
        openHours.add(cmbWedOHrs2);

        cmbThursOHrs = new JComboBox(hours);
        cmbThursOHrs.setPreferredSize(new Dimension(50, 22));
        openHours.add(cmbThursOHrs);

        JLabel label_17 = new JLabel("h");
        openHours.add(label_17);

        cmbThursOHrs2 = new JComboBox(mins);
        cmbThursOHrs2.setPreferredSize(new Dimension(50, 22));
        openHours.add(cmbThursOHrs2);

        cmbFriOHrs = new JComboBox(hours);
        cmbFriOHrs.setPreferredSize(new Dimension(50, 22));
        openHours.add(cmbFriOHrs);

        JLabel label_18 = new JLabel("h");
        openHours.add(label_18);

        cmbFriOHrs2 = new JComboBox(mins);
        cmbFriOHrs2.setPreferredSize(new Dimension(50, 22));
        openHours.add(cmbFriOHrs2);

        cmbSatOHrs = new JComboBox(hours);
        cmbSatOHrs.setPreferredSize(new Dimension(50, 22));
        openHours.add(cmbSatOHrs);

        JLabel label_19 = new JLabel("h");
        openHours.add(label_19);

        cmbSatOHrs2 = new JComboBox(mins);
        cmbSatOHrs2.setPreferredSize(new Dimension(50, 22));
        openHours.add(cmbSatOHrs2);

        closedHours = new JPanel();
        FlowLayout flowLayout_1 = (FlowLayout) closedHours.getLayout();
        flowLayout_1.setVgap(2);
        closedHours.setPreferredSize(new Dimension(130, 10));
        panel_17.add(closedHours, BorderLayout.EAST);

        cmbSunCHrs = new JComboBox(hours);
        cmbSunCHrs.setPreferredSize(new Dimension(50, 22));
        closedHours.add(cmbSunCHrs);

        JLabel label_20 = new JLabel("h");
        closedHours.add(label_20);

        cmbSunCHrs2 = new JComboBox(mins);
        cmbSunCHrs2.setPreferredSize(new Dimension(50, 22));
        closedHours.add(cmbSunCHrs2);

        cmbMonCHrs = new JComboBox(hours);
        cmbMonCHrs.setPreferredSize(new Dimension(50, 22));
        closedHours.add(cmbMonCHrs);

        JLabel label_21 = new JLabel("h");
        closedHours.add(label_21);

        cmbMonCHrs2 = new JComboBox(mins);
        cmbMonCHrs2.setPreferredSize(new Dimension(50, 22));
        closedHours.add(cmbMonCHrs2);

        cmbTuesCHrs = new JComboBox(hours);
        cmbTuesCHrs.setPreferredSize(new Dimension(50, 22));
        closedHours.add(cmbTuesCHrs);

        JLabel label_22 = new JLabel("h");
        closedHours.add(label_22);

        cmbTuesCHrs2 = new JComboBox(mins);
        cmbTuesCHrs2.setPreferredSize(new Dimension(50, 22));
        closedHours.add(cmbTuesCHrs2);

        cmbWedCHrs = new JComboBox(hours);
        cmbWedCHrs.setPreferredSize(new Dimension(50, 22));
        closedHours.add(cmbWedCHrs);

        JLabel label_23 = new JLabel("h");
        closedHours.add(label_23);

        cmbWedCHrs2 = new JComboBox(mins);
        cmbWedCHrs2.setPreferredSize(new Dimension(50, 22));
        closedHours.add(cmbWedCHrs2);

        cmbThursCHrs = new JComboBox(hours);
        cmbThursCHrs.setPreferredSize(new Dimension(50, 22));
        closedHours.add(cmbThursCHrs);

        JLabel label_24 = new JLabel("h");
        closedHours.add(label_24);

        cmbThursCHrs2 = new JComboBox(mins);
        cmbThursCHrs2.setPreferredSize(new Dimension(50, 22));
        closedHours.add(cmbThursCHrs2);

        cmbFriCHrs = new JComboBox(hours);
        cmbFriCHrs.setPreferredSize(new Dimension(50, 22));
        closedHours.add(cmbFriCHrs);

        JLabel label_25 = new JLabel("h");
        closedHours.add(label_25);

        cmbFriCHrs2 = new JComboBox(mins);
        cmbFriCHrs2.setPreferredSize(new Dimension(50, 22));
        closedHours.add(cmbFriCHrs2);

        cmbSatCHrs = new JComboBox(hours);
        cmbSatCHrs.setPreferredSize(new Dimension(50, 22));
        closedHours.add(cmbSatCHrs);

        JLabel label_26 = new JLabel("h");
        closedHours.add(label_26);

        cmbSatCHrs2 = new JComboBox(mins);
        cmbSatCHrs2.setPreferredSize(new Dimension(50, 22));
        closedHours.add(cmbSatCHrs2);

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

        txtDevAreas = new JTextArea();
        txtDevAreas.setBackground(UIManager.getColor("FormattedTextField.disabledBackground"));
        txtDevAreas.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.LIGHT_GRAY));
        txtDevAreas.setEditable(false);
        txtDevAreas.setLineWrap(true);
        txtDevAreas.setWrapStyleWord(true);
        panel_12.add(getTxtDevAreas(), BorderLayout.CENTER);

        JPanel panel_13 = new JPanel();
        panel_2.add(panel_13, BorderLayout.SOUTH);
        panel_13.setPreferredSize(new Dimension(343, 90));

        JLabel lblDeliveryArea = new JLabel("Delivery Area: ");
        panel_13.add(lblDeliveryArea);

        try {
            txtAddDevArea = new JFormattedTextField(new MaskFormatter("#U#"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        panel_13.add(getTxtAddDevArea());
        getTxtAddDevArea().setColumns(3);

        btnAddDeliveryArea = new JButton("Add Delivery Area");
        panel_13.add(btnAddDeliveryArea);

        btnDeleteDeliveryArea = new JButton("Delete Delivery Area");
        panel_13.add(btnDeleteDeliveryArea);

        btnSave = new JButton("Save");
        panel_13.add(btnSave);
    }

    public JButton getBtnSave() {
        return btnSave;
    }

    public JTextField getTxtRestoName() {
        return txtRestoName;
    }

    public JTextField getTxtRestoAddr() {
        return txtRestoAddr;
    }

    public String getFtxtTelParsed() {
        return "(" + ftxtTel1.getText() + ") " + ftxtTel2.getText() + "-" + ftxtTel3.getText();
    }

    public JTextArea getTxtDevAreas() {
        return txtDevAreas;
    }

    public JTextField getTxtAddDevArea() {
        return txtAddDevArea;
    }

    public JPanel getPanel_16() {
        return panel_16;
    }

    public JLabel getLblViewTitle() {
        return lblViewTitle;
    }

    public JFormattedTextField getFtxtTel1() {
        return ftxtTel1;
    }

    public JFormattedTextField getFtxtTel2() {
        return ftxtTel2;
    }

    public JFormattedTextField getFtxtTel3() {
        return ftxtTel3;
    }

    public JButton getBtnAddDeliveryArea() {
        return btnAddDeliveryArea;
    }

    public JButton getBtnDeleteDeliveryArea() {
        return btnDeleteDeliveryArea;
    }

    public JComboBox getCmbSunOHrs() {
        return cmbSunOHrs;
    }

    public JComboBox getCmbSunOHrs2() {
        return cmbSunOHrs2;
    }

    public JComboBox getCmbMonOHrs() {
        return cmbMonOHrs;
    }

    public JComboBox getCmbMonOHrs2() {
        return cmbMonOHrs2;
    }

    public JComboBox getCmbTuesOHrs() {
        return cmbTuesOHrs;
    }

    public JComboBox getCmbTuesOHrs2() {
        return cmbTuesOHrs2;
    }

    public JComboBox getCmbWedOHrs() {
        return cmbWedOHrs;
    }

    public JComboBox getCmbWedOHrs2() {
        return cmbWedOHrs2;
    }

    public JComboBox getCmbThursOHrs() {
        return cmbThursOHrs;
    }

    public JComboBox getCmbThursOHrs2() {
        return cmbThursOHrs2;
    }

    public JComboBox getCmbFriOHrs() {
        return cmbFriOHrs;
    }

    public JComboBox getCmbFriOHrs2() {
        return cmbFriOHrs2;
    }

    public JComboBox getCmbSatOHrs() {
        return cmbSatOHrs;
    }

    public JComboBox getCmbSatOHrs2() {
        return cmbSatOHrs2;
    }

    public JComboBox getCmbSunCHrs() {
        return cmbSunCHrs;
    }

    public JComboBox getCmbSunCHrs2() {
        return cmbSunCHrs2;
    }

    public JComboBox getCmbMonCHrs() {
        return cmbMonCHrs;
    }

    public JComboBox getCmbMonCHrs2() {
        return cmbMonCHrs2;
    }

    public JComboBox getCmbTuesCHrs() {
        return cmbTuesCHrs;
    }

    public JComboBox getCmbTuesCHrs2() {
        return cmbTuesCHrs2;
    }

    public JComboBox getCmbWedCHrs() {
        return cmbWedCHrs;
    }

    public JComboBox getCmbWedCHrs2() {
        return cmbWedCHrs2;
    }

    public JComboBox getCmbThursCHrs() {
        return cmbThursCHrs;
    }

    public JComboBox getCmbThursCHrs2() {
        return cmbThursCHrs2;
    }

    public JComboBox getCmbFriCHrs() {
        return cmbFriCHrs;
    }

    public JComboBox getCmbFriCHrs2() {
        return cmbFriCHrs2;
    }

    public JComboBox getCmbSatCHrs() {
        return cmbSatCHrs;
    }

    public JComboBox getCmbSatCHrs2() {
        return cmbSatCHrs2;
    }

    public JPanel getOpenHours() {
        return openHours;
    }

    public JPanel getClosedHours() {
        return closedHours;
    }
}
