package com.arkhipenkapiotr.demo.photosdemo.ui.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.arkhipenkapiotr.demo.photosdemo.ui.fragment.LoginFragment;

/**
 * Created by arhip on 15.02.2018.
 */

public class AuthFragmentPagerAdapter extends FragmentPagerAdapter {


    public AuthFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new LoginFragment();
            case 1:
                return new LoginFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Login";
            case 1:
                return "Register";
        }
        return null;
    }
}
