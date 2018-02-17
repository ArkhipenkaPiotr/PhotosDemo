package com.arkhipenkapiotr.demo.photosdemo.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
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
import com.arkhipenkapiotr.demo.photosdemo.app.api_models.UserDTO;
import com.arkhipenkapiotr.demo.photosdemo.mvp.presenters.LoginPresenter;
import com.arkhipenkapiotr.demo.photosdemo.mvp.views.LoginView;
import com.arkhipenkapiotr.demo.photosdemo.util.PreferencesUtil;

import java.util.zip.Inflater;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by arhip on 15.02.2018.
 */

public class LoginFragment extends MvpAppCompatFragment implements LoginView {

    @BindView(R.id.fragment_login_login_edit_text)
    EditText loginEditText;

    @BindView(R.id.fragment_login_password_edit_text)
    EditText passwordEditText;

    @BindView(R.id.fragment_login_enter_button)
    Button enterButton;

    @BindView(R.id.fragment_login_error_text_view)
    TextView errorTextView;

    @BindView(R.id.fragment_login_progress_bar)
    ProgressBar progressBar;

    @InjectPresenter
    LoginPresenter loginPresenter;

    @BindString(R.string.validation_error)
    String validationError;

    @BindString(R.string.server_error)
    String serverError;

    @BindString(R.string.unknown_error)
    String unknownError;

    @BindString(R.string.bad_credentials)
    String badCredentials;



    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_login, container, false);
        unbinder = ButterKnife.bind(this,v);

        return v;
    }

    @OnClick(R.id.fragment_login_enter_button)
    public void enter(){
        loginPresenter.logIn(loginEditText.getText().toString(), passwordEditText.getText().toString());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void startAuthorization() {
        errorTextView.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void finishAuthorization() {
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
    public void showUnknowError() {
        errorTextView.setText(unknownError);
        errorTextView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showBadCredentialsError() {
        errorTextView.setText(badCredentials);
        errorTextView.setVisibility(View.VISIBLE);
    }

    @Override
    public void onSuccessAuthorization(UserDTO userDTO) {
        Toast.makeText(getContext(), "Welcome!", Toast.LENGTH_SHORT).show();
        PreferencesUtil.putUserDTO(getActivity(), userDTO);
    }
}
