package delivery_system.controller.resto;

import delivery_system.model.restaurants.Restaurants;
import delivery_system.views.RestoManageView;

import java.beans.PropertyVetoException;

/**
 * Delivery System
 *
 * @author Michael De Rubertis <m.derubertis@hotmail.com>
 * @version 1.0
 * @date 2019-01-21
 */
public class RestoMangeController {
    Restaurants model = new Restaurants();
    RestoManageView view;

    public RestoMangeController(Restaurants model, RestoManageView view) {
        this.model = model;
        this.view = view;

        view.setVisible(true);

        try {
            view.setMaximum(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
    }
}
