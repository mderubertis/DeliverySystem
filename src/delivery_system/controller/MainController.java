package delivery_system.controller;

import delivery_system.Main;
import delivery_system.model.users.Roles;
import delivery_system.model.users.User;
import delivery_system.model.users.Users;
import delivery_system.views.*;
import delivery_system.views.account.ManageUsers;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

/**
 * Delivery System
 *
 * @author Michael De Rubertis <m.derubertis@hotmail.com>
 * @version 1.0
 * @date 2019-01-21
 */
public class MainController implements ActionListener {
    private final OrderView ordersView;
    private final OrderController ordersController;
    private final DeliveryView deliveryView;
    private final DeliveryController deliveryController;
    private MenuController menuController;
    private MenuView menuView;
    Users model;
    MainView view;

    private String role;
    private JMenuItem mntmCreate;
    private JMenuItem mntmEdit;
    private JMenuItem mntmDelete;
    private JMenuItem mntmEdit_menu;
    private JMenuItem mntmQuit;
    private JMenuItem mntmDisconnect;
    private final RestoManageView restoManageView;
    private final RestoMangeController restoMangeController;
    private final JMenuBar menuBar;
    private JMenuItem mntmView_orders;
    private JMenu mnOrders;
    private JMenuItem mntmUserMan_resto;
    private JMenuItem mntmView_dm;

    public MainController(Users model, MainView view) {
        this.model = model;
        this.view = view;

        try {
            view.setIconImage(new ImageIcon(getClass().getResource("/delivery_system/assets/icons8-meal-48.png")).getImage());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Set user
        User activeUser = model.getActiveUser();

        // Setup menubar based on permissions
        menuBar = new JMenuBar();
        view.setJMenuBar(menuBar);

        JMenu mnFile = new JMenu("File");
        menuBar.add(mnFile);

        mntmDisconnect = new JMenuItem("Disconnect");
        mntmDisconnect.addActionListener(this);
        mnFile.add(mntmDisconnect);

        mntmQuit = new JMenuItem("Quit");
        mntmQuit.addActionListener(this);
        mnFile.add(mntmQuit);

        // Set permissions for frame
        String role_readable = "";
        role = activeUser.getAccessLvl();

        // Check permissions and create menu bar
        switch (role) {
            case Roles.ADMINISTRATOR:
                setupAdminMenuBar();
                role_readable = Roles.ADMINISTRATOR;
                break;
            case Roles.MANAGER:
                setupManagerMenuBar();
                role_readable = Roles.MANAGER;
                break;
            case Roles.DELIVERY_MAN:
                setupDeliveryManMenuBar();
                role_readable = "delivery man";
                break;
            case Roles.RESTAURATEUR:
                setupChefMenuBar();
                role_readable = "restaurateur";
                break;
            case Roles.CLIENT:
                role_readable = "client";
                break;
        }

        // Create child views but hidden, and visible on menu item click
        restoManageView = new RestoManageView();
        restoMangeController = new RestoMangeController(Main.getRestaurants(), restoManageView);
        view.getContentPane().add(restoManageView);

        menuView = new MenuView();
        menuController = new MenuController(Main.getRestaurants(), menuView);
        view.getContentPane().add(menuView);

        ordersView = new OrderView();
        ordersController = new OrderController(Main.getOrders(), ordersView);
        view.getContentPane().add(ordersView);

        deliveryView = new DeliveryView();
        deliveryController = new DeliveryController(Main.getOrders(), deliveryView);
        view.getContentPane().add(deliveryView);

        // View setup
        view.setTitle("Food Delivery System - [Logged in as " + activeUser.getUsername() + "] (" + role_readable + ")");
        view.setVisible(true);
    }

    private void setupChefMenuBar() {
        mnOrders = new JMenu("Orders");
        menuBar.add(mnOrders);

        mntmView_orders = new JMenuItem("View");
        mntmView_orders.addActionListener(this);
        mnOrders.add(mntmView_orders);
    }

    public void setupAdminMenuBar() {
        JMenu mnRestaurant = new JMenu("Restaurant");
        menuBar.add(mnRestaurant);

        mntmCreate = new JMenuItem("Create");
        mntmCreate.addActionListener(this);
        mnRestaurant.add(mntmCreate);

        mntmEdit = new JMenuItem("Edit");
        mntmEdit.addActionListener(this);
        mnRestaurant.add(mntmEdit);

        mntmDelete = new JMenuItem("Delete");
        mntmDelete.addActionListener(this);
        mnRestaurant.add(mntmDelete);

        JMenu mnRestoUsers = new JMenu("Users");
        mnRestaurant.add(mnRestoUsers);

        mntmUserMan_resto = new JMenuItem("Manage");
        mntmUserMan_resto.addActionListener(this);
        mnRestoUsers.add(mntmUserMan_resto);

        JMenu mnMenu = new JMenu("Menu");
        menuBar.add(mnMenu);

        mntmEdit_menu = new JMenuItem("Edit");
        mntmEdit_menu.addActionListener(this);
        mnMenu.add(mntmEdit_menu);
    }

    public void setupDeliveryManMenuBar() {
        JMenu mnDelivery = new JMenu("Deliveries");
        menuBar.add(mnDelivery);

        mntmView_dm = new JMenuItem("View");
        mntmView_dm.addActionListener(this);
        mnDelivery.add(mntmView_dm);
    }

    public void setupManagerMenuBar() {
        JMenu mnRestaurant = new JMenu("Restaurant");
        menuBar.add(mnRestaurant);

        mntmEdit = new JMenuItem("Edit");
        mntmEdit.addActionListener(this);
        mnRestaurant.add(mntmEdit);

        mntmDelete = new JMenuItem("Delete");
        mntmDelete.addActionListener(this);
        mnRestaurant.add(mntmDelete);

        JMenu mnMenu = new JMenu("Menu");
        menuBar.add(mnMenu);

        mntmEdit_menu = new JMenuItem("Edit");
        mnMenu.add(mntmEdit_menu);

        mnOrders = new JMenu("Orders");
        menuBar.add(mnOrders);

        mntmView_orders = new JMenuItem("View");
        mnOrders.add(mntmView_orders);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().getClass().getSimpleName().equals("JMenuItem")) {
            JMenuItem menuItem = (JMenuItem) e.getSource();
            String[] options = {"Add", "Cancel"};
            String[] restos = new String[Main.getRestaurants().getRestaurants().size()];

            if (Main.getRestaurants().getRestaurants().size() == 0) {
                restos = new String[1];
                restos[0] = "No restaurants";
            } else {
                for (int i = 0; i < Main.getRestaurants().getRestaurants().size(); i++)
                    restos[i] = Main.getRestaurants().getRestaurant(i).getName();

            }

            // COMMON
            if (menuItem == mntmDisconnect) {
                Main.logout();
                view.dispose();
            }

            if (menuItem == mntmQuit) {
                Main.shutdown();
            }

            // ADMIN
            if (menuItem == mntmCreate || menuItem == mntmEdit || menuItem == mntmDelete || menuItem == mntmUserMan_resto) {

                final JComboBox combo = new JComboBox<>(restos);
                if (menuItem == mntmEdit) {
                    options[0] = "Edit";

                    String title = "Choose restaurant to edit";
                    int selection = JOptionPane.showOptionDialog(null, combo, title,
                            JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options,
                            options[0]);

                    if (selection == 0) {
                        restoMangeController.setCurrentResto(Main.getRestaurants().getRestaurant(combo.getSelectedIndex()));
                        restoMangeController.setEdit(true);
                        restoMangeController.showView();
                    }
                } else if (menuItem == mntmDelete) {
                    options[0] = "Delete";

                    String title = "Choose restaurant to delete";
                    int selection = JOptionPane.showOptionDialog(null, combo, title,
                            JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options,
                            options[0]);

                    if (selection == 0) {
                        Main.getRestaurants().delRestaurant(combo.getSelectedIndex());
                    }
                } else if (menuItem == mntmUserMan_resto) {
                    ManageUsers manageUsers = new ManageUsers();
                    manageUsers.setVisible(true);
                } else {
                    restoMangeController.setEdit(false);
                    restoMangeController.showView();
                }
            }

            if (menuItem == mntmEdit_menu) {
                menuController.showView();
            }

            // RESTAURATEUR
            if (menuItem == mntmView_orders) {
                ordersController.showView();
            }

            // DELIVERY GUY
            if (menuItem == mntmView_dm) {
                System.out.println("deliMange");
                deliveryController.showView();
            }
        }
    }
}
