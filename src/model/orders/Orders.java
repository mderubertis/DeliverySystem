package model.orders;

import java.util.ArrayList;

/**
 * Delivery System
 *
 * @author Michael De Rubertis <m.derubertis@hotmail.com>
 * @version 1.0
 * @date 1/17/2019
 */

public class Orders {
    private ArrayList<Order> orders;

    public Orders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void addOrder(Order order) {
        this.orders.add(order);
    }

    public void delOrder(int order) {
        this.orders.remove(order);
    }

    public Order getOrder(int order) {
        return this.orders.get(order);
    }

    public void editOrder(int order, Order newOrder) {
        this.orders.set(order, newOrder);
    }
}
