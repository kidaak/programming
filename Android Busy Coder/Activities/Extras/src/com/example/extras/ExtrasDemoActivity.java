package com.example.extras;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

public class ExtrasDemoActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}

	public void showOther(View v) {
		Intent other = new Intent(this, OtherActivity.class);
		other.putExtra(OtherActivity.EXTRA_MESSAGE, getString(R.string.other));
		startActivity(other);
	}
}
