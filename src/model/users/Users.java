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
    private User activeUser;

    public Users() { this.users = new ArrayList<>(); }

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

    public User getUser(String username) {
        int index = 0;

        for (User user : this.users) {
            if (user.getUsername() == username)
                index = this.users.indexOf(user);
        }

        return this.users.get(index);
    }

    public void editUser(int user, User newUser) {
        this.users.set(user, newUser);
    }

    public void setActiveUser(User activeUser) {
        this.activeUser = activeUser;
    }

    public User getActiveUser() {
        return activeUser;
    }
}
