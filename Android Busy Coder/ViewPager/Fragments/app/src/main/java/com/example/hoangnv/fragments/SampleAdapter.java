package com.example.hoangnv.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by hoangnv on 10/9/2014.
 */
public class SampleAdapter extends FragmentPagerAdapter {

    public SampleAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return EditorFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return 10;
    }
}
