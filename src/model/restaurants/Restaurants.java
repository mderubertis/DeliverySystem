package model.restaurants;

import java.util.ArrayList;

/**
 * Delivery System
 *
 * @author Michael De Rubertis <m.derubertis@hotmail.com>
 * @version 1.0
 * @date 1/17/2019
 */

public class Restaurants {
    private ArrayList<Restaurant> restaurants;

    public Restaurants(ArrayList<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    public ArrayList<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void addRestaurant(Restaurant restaurant) {
        this.restaurants.add(restaurant);
    }

    public void delRestaurant(int restaurant) {
        this.restaurants.remove(restaurant);
    }

    public Restaurant getRestaurant(int restaurant) {
        return this.restaurants.get(restaurant);
    }

    public void editRestaurant(int restaurant, Restaurant newRestaurant) {
        this.restaurants.set(restaurant, newRestaurant);
    }
}
