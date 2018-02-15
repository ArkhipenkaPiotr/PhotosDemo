package com.arkhipenkapiotr.demo.photosdemo.mvc.presenters;

import com.arellomobile.mvp.MvpPresenter;
import com.arkhipenkapiotr.demo.photosdemo.mvc.views.MainView;

/**
 * Created by arhip on 15.02.2018.
 */

public class MainPresenter extends MvpPresenter<MainView> {

    @Override
    public void attachView(MainView view) {
        super.attachView(view);

        //Needs to add the authorisation check
        view.setAuthorized(false);
    }
}
