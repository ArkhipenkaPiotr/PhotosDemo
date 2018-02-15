package com.arkhipenkapiotr.demo.photosdemo.app.api_models;

/**
 * Created by arhip on 15.02.2018.
 */

public class SignResponseBody {
    private String login;
    private String token;
    private Long userId;

    public SignResponseBody() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
