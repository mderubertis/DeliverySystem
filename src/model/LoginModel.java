package model;

import model.users.User;
import model.users.Users;

import java.util.ArrayList;

/**
 * Delivery System
 *
 * @author Michael De Rubertis <m.derubertis@hotmail.com>
 * @version 1.0
 * @date 2019-01-17
 */

public class LoginModel {
    ArrayList<User> users;
    
    public LoginModel() {
        users = new Users().getUsers();
    }


}
