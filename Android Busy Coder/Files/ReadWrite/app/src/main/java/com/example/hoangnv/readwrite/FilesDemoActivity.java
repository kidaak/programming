package com.example.hoangnv.readwrite;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;


public class FilesDemoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        if (BuildConfig.DEBUG && Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
            StrictMode.setThreadPolicy(buildPolicy());
        }
    }

    private StrictMode.ThreadPolicy buildPolicy() {
        return(new StrictMode.ThreadPolicy.Builder().detectAll()
                .penaltyLog().build());
    }
}
