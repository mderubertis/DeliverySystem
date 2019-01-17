package model.users;

import java.util.ArrayList;

/**
 * Delivery System
 *
 * @author Michael De Rubertis <m.derubertis@hotmail.com>
 * @version 1.0
 * @date 1/17/2019
 */

public class Users {
    private ArrayList<User> users;

    public Users(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public void delUser(int user) {
        this.users.remove(user);
    }

    public User getUser(int user) {
        return this.users.get(user);
    }

    public void editUser(int user, User newUser) {
        this.users.set(user, newUser);
    }
}
