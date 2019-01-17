package controller.login;

import model.LoginModel;

/**
 * Created by mderubertis on 2019-01-17.
 */
public class LoginController {
    private LoginModel model = new LoginModel();

    public LoginController(LoginModel model) {
        this.model = model;
    }
}
