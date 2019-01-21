package delivery_system;

import delivery_system.controller.main.AdminController;
import delivery_system.model.users.User;
import delivery_system.model.users.Users;
import delivery_system.views.AdminView;

import javax.swing.*;

/**
 * Delivery System
 *
 * @author Michael De Rubertis <m.derubertis@hotmail.com>
 * @version 1.0
 * @date 2019-01-17
 */

public class Main {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        // Create initial users delivery_system.model
        Users users = new Users();

        // Add default users
        users.addUser(new User("administrator", "Administrator", "admin", "123", "admin@example.com", "1616 René-Lévesque Blvd W, Montreal, QC", "(514) 935-7494"));
        users.addUser(new User("manager", "Manager", "manager", "123", "admin@example.com", "1616 René-Lévesque Blvd W, Montreal, QC", "(514) 935-7494"));

        // Set active user to test admin
        // Usually done on successful login
        users.setActiveUser(users.getUser("admin"));

        // Launch appropriate Frame based on accessLvl
        switch (users.getActiveUser().getAccessLvl()) {
            case "administrator":
                AdminView adminView = new AdminView();
                AdminController adminController = new AdminController(users, adminView);
                break;
        }


    }

    public static void shutdown() {
        int response = JOptionPane.showConfirmDialog(new JFrame(), "Are you sure you want to quit?", "Quit?", JOptionPane.YES_NO_OPTION);
    }
}
