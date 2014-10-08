package com.example.hoangnv.lifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by hoangnv on 10/5/2014.
 */
public class ExplicitIntentsDemoActivity extends LifecycleLoggingActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void showOther(View v){
        Intent other = new Intent(this, OtherActivity.class);
        other.putExtra(OtherActivity.EXTRA_MESSAGE, getString(R.string.other));
        startActivity(other);
    }

}
