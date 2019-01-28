package delivery_system.model.menu;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Delivery System
 *
 * @author Michael De Rubertis <m.derubertis@hotmail.com>
 * @version 1.0
 * @date 1/17/2019
 */

public class Menu {
    private ArrayList<Item> menu;

    public Menu() {
        this.menu = new ArrayList<>();
    }

    public ArrayList<Item> getItems() {
        return menu;
    }

    public void addItem(Item item) {
        this.menu.add(item);
    }

    public void delItem(int item) {
        this.menu.remove(item);
    }

    public Item getItem(int item) {
        return this.menu.get(item);
    }

    public Item getItem(Item item) {
        return this.menu.get(this.menu.indexOf(item));
    }

    public void editItem(int item, Item newItem) {
        this.menu.set(item, newItem);
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menu=" + Arrays.toString(menu.toArray()) +
                '}';
    }
}
