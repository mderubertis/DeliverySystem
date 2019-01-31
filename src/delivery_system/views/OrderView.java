package delivery_system.views;

import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.text.MaskFormatter;

public class OrderView extends JInternalFrame {

    private final JTable table;
	private JFormattedTextField textField;
	private final JLabel lblViewTitle;
	private final JPanel mainPanel;
    private final JList list;
    private final JButton btnAcceptOrder;
    private final JButton btnOrderReady;


    /**
	 * Initialize the contents of the frame.
	 */
	public OrderView() {
		setTitle("Order Management");
		setIconifiable(true);
		setMaximizable(true);
		setRootPaneCheckingEnabled(false);
		setResizable(true);
		setClosable(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setMaximumSize(new Dimension(825, 585));

		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout(0, 0));

		JPanel panel_3 = new JPanel();
		mainPanel.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(0, 90, 0, 90));
		panel_3.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JPanel panel_10 = new JPanel();
		panel.add(panel_10);

		lblViewTitle = new JLabel("Order Management");
		panel_10.add(lblViewTitle);
		lblViewTitle.setFont(new Font("Consolas", Font.BOLD, 30));

		JPanel panel_14 = new JPanel();
		panel.add(panel_14);
		panel_14.setLayout(new GridLayout(0, 2, 5, 5));

		JLabel lblDeliveryTime = new JLabel("Delivery Time (yyyy/mm/dd hh:mm)");
		panel_14.add(lblDeliveryTime);

		textField = new JFormattedTextField(createFormatter("####-##-## ##:##"));
        textField.setColumns(17);
		textField.setMargin(new Insets(2, 2, 2, 80));
		textField.setColumns(10);
		panel_14.add(textField);

		JLabel lblPostalCode = new JLabel("Postal Code");
		panel_14.add(lblPostalCode);

        JFormattedTextField ftxtPostal = null;
        try {
            ftxtPostal = new JFormattedTextField(new MaskFormatter("U#U #U#"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        panel_14.add(ftxtPostal);

		JPanel panel_6 = new JPanel();
		panel.add(panel_6);
		panel_6.setBorder(new EmptyBorder(16, 0, 0, 0));
		panel_6.setPreferredSize(new Dimension(345, 250));
		panel_6.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel = new JLabel("Items");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_6.add(lblNewLabel, BorderLayout.NORTH);
		lblNewLabel.setFont(new Font("Consolas", Font.BOLD, 20));

		JScrollPane scrollPane = new JScrollPane();
		panel_6.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		table.setShowGrid(false);
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);

		JTableHeader tableHeader = table.getTableHeader();
		scrollPane.setColumnHeaderView(tableHeader);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EmptyBorder(0, 0, 95, 0));
		panel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 5));

		JPanel panel_13 = new JPanel();
		panel_2.add(panel_13, BorderLayout.CENTER);
		panel_13.setPreferredSize(new Dimension(343, 90));

        btnAcceptOrder = new JButton("Accept Order");
		panel_13.add(btnAcceptOrder);

        btnOrderReady = new JButton("Order Ready");
		btnOrderReady.setEnabled(false);
		panel_13.add(btnOrderReady);

		JPanel panel_1 = new JPanel();
		panel_3.add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));

		JScrollPane scrollPane_1 = new JScrollPane();
		panel_1.add(scrollPane_1);

        list = new JList();
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_1.setViewportView(list);

		JLabel lblRestaurants = new JLabel("Orders");
		lblRestaurants.setHorizontalAlignment(SwingConstants.CENTER);
		lblRestaurants.setFont(new Font("Tahoma", Font.BOLD, 14));
		scrollPane_1.setColumnHeaderView(lblRestaurants);
		tableHeader.setReorderingAllowed(false);
		tableHeader.setResizingAllowed(false);
	}

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JList getList() {
        return list;
    }

    public JTable getTable() {
        return table;
    }

    public JLabel getLblViewTitle() {
        return lblViewTitle;
    }

    public JButton getBtnAcceptOrder() {
        return btnAcceptOrder;
    }

    public JButton getBtnOrderReady() {
        return btnOrderReady;
    }

    private MaskFormatter createFormatter(String s) {
        MaskFormatter formatter = null;
        try {
            formatter = new MaskFormatter(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formatter;
    }
}
