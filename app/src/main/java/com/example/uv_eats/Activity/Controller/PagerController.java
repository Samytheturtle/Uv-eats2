package com.example.uv_eats.Activity.Controller;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.uv_eats.Activity.POCO.Auth;


public class PagerController extends FragmentPagerAdapter {
    int numOfTabs;
    Auth autenticacionRecibida;
    public PagerController(@NonNull FragmentManager fm, int behavior, Auth autenticacion) {
        super(fm, behavior);
        this.numOfTabs = behavior;
        this.autenticacionRecibida=autenticacion;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new Menu();
            case 1:
                return new Products();
            case 2:
                return new Cart();
            case 3:
                return new Record();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
