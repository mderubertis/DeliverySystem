package controller.login;

import model.users.User;
import model.users.Users;
import views.AdminView;

import javax.swing.*;

/**
 * Delivery System
 *
 * @author Michael De Rubertis <m.derubertis@hotmail.com>
 * @version 1.0
 * @date 2019-01-21
 */
public class AdminController {
    Users model = new Users();
    AdminView view;

    public AdminController(Users model, AdminView view) {
        this.model = model;
        this.view = view;

        User activeUser = model.getActiveUser();

        view.setTitle("Delivery System - [" + activeUser.getUsername() + "] (" + activeUser.getAccessLvl() + ")");
        setupMenuBar();
        view.setVisible(true);
    }

    public void setupMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        view.setJMenuBar(menuBar);

        JMenu mnFile = new JMenu("File");
        menuBar.add(mnFile);

        JMenuItem mntmDisconnect = new JMenuItem("Disconnect");
        mnFile.add(mntmDisconnect);

        JMenuItem mntmQuit = new JMenuItem("Quit");
        mnFile.add(mntmQuit);

        JMenu mnRestaurant = new JMenu("Restaurant");
        menuBar.add(mnRestaurant);

        JMenuItem mntmCreate = new JMenuItem("Create");
        mnRestaurant.add(mntmCreate);

        JMenuItem mntmEdit = new JMenuItem("Edit");
        mnRestaurant.add(mntmEdit);

        JMenuItem mntmDelete = new JMenuItem("Delete");
        mnRestaurant.add(mntmDelete);

        JMenu mnMenu = new JMenu("Menu");
        menuBar.add(mnMenu);

        JMenuItem mntmCreate_Menu = new JMenuItem("Create");
        mnMenu.add(mntmCreate_Menu);

        JMenuItem mntmEdit_Menu = new JMenuItem("Edit");
        mnMenu.add(mntmEdit_Menu);

        JMenuItem mntmDelete_Menu = new JMenuItem("Delete");
        mnMenu.add(mntmDelete_Menu);

        JMenu mnDelivery = new JMenu("Delivery Man");
        menuBar.add(mnDelivery);

        JMenuItem mntmCreate_DM = new JMenuItem("Create");
        mnDelivery.add(mntmCreate_DM);

        JMenuItem mntmEdit_DM = new JMenuItem("Edit");
        mnDelivery.add(mntmEdit_DM);

        JMenuItem mntmDelete_DM = new JMenuItem("Delete");
        mnDelivery.add(mntmDelete_DM);
    }
}
