package delivery_system.model.restaurants;

import delivery_system.model.menu.Menu;
import org.json.JSONObject;

import java.util.Arrays;

/**
 * Delivery System
 *
 * @author Michael De Rubertis <m.derubertis@hotmail.com>
 * @version 1.0
 * @date 1/17/2019
 */

public class Restaurant {
    private String name;
    private String address;
    private String phone;
    private JSONObject hours; // may change depending on input collection
    private String[] delieveryArea;
    private Menu menu;

    public Restaurant(String name, String address, String phone, JSONObject hours, String[] delieveryArea, Menu menu) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.hours = hours;
        this.delieveryArea = delieveryArea;
        this.menu = menu;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", hours=" + hours +
                ", delieveryArea=" + Arrays.toString(delieveryArea) +
                ", menu=" + menu.toString() +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public JSONObject getHours() {
        return hours;
    }

    public void setHours(JSONObject hours) {
        this.hours = hours;
    }

    public String[] getDelieveryArea() {
        return delieveryArea;
    }

    public void setDelieveryArea(String[] delieveryArea) {
        this.delieveryArea = delieveryArea;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
