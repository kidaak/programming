package com.example.hoangnv.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class RotationFragmentDemo extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getFragmentManager().findFragmentById(android.R.id.content) == null){
            getFragmentManager().beginTransaction().add(android.R.id.content, new RotationFragment()).commit();
        }
    }
}
