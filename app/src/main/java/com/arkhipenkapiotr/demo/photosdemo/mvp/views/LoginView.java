package com.arkhipenkapiotr.demo.photosdemo.mvp.views;

import com.arellomobile.mvp.MvpView;
import com.arkhipenkapiotr.demo.photosdemo.app.api_models.UserDTO;

/**
 * Created by arhip on 15.02.2018.
 */

public interface LoginView extends MvpView {
    void startAuthorization();
    void finishAuthorization();
    void showValidationError();
    void hideError();
    void showServerConnectionError();
    void showUnknowError();
    void showBadCredentialsError();
    void onSuccessAuthorization(UserDTO userDTO);
}
