package com.example.hoangnv.empublite;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class EmPubLiteActivity extends FragmentActivity {
    private ViewPager pager;
    private PagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        pager = (ViewPager)findViewById(R.id.pager);
        adapter = new ContentsAdapter(this);
        pager.setAdapter(adapter);
        pager.setVisibility(View.VISIBLE);

        findViewById(R.id.progressBar1).setVisibility(View.GONE);

        getActionBar().setHomeButtonEnabled(true);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.options, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                return true;
            case R.id.about:
                Intent i = new Intent(this, SimpleContentActivity.class);
                startActivity(i);
                return true;
            case R.id.help:
                i = new Intent(this, SimpleContentActivity.class);
                startActivity(i);
                return true;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
