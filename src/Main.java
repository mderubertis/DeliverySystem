import controller.login.LoginController;
import model.users.User;
import model.users.Users;

import java.util.Arrays;

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
        // Create initial users model
        Users users = new Users();

        // Add default users
        users.addUser(new User("administrator", "Administrator", "admin", "123", "admin@example.com", "1616 René-Lévesque Blvd W, Montreal, QC", "(514) 935-7494"));
        users.addUser(new User("manager", "Manager", "manager", "123", "admin@example.com", "1616 René-Lévesque Blvd W, Montreal, QC", "(514) 935-7494"));

        // Testing Users model
//        for (User user : users.getUsers()) {
//            System.out.println(user.toString());
//            System.out.println((user.getPassword() == "1234" ? "valid" : "invalid"));
//        }

        //System.out.println(users.getUser("manager").toString());

        LoginController loginController = new LoginController(users);
    }
}
