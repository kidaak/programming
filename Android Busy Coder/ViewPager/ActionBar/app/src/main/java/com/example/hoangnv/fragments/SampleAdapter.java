package com.example.hoangnv.fragments;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by hoangnv on 10/9/2014.
 */
public class SampleAdapter extends FragmentPagerAdapter {
    Context ctxt = null;

    public SampleAdapter(Context ctxt, FragmentManager fm) {
        super(fm);
        this.ctxt = ctxt;
    }

    @Override
    public Fragment getItem(int position) {
        return EditorFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return (EditorFragment.getTitle(ctxt, position));
    }
}
