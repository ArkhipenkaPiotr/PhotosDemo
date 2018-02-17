package com.arkhipenkapiotr.demo.photosdemo.ui.activity;

import android.content.Intent;
import android.os.Bundle;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arkhipenkapiotr.demo.photosdemo.mvp.presenters.MainPresenter;
import com.arkhipenkapiotr.demo.photosdemo.mvp.views.MainView;

public class MainActivity extends MvpAppCompatActivity implements MainView {

    @InjectPresenter
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setAuthorized(boolean isAuthorized) {
        Intent intent = isAuthorized?null:new Intent(this,AuthActivity.class);

        startActivity(intent);
    }
}
