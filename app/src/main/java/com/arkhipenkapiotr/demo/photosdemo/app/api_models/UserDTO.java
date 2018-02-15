package com.arkhipenkapiotr.demo.photosdemo.app.api_models;

/**
 * Created by arhip on 15.02.2018.
 */

public class UserDTO {
    private String login;
    private String token;
    private Long userId;

    public UserDTO() {
    }

    public UserDTO(String login, String token, Long userId) {
        this.login = login;
        this.token = token;
        this.userId = userId;
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
