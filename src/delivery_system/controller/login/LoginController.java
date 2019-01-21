package delivery_system.controller.login;

import delivery_system.model.users.Users;

/**
 * Delivery System
 *
 * @author Michael De Rubertis <m.derubertis@hotmail.com>
 * @version 1.0
 * @date 2019-01-17
 */

public class LoginController {
    Users model = new Users();
    //LoginView view;

    public LoginController(Users model) {
        this.model = model;
        //this.view = view;
    }
}
