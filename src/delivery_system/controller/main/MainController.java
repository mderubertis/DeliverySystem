package delivery_system.controller.main;

import delivery_system.Main;
import delivery_system.controller.resto.RestoMangeController;
import delivery_system.model.users.Roles;
import delivery_system.model.users.User;
import delivery_system.model.users.Users;
import delivery_system.views.AboutView;
import delivery_system.views.MainView;
import delivery_system.views.RestoManageView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.net.URL;

/**
 * Delivery System
 *
 * @author Michael De Rubertis <m.derubertis@hotmail.com>
 * @version 1.0
 * @date 2019-01-21
 */
public class MainController implements ActionListener {
    Users model = new Users();
    MainView view;

    private String role;
    private JMenuItem mntmCreate;
    private JMenuItem mntmEdit;
    private JMenuItem mntmDelete;
    private JMenuItem mntmCreate_menu;
    private JMenuItem mntmEdit_menu;
    private JMenuItem mntmQuit;
    private JMenuItem mntmDisconnect;
    private JMenuItem mntmDelete_menu;
    private JMenuItem mntmCreate_dm;
    private JMenuItem mntmEdit_dm;
    private JMenuItem mntmDelete_dm;
    private final RestoManageView restoManageView;
    private final RestoMangeController restoMangeController;
    private final JMenuBar menuBar;
    private JMenuItem mntmView_orders;

    public MainController(Users model, MainView view) {
        this.model = model;
        this.view = view;

        try {
            URL iconURL = getClass().getResource("/delivery_system/assets/icons8-meal-48.png");
            ImageIcon icon = new ImageIcon(iconURL);
            view.setIconImage(icon.getImage());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Set title with user info
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
        switch (activeUser.getAccessLvl()) {
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
        }

        // Create child views but hidden, and visible on menu item click
        restoManageView = new RestoManageView();
        restoMangeController = new RestoMangeController(Main.getRestaurants(), restoManageView);
        view.getContentPane().add(restoManageView);

        // View setup
        view.setTitle("Food Delivery System - [Logged in as " + activeUser.getUsername() + "] (" + role_readable + ")");
        view.setVisible(true);
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

        JMenu mnMenu = new JMenu("Menu");
        menuBar.add(mnMenu);

        mntmCreate_menu = new JMenuItem("Create");
        mnMenu.add(mntmCreate_menu);

        mntmEdit_menu = new JMenuItem("Edit");
        mnMenu.add(mntmEdit_menu);

        mntmDelete_menu = new JMenuItem("Delete");
        mnMenu.add(mntmDelete_menu);

        JMenu mnDelivery = new JMenu("Delivery Man");
        menuBar.add(mnDelivery);

        mntmCreate_dm = new JMenuItem("Create");
        mnDelivery.add(mntmCreate_dm);

        mntmEdit_dm = new JMenuItem("Edit");
        mnDelivery.add(mntmEdit_dm);

        mntmDelete_dm = new JMenuItem("Delete");
        mnDelivery.add(mntmDelete_dm);
    }

    public void setupDeliveryManMenuBar() {
        JMenu mnDelivery = new JMenu("Delivery Man");
        menuBar.add(mnDelivery);

        mntmCreate_dm = new JMenuItem("View");
        mnDelivery.add(mntmCreate_dm);

        mntmEdit_dm = new JMenuItem("Accept");
        mnDelivery.add(mntmEdit_dm);

        mntmDelete_dm = new JMenuItem("End");
        mnDelivery.add(mntmDelete_dm);
    }

    public void setupManagerMenuBar() {
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

        JMenu mnMenu = new JMenu("Menu");
        menuBar.add(mnMenu);

        mntmCreate_menu = new JMenuItem("Create");
        mnMenu.add(mntmCreate_menu);

        mntmEdit_menu = new JMenuItem("Edit");
        mnMenu.add(mntmEdit_menu);

        mntmDelete_menu = new JMenuItem("Delete");
        mnMenu.add(mntmDelete_menu);

        JMenu mnOrders = new JMenu("Orders");
        menuBar.add(mnOrders);

        mntmView_orders = new JMenuItem("View");
        mnOrders.add(mntmView_orders);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().getClass().getSimpleName().equals("JMenuItem")) {
            JMenuItem menuItem = (JMenuItem) e.getSource();

            if (menuItem == mntmDisconnect) {
                Main.logout();
                view.dispose();
            }

            if (menuItem == mntmQuit) {
                Main.shutdown();
            }

            if (menuItem == mntmCreate || menuItem == mntmEdit || menuItem == mntmDelete) {
                restoMangeController.showView();
            }

        }
    }
}
