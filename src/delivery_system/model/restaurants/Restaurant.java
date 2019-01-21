package delivery_system.model.restaurants;

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
    private String[] hours; // may change depending on input collection
    private String[] delieveryArea;

    public Restaurant(String name, String address, String phone, String[] hours, String[] delieveryArea) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.hours = hours;
        this.delieveryArea = delieveryArea;
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

    public String[] getHours() {
        return hours;
    }

    public void setHours(String[] hours) {
        this.hours = hours;
    }

    public String[] getDelieveryArea() {
        return delieveryArea;
    }

    public void setDelieveryArea(String[] delieveryArea) {
        this.delieveryArea = delieveryArea;
    }
}
