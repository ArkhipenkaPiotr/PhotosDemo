package com.arkhipenkapiotr.demo.photosdemo.mvp.presenters;

import android.util.Patterns;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.arkhipenkapiotr.demo.photosdemo.app.PhotosDemoApp;
import com.arkhipenkapiotr.demo.photosdemo.app.api_models.UserDTO;
import com.arkhipenkapiotr.demo.photosdemo.mvp.views.RegisterView;
import com.arkhipenkapiotr.demo.photosdemo.app.api_models.SignRequestBody;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by arhip on 16.02.2018.
 */

@InjectViewState
public class RegisterPresenter extends MvpPresenter<RegisterView> {

    public void register(String login, String firstPassword, String secondPassword){
        getViewState().startRegistration();
        if (!firstPassword.equals(secondPassword)){
            getViewState().finishRegistration();
            getViewState().showPasswordDublicateError();
            return;
        }
        if (!isCorrect(login,firstPassword)){
            getViewState().finishRegistration();
            getViewState().showValidationError();
        }
        else{
            SignRequestBody signRequestBody = new SignRequestBody();
            signRequestBody.setLogin(login);
            signRequestBody.setPassword(firstPassword);

            PhotosDemoApp.getApi().signUp(signRequestBody).enqueue(new Callback<UserDTO>() {
                @Override
                public void onResponse(Call<UserDTO> call, Response<UserDTO> response) {
                    getViewState().finishRegistration();
                    if (response.code()==200){
                        getViewState().onSuccessRegistration(response.body());
                    }
                    else{
                        if (response.code()==400){
                            getViewState().showLoginAlreadyUseError();
                        }
                        else{
                            getViewState().showUnknownError();
                        }
                    }
                }

                @Override
                public void onFailure(Call<UserDTO> call, Throwable t) {
                    getViewState().finishRegistration();
                    getViewState().showError(t.getMessage());
                }
            });
        }
    }

    private boolean isCorrect(String login, String password){
        return isLoginCorrect(login) && isPasswordCorrect(password);
    }

    private boolean isLoginCorrect(String login){
        return !login.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(login).matches();
    }

    private boolean isPasswordCorrect(String password){
        return password.length()>8;
    }
}
