package com.example.hoangnv.postdelayed;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


public class PostDelayedDemo extends Activity implements Runnable{
    private static final int PERIOD = 5000;
    private View root = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        root = findViewById(android.R.id.content);
    }

    @Override
    protected void onResume() {
        super.onResume();

        run();
    }

    @Override
    protected void onPause() {
        root.removeCallbacks(this);
        super.onPause();
    }

    @Override
    public void run() {
        Toast.makeText(PostDelayedDemo.this, "Who-hoo!", Toast.LENGTH_SHORT).show();
        root.postDelayed(this, PERIOD);
    }
}
