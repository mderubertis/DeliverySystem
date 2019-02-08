package delivery_system;

import delivery_system.controller.MainController;
import delivery_system.model.menu.Item;
import delivery_system.model.menu.Menu;
import delivery_system.model.orders.Order;
import delivery_system.model.orders.Orders;
import delivery_system.model.orders.Status;
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
    private static Orders orders;

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        // Initalize models and default data
        users = new Users();
        restaurants = new Restaurants();
        orders = new Orders();

        // McDonald's Menu
        Menu mcdMenu = new Menu();
        mcdMenu.addItem(new Item("Sausage n' Egg McMuffin", 3.89));
        mcdMenu.addItem(new Item("Sausage McMuffin", 1.99));
        mcdMenu.addItem(new Item("Sausage Egg & Cheese McGriddle", 4.09));
        mcdMenu.addItem(new Item("Big Mac", 5.59));
        mcdMenu.addItem(new Item("Double Big Mac", 6.99));

        // Amir Menu
        Menu amirMenu = new Menu();
        amirMenu.addItem(new Item("Tabbouleh", 4.99));
        amirMenu.addItem(new Item("Shish Taouk", 12.99));
        amirMenu.addItem(new Item("Kabab", 12.99));
        amirMenu.addItem(new Item("Shish Kabbab", 14.99));

        // Add default restaurants
        restaurants.addRestaurant(new Restaurant("McDonald's", "7685 Boulevard Maurice-Duplessis", "(514) 643-2892", new JSONObject("{\"closed\":{\"sunday\":\"11:59\",\"saturday\":\"11:59\",\"tuesday\":\"11:59\",\"wednesday\":\"11:59\",\"thursday\":\"11:59\",\"friday\":\"11:59\",\"monday\":\"11:59\"},\"opened\":{\"sunday\":\"00:00\",\"saturday\":\"00:00\",\"tuesday\":\"00:00\",\"wednesday\":\"00:00\",\"thursday\":\"00:00\",\"friday\":\"00:00\",\"monday\":\"00:00\"}}"), new String[]{"1K1"}, mcdMenu));
        restaurants.addRestaurant(new Restaurant("Amir", "7685 Boulevard Maurice-Duplessis", "(514) 643-2892", new JSONObject("{\"closed\":{\"sunday\":\"11:59\",\"saturday\":\"11:59\",\"tuesday\":\"11:59\",\"wednesday\":\"11:59\",\"thursday\":\"11:59\",\"friday\":\"11:59\",\"monday\":\"11:59\"},\"opened\":{\"sunday\":\"00:00\",\"saturday\":\"00:00\",\"tuesday\":\"00:00\",\"wednesday\":\"00:00\",\"thursday\":\"00:00\",\"friday\":\"00:00\",\"monday\":\"00:00\"}}"), new String[]{"3E1"}, amirMenu));

        // Add default users
        users.addUser(new User(Roles.ADMINISTRATOR, "Administrator", "admin", "123", "admin@example.com", "1616 René-Lévesque Blvd W, Montreal, QC", "(514) 935-7494"));
        users.addUser(new User(Roles.MANAGER, "Manager", "manager1", "123", "admin@example.com", "1616 René-Lévesque Blvd W, Montreal, QC", "(514) 935-7494", new Restaurant[]{restaurants.getRestaurant(0)}));
        users.addUser(new User(Roles.DELIVERY_MAN, "Delivery Man 1", "deli1", "123", "admin@example.com", "1616 René-Lévesque Blvd W, Montreal, QC", "(514) 935-7494", new Restaurant[]{restaurants.getRestaurant(0)}, new String[]{"3E1", "1K1"}));
        users.addUser(new User(Roles.RESTAURATEUR, "Chef 1", "chef_amir", "123", "admin@example.com", "1616 René-Lévesque Blvd W, Montreal, QC", "(514) 935-7494", new Restaurant[]{restaurants.getRestaurant(1)}));
        users.addUser(new User(Roles.RESTAURATEUR, "Chef 2", "chef_mcd", "123", "admin@example.com", "1616 René-Lévesque Blvd W, Montreal, QC", "(514) 935-7494", new Restaurant[]{restaurants.getRestaurant(0)}));
        users.addUser(new User(Roles.CLIENT, "Client Test", "client1", "123", "client@example.com", "406-8580 Maurice Duplessis", "(514) 892-5005"));

        // Add default orders
        orders.addOrder(new Order(Status.WAITING, "2019/02/03", "12:00", restaurants.getRestaurant(1), new Item[]{new Item(amirMenu.getItem(0).getName(), amirMenu.getItem(0).getPrice(), 2), amirMenu.getItem(2)}, "(514) 935-7494", "3E1", "1616 René-Lévesque Blvd W, Montreal, QC"));
        orders.addOrder(new Order(Status.ACCEPTED, "2019/02/14", "13:00", restaurants.getRestaurant(1), new Item[]{amirMenu.getItem(0).setQuantity(15)}, "(514) 935-7494", "3E1", "1616 René-Lévesque Blvd W, Montreal, QC"));
        orders.addOrder(new Order(Status.WAITING, "2019/02/16", "16:00", restaurants.getRestaurant(0), new Item[]{mcdMenu.getItem(0).setQuantity(10)}, "(514) 935-7494", "3E1", "1616 René-Lévesque Blvd W, Montreal, QC"));
        orders.addOrder(new Order(Status.ACCEPTED, "2019/02/16", "17:00", restaurants.getRestaurant(0), new Item[]{mcdMenu.getItem(1).setQuantity(2), mcdMenu.getItem(0).setQuantity(3), mcdMenu.getItem(2).setQuantity(5)}, "(514) 935-7494", "3E1", "1616 René-Lévesque Blvd W, Montreal, QC"));
        orders.addOrder(new Order(Status.READY, "2019/02/16", "19:00", restaurants.getRestaurant(0), new Item[]{mcdMenu.getItem(1).setQuantity(2), mcdMenu.getItem(0).setQuantity(3), mcdMenu.getItem(2).setQuantity(5)}, "(514) 935-7494", "3E1", "1616 René-Lévesque Blvd W, Montreal, QC"));

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

    /**
     * Gets orders.
     *
     * @return the orders
     */
    public static Orders getOrders() {
        return orders;
    }
}
