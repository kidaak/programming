package com.example.hoangnv.dynamic;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DynamicFragmentsDemoActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void showOther(View v) {
        startActivity(new Intent(this, OtherActivity.class));
    }
}
