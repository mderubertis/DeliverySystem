package delivery_system.model.orders;

import delivery_system.model.menu.Item;
import delivery_system.model.restaurants.Restaurant;

import java.util.Arrays;

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
    private Restaurant restaurant;
    private Item[] items;
    private String phone;
    private String deliveryArea;
    private String deliveryAddress;

    public Order(String status, String deliveryDate, String deliveryTime, Restaurant restaurant, Item[] items, String phone, String deliveryArea, String deliveryAddress) {
        this.status = status;
        this.deliveryDate = deliveryDate;
        this.deliveryTime = deliveryTime;
        this.restaurant = restaurant;
        this.items = items;
        this.phone = phone;
        this.deliveryArea = deliveryArea;
        this.deliveryAddress = deliveryAddress;
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

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public Item[] getItems() {
        return items;
    }

    public String getPhone() {
        return phone;
    }

    public String getDeliveryArea() {
        return deliveryArea;
    }

    @Override
    public String toString() {
        return "Order{" +
                "status='" + status + '\'' +
                ", deliveryDate='" + deliveryDate + '\'' +
                ", deliveryTime='" + deliveryTime + '\'' +
                ", restaurant=" + restaurant +
                ", items=" + Arrays.toString(items) +
                ", phone='" + phone + '\'' +
                ", deliveryArea='" + deliveryArea + '\'' +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                '}';
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
