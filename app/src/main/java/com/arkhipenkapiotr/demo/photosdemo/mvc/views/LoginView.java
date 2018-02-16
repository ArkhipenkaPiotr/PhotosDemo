package com.arkhipenkapiotr.demo.photosdemo.mvc.views;

import com.arellomobile.mvp.MvpView;

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
    void onSuccessAuthorization();
}
