package com.example.hoangnv.dynamic;

import android.os.Bundle;

/**
 * Created by hoangnv on 10/9/2014.
 */
public class OtherActivity extends LifecycleLoggingActivity{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getFragmentManager().findFragmentById(android.R.id.content) == null){
            getFragmentManager().beginTransaction().add(android.R.id.content, new OtherFragment()).commit();
        }
    }
}
