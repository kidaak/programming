package com.example.actionbardemonative;

import java.util.ArrayList;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends ListActivity implements
		TextView.OnEditorActionListener {
	private static final String[] items = { "lorem", "ipsum", "dolor", "sit",
			"amet", "consectetuer", "adipiscing", "elit", "morbi", "vel",
			"ligula", "vitae", "arcu", "aliquet", "mollis", "etiam", "vel",
			"erat", "placerat", "ante", "porttitor", "sodales", "pellentesque",
			"augue", "purus" };
	private ArrayList<String> words = null;
	private ArrayAdapter<String> adapter = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initAdapter();
		getActionBar().setHomeButtonEnabled(true);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		configureActionItem(menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		switch (id) {
		case R.id.reset:
			initAdapter();
			return true;
		case R.id.home:

			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
		// TODO Auto-generated method stub
		if (event == null || event.getAction() == KeyEvent.ACTION_UP) {
			adapter.add(v.getText().toString());
			v.setText("");

			InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
			imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
		}
		return true;
	}

	private void configureActionItem(Menu menu) {
		EditText add = (EditText) menu.findItem(R.id.add).getActionView()
				.findViewById(R.id.title);
		add.setOnEditorActionListener(this);
	}

	private void initAdapter() {
		words = new ArrayList<String>();
		for (String s : items) {
			words.add(s);
		}

		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, words);

		setListAdapter(adapter);
	}
}
