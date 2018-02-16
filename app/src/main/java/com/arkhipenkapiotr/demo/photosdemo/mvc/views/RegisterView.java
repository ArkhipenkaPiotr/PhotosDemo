package com.arkhipenkapiotr.demo.photosdemo.mvc.views;

import com.arellomobile.mvp.MvpView;

/**
 * Created by arhip on 16.02.2018.
 */

public interface RegisterView extends MvpView {
    void startRegistration();
    void finishRegistration();

    void showServerConnectionError();
    void showPasswordDublicateError();
    void showUnknownError();
    void showLoginAlreadyUseError();
    void showValidationError();
    void showError(String error);
    void hideError();

    void onSuccessRegistration();
}
