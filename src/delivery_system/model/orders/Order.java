package delivery_system.model.orders;

import delivery_system.model.menu.Item;
import delivery_system.model.restaurants.Restaurant;

/**
 * Delivery System
 *
 * @author Michael De Rubertis <m.derubertis@hotmail.com>
 * @version 1.0
 * @date 1/17/2019
 */

public class Order {
    private String status;
    private String deliveryDate;
    private String deliveryTime;
    private String postalCode;
    private Restaurant restaurant;
    private Item[] items;
    private String phone;
    private String[] deliveryArea;

    public Order(String status, String deliveryDate, String deliveryTime, String postalCode, Restaurant restaurant, Item[] items, String phone, String[] deliveryArea) {
        this.status = status;
        this.deliveryDate = deliveryDate;
        this.deliveryTime = deliveryTime;
        this.postalCode = postalCode;
        this.restaurant = restaurant;
        this.items = items;
        this.phone = phone;
        this.deliveryArea = deliveryArea;
    }

    public String getStatus() {
        return status;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public Item[] getItems() {
        return items;
    }

    public String getPhone() {
        return phone;
    }

    public String[] getDeliveryArea() {
        return deliveryArea;
    }
}
