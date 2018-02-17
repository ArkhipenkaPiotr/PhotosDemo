package com.arkhipenkapiotr.demo.photosdemo.mvp.presenters;

import android.util.Patterns;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.arkhipenkapiotr.demo.photosdemo.app.PhotosDemoApp;
import com.arkhipenkapiotr.demo.photosdemo.app.api_models.SignRequestBody;
import com.arkhipenkapiotr.demo.photosdemo.app.api_models.UserDTO;
import com.arkhipenkapiotr.demo.photosdemo.mvp.views.LoginView;

import java.net.InetAddress;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by arhip on 15.02.2018.
 */

@InjectViewState
public class LoginPresenter extends MvpPresenter<LoginView> {

    public void logIn(String login, String password){
        getViewState().startAuthorization();
        getViewState().hideError();
        if (!isCorrect(login, password)){
            getViewState().finishAuthorization();
            getViewState().showValidationError();
        }
        else{
            SignRequestBody requestBody = new SignRequestBody();
            requestBody.setLogin(login);
            requestBody.setPassword(password);

            PhotosDemoApp.getApi().signIn(requestBody).enqueue(new Callback<UserDTO>() {
                @Override
                public void onResponse(Call<UserDTO> call, Response<UserDTO> response) {
                    getViewState().finishAuthorization();
                    if (response.code()==200){
                        getViewState().onSuccessAuthorization(response.body());
                    }
                    else{
                        if (response.code()==400){
                            getViewState().showBadCredentialsError();
                        }
                        else {
                            getViewState().showUnknowError();
                        }
                    }
                }

                @Override
                public void onFailure(Call<UserDTO> call, Throwable t) {
                    getViewState().showServerConnectionError();
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
