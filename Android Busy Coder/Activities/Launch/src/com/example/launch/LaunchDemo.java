package com.example.launch;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;

public class LaunchDemo extends ActionBarActivity {
	private EditText lat, lon;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		lat = (EditText) findViewById(R.id.lat);
		lon = (EditText) findViewById(R.id.lon);
	}

	public void showMe(View v) {
		String _lat = lat.getText().toString();
		String _lon = lon.getText().toString();
		Uri uri = Uri.parse("geo:" + _lat + "," + _lon);

		startActivity(new Intent(Intent.ACTION_VIEW, uri));
	}
}
