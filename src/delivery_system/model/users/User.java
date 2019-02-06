package delivery_system.model.users;

import delivery_system.model.restaurants.Restaurant;
import delivery_system.model.restaurants.Restaurants;

import java.util.Arrays;

/**
 * Delivery System
 *
 * @author Michael De Rubertis <m.derubertis@hotmail.com>
 * @version 1.0
 * @date 1/17/2019
 */

public class User {
    private String accessLvl;
    private String name;
    private String username;
    private String password;
    private String email;
    private String address;
    private String phone;
    private Restaurant[] restaurants;
    private String[] deliveryArea;

    public User(String accessLvl, String name, String username, String password, String email, String address, String phone, Restaurant[] restaurants) {
        this.accessLvl = accessLvl;
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.restaurants = restaurants;
    }

    public User(String accessLvl, String name, String username, String password, String email, String address, String phone) {
        this.accessLvl = accessLvl;
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }

    public User(String accessLvl, String name, String username, String password, String email, String address, String phone, Restaurant[] restaurants, String[] deliveryArea) {
        this.accessLvl = accessLvl;
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.restaurants = restaurants;
        this.deliveryArea = deliveryArea;
    }

    @Override
    public String toString() {
        return "User{" +
                "accessLvl='" + accessLvl + '\'' +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", restaurants=" + Arrays.toString(restaurants) +
                '}';
    }

    public String getAccessLvl() {
        return accessLvl;
    }

    public void setAccessLvl(String accessLvl) {
        this.accessLvl = accessLvl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Restaurant[] getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(Restaurant[] restaurants) {
        this.restaurants = restaurants;
    }

    public void addRestaurant(Restaurant restaurant) {
        Restaurant[] currentRestaurants = this.restaurants;
        this.restaurants = new Restaurant[this.restaurants.length + 1];
        System.arraycopy(currentRestaurants, 0, this.restaurants, 0, currentRestaurants.length);
        this.restaurants[this.restaurants.length - 1] = restaurant;
    }

    public String[] getDeliveryArea() {
        return deliveryArea;
    }

    public void setDeliveryArea(String[] deliveryArea) {
        this.deliveryArea = deliveryArea;
    }

    public void addDeiveryArea(String deliveryArea) {
        String[] currentAreas = this.deliveryArea;
        this.deliveryArea = new String[this.deliveryArea.length + 1];
        System.arraycopy(currentAreas, 0, this.deliveryArea, 0, currentAreas.length);
        this.deliveryArea[this.restaurants.length - 1] = deliveryArea;
    }
}
