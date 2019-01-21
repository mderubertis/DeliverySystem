package delivery_system.controller.main;

import delivery_system.Main;
import delivery_system.controller.resto.RestoMangeController;
import delivery_system.model.users.User;
import delivery_system.model.users.Users;
import delivery_system.views.AdminView;
import delivery_system.views.RestoManageView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

/**
 * Delivery System
 *
 * @author Michael De Rubertis <m.derubertis@hotmail.com>
 * @version 1.0
 * @date 2019-01-21
 */
public class AdminController implements ActionListener {
    Users model = new Users();
    AdminView view;

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

        mntmDisconnect = new JMenuItem("Disconnect");
        mnFile.add(mntmDisconnect);

        mntmQuit = new JMenuItem("Quit");
        mntmQuit.addActionListener(this);
        mnFile.add(mntmQuit);

        JMenu mnRestaurant = new JMenu("Restaurant");
        menuBar.add(mnRestaurant);

        mntmCreate = new JMenuItem("Create");
        mntmCreate.addActionListener(this);
        mnRestaurant.add(mntmCreate);

        mntmEdit = new JMenuItem("Edit");
        mnRestaurant.add(mntmEdit);

        mntmDelete = new JMenuItem("Delete");
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

            if (menuItem == mntmQuit) {
                Main.shutdown();
            }

            if (menuItem == mntmCreate) {
                RestoManageView restoManageView = new RestoManageView();
                view.getContentPane().add(restoManageView);
                RestoMangeController restoMangeController = new RestoMangeController(Main.getRestaurants(), restoManageView);
            }
        }
    }
}
