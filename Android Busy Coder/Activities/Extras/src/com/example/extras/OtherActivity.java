package com.example.extras;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class OtherActivity extends Activity {
	public static final String EXTRA_MESSAGE = "msg";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.other);

		TextView tv = (TextView) findViewById(R.id.msg);
		tv.setText(getIntent().getStringExtra(EXTRA_MESSAGE));
	}

}
