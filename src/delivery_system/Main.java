package delivery_system;

import delivery_system.controller.MainController;
import delivery_system.model.menu.Item;
import delivery_system.model.menu.Menu;
import delivery_system.model.restaurants.Restaurant;
import delivery_system.model.restaurants.Restaurants;
import delivery_system.model.users.Roles;
import delivery_system.model.users.User;
import delivery_system.model.users.Users;
import delivery_system.views.account.AccountFrame;
import delivery_system.views.MainView;
import org.json.JSONObject;

import javax.swing.*;
import java.util.Arrays;

/**
 * Delivery System
 *
 * @author Michael De Rubertis <m.derubertis@hotmail.com>
 * @version 1.0
 * @date 2019 -01-17
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
        // Initalize models and default data
        users = new Users();
        restaurants = new Restaurants();

        Menu mcdMenu = new Menu();
        mcdMenu.addItem(new Item("Sausage n' Egg McMuffin", 3.89));
        mcdMenu.addItem(new Item("Sausage McMuffin", 1.99));
        mcdMenu.addItem(new Item("Sausage Egg & Cheese McGriddle", 4.09));
        mcdMenu.addItem(new Item("Big Mac", 5.59));
        mcdMenu.addItem(new Item("Double Big Mac", 6.99));

        Menu amirMenu = new Menu();
        amirMenu.addItem(new Item("Tabbouleh", 4.99));
        amirMenu.addItem(new Item("Shish Taouk", 12.99));
        amirMenu.addItem(new Item("Kabab", 12.99));
        amirMenu.addItem(new Item("Shish Kabbab", 14.99));

        // Add default users
        users.addUser(new User(Roles.ADMINISTRATOR, "Administrator", "admin", "123", "admin@example.com", "1616 René-Lévesque Blvd W, Montreal, QC", "(514) 935-7494"));
        users.addUser(new User(Roles.MANAGER, "Manager", "manager", "123", "admin@example.com", "1616 René-Lévesque Blvd W, Montreal, QC", "(514) 935-7494"));
        users.addUser(new User(Roles.DELIVERY_MAN, "Delivery Man 1", "deli1", "123", "admin@example.com", "1616 René-Lévesque Blvd W, Montreal, QC", "(514) 935-7494"));

        // Add default restaurants
        restaurants.addRestaurant(new Restaurant("McDonald's", "7685 Boulevard Maurice-Duplessis", "(514) 643-2892", new JSONObject("{\"closed\":{\"sunday\":\"11:59\",\"saturday\":\"11:59\",\"tuesday\":\"11:59\",\"wednesday\":\"11:59\",\"thursday\":\"11:59\",\"friday\":\"11:59\",\"monday\":\"11:59\"},\"opened\":{\"sunday\":\"00:00\",\"saturday\":\"00:00\",\"tuesday\":\"00:00\",\"wednesday\":\"00:00\",\"thursday\":\"00:00\",\"friday\":\"00:00\",\"monday\":\"00:00\"}}"), new String[]{"1K1"}, mcdMenu));
        restaurants.addRestaurant(new Restaurant("Amir", "7685 Boulevard Maurice-Duplessis", "(514) 643-2892", new JSONObject("{\"closed\":{\"sunday\":\"11:59\",\"saturday\":\"11:59\",\"tuesday\":\"11:59\",\"wednesday\":\"11:59\",\"thursday\":\"11:59\",\"friday\":\"11:59\",\"monday\":\"11:59\"},\"opened\":{\"sunday\":\"00:00\",\"saturday\":\"00:00\",\"tuesday\":\"00:00\",\"wednesday\":\"00:00\",\"thursday\":\"00:00\",\"friday\":\"00:00\",\"monday\":\"00:00\"}}"), new String[]{"1K1"}, amirMenu));

        System.out.println(Arrays.toString(restaurants.getRestaurants().toArray()));

        // Launch account/new user window
        accountFrame = new AccountFrame(users);
    }

    /**
     * Shutdown.
     */
    public static void shutdown() {
        int response = JOptionPane.showConfirmDialog(new JFrame(), "Are you sure you want to quit?", "Quit?", JOptionPane.YES_NO_OPTION);

        if (response == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    /**
     * Login.
     */
    public static void login() {
        // Launch appropriate Frame based on accessLvl
        if (users.getActiveUser() != null) {
            MainView mainView = new MainView();
            MainController mainController = new MainController(users, mainView);
            accountFrame.dispose();
        }
    }

    /**
     * Logout.
     */
    public static void logout() {
        // Remove active user
        users.setActiveUser(null);

        // Launch account/new user window
        accountFrame = new AccountFrame(users);
    }

    /**
     * Gets users.
     *
     * @return the users
     */
    public static Users getUsers() {
        return users;
    }

    /**
     * Gets restaurants.
     *
     * @return the restaurants
     */
    public static Restaurants getRestaurants() {
        return restaurants;
    }
}
