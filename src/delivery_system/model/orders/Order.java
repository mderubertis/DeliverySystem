package delivery_system.model.orders;

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
    private String[] restaurants;
    private String[] menus;
    private String[] order;
    private String phone;
    private String[] deliveryArea;

    public Order(String status, String deliveryDate, String deliveryTime, String postalCode, String[] restaurants, String[] menus, String[] order, String phone, String[] deliveryArea) {
        this.status = status;
        this.deliveryDate = deliveryDate;
        this.deliveryTime = deliveryTime;
        this.postalCode = postalCode;
        this.restaurants = restaurants;
        this.menus = menus;
        this.order = order;
        this.phone = phone;
        this.deliveryArea = deliveryArea;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String[] getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(String[] restaurants) {
        this.restaurants = restaurants;
    }

    public String[] getMenus() {
        return menus;
    }

    public void setMenus(String[] menus) {
        this.menus = menus;
    }

    public String[] getOrder() {
        return order;
    }

    public void setOrder(String[] order) {
        this.order = order;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String[] getDeliveryArea() {
        return deliveryArea;
    }

    public void setDeliveryArea(String[] deliveryArea) {
        this.deliveryArea = deliveryArea;
    }
}
