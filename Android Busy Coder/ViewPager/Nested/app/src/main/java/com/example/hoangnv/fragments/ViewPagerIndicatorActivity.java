package com.example.hoangnv.fragments;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;


public class ViewPagerIndicatorActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getSupportFragmentManager().findFragmentById(android.R.id.content) == null){
            getSupportFragmentManager().beginTransaction().add(android.R.id.content, new PagerFragment()).commit();
        }
    }
}
