package com.example.hoangnv.lifecycle;

import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by hoangnv on 10/5/2014.
 */
public class OtherActivity extends LifecycleLoggingActivity {
    public static final String EXTRA_MESSAGE="msg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.other);
        TextView tv = (TextView)findViewById(R.id.msg);
        tv.setText(getIntent().getStringExtra(EXTRA_MESSAGE));
    }
}
