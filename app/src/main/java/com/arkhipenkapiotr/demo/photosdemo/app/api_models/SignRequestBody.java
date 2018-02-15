package com.arkhipenkapiotr.demo.photosdemo.app.api_models;

/**
 * Created by arhip on 15.02.2018.
 */

public class SignRequestBody {
    private String login;
    private String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
