package delivery_system.controller.main;

import delivery_system.Main;
import delivery_system.controller.resto.RestoMangeController;
import delivery_system.model.users.User;
import delivery_system.model.users.Users;
import delivery_system.views.MainView;
import delivery_system.views.RestoManageView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    public MainController(Users model, MainView view) {
        this.model = model;
        this.view = view;

        // Set title with user info
        User activeUser = model.getActiveUser();
        view.setTitle("Delivery System - [" + activeUser.getUsername() + "] (" + activeUser.getAccessLvl() + ")");

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

        switch (activeUser.getAccessLvl()) {
            case "administrator":
                setupAdminMenuBar();
                break;
            case "manager":
                break;
        }

        // Create child views but hidden, and visible on menu item click
        restoManageView = new RestoManageView();
        restoMangeController = new RestoMangeController(Main.getRestaurants(), restoManageView);
        view.getContentPane().add(restoManageView);

        // View setup
        view.setVisible(true);
    }

    public void setupAdminMenuBar() {
        ;

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
