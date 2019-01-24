package delivery_system;

import delivery_system.controller.main.MainController;
import delivery_system.model.restaurants.Restaurant;
import delivery_system.model.restaurants.Restaurants;
import delivery_system.model.users.Roles;
import delivery_system.model.users.User;
import delivery_system.model.users.Users;
import delivery_system.views.account.AccountFrame;
import delivery_system.views.MainView;

import javax.swing.*;

/**
 * Delivery System
 *
 * @author Michael De Rubertis <m.derubertis@hotmail.com>
 * @version 1.0
 * @date 2019-01-17
 */

public class Main {

    private static Users users;
    private static Restaurants restaurants;
    private static AccountFrame accountFrame;

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        // Create initial users delivery_system.model
        users = new Users();
        restaurants = new Restaurants();

        // Add default users
        users.addUser(new User(Roles.ADMINISTRATOR, "Administrator", "admin", "123", "admin@example.com", "1616 René-Lévesque Blvd W, Montreal, QC", "(514) 935-7494"));
        users.addUser(new User(Roles.MANAGER, "Manager", "manager", "123", "admin@example.com", "1616 René-Lévesque Blvd W, Montreal, QC", "(514) 935-7494"));
        users.addUser(new User(Roles.DELIVERY_MAN, "Delivery Man 1", "deli1", "123", "admin@example.com", "1616 René-Lévesque Blvd W, Montreal, QC", "(514) 935-7494"));

        // Add default restaurants
        restaurants.addRestaurant(new Restaurant("McDonald's", "7685 Boulevard Maurice-Duplessis", "(514) 643-2892", null, new String[]{"1K1"}));

        // Launch account/new user window
        accountFrame = new AccountFrame(users);

    }

    public static void shutdown() {
        int response = JOptionPane.showConfirmDialog(new JFrame(), "Are you sure you want to quit?", "Quit?", JOptionPane.YES_NO_OPTION);

        if (response == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    public static void login() {
        // Launch appropriate Frame based on accessLvl
        if (users.getActiveUser() != null) {
            MainView mainView = new MainView();
            MainController mainController = new MainController(users, mainView);
            accountFrame.dispose();
        }
    }

    public static void logout() {
        // Remove active user
        users.setActiveUser(null);

        // Launch account/new user window
        accountFrame = new AccountFrame(users);
    }

    public static Users getUsers() {
        return users;
    }

    public static Restaurants getRestaurants() {
        return restaurants;
    }
}
