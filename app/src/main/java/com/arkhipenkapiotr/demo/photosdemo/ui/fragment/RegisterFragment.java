package com.arkhipenkapiotr.demo.photosdemo.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arkhipenkapiotr.demo.photosdemo.R;
import com.arkhipenkapiotr.demo.photosdemo.mvc.presenters.RegisterPresenter;
import com.arkhipenkapiotr.demo.photosdemo.mvc.views.RegisterView;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by arhip on 16.02.2018.
 */

public class RegisterFragment extends MvpAppCompatFragment implements RegisterView {

    @InjectPresenter
    RegisterPresenter registerPresenter;

    @BindView(R.id.fragment_register_enter_button)
    Button enterButton;

    @BindView(R.id.fragment_register_error_text_view)
    TextView errorTextView;

    @BindView(R.id.fragment_register_login_edit_text)
    EditText loginEditText;

    @BindView(R.id.fragment_register_password_edit_text)
    EditText passwordEditText;

    @BindView(R.id.fragment_register_second_password_edit_text)
    EditText secondPasswordEditText;

    @BindView(R.id.fragment_register_progress_bar)
    ProgressBar progressBar;

    @BindString(R.string.validation_error)
    String validationError;

    @BindString(R.string.server_error)
    String serverError;

    @BindString(R.string.succesful_registration)
    String succesfulRegistration;

    @BindString(R.string.password_dublicate_error)
    String passwordDublicateError;

    @BindString(R.string.unknown_error)
    String unknownError;

    @BindString(R.string.login_already_used)
    String loginAlreadyUsed;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_register, container, false);
        ButterKnife.bind(this, v);

        return v;
    }

    @OnClick(R.id.fragment_register_enter_button)
    public void register(){
        String login = loginEditText.getText().toString();
        String firstPassword = passwordEditText.getText().toString();
        String secondPassword = secondPasswordEditText.getText().toString();
        registerPresenter.register(login, firstPassword, secondPassword);
    }

    @Override
    public void startRegistration() {
        hideError();
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void finishRegistration() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showValidationError() {
        errorTextView.setText(validationError);
        errorTextView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideError() {
        errorTextView.setVisibility(View.GONE);
    }

    @Override
    public void showServerConnectionError() {
        errorTextView.setText(serverError);
        errorTextView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showPasswordDublicateError() {
        errorTextView.setText(passwordDublicateError);
        errorTextView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showUnknownError() {
        errorTextView.setText(unknownError);
        errorTextView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showLoginAlreadyUseError() {
        errorTextView.setText(loginAlreadyUsed);
        errorTextView.setVisibility(View.VISIBLE);
    }

    @Override
    public void onSuccessRegistration() {
        Toast.makeText(getContext(), succesfulRegistration, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError(String error) {
        errorTextView.setText(error);
        errorTextView.setVisibility(View.VISIBLE);
    }

}