package com.example.hoangnv.empublite;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by hoangnv on 10/11/2014.
 */
public class ContentsAdapter extends FragmentStatePagerAdapter{
    public ContentsAdapter(FragmentActivity ctxt) {
        super(ctxt.getSupportFragmentManager());
    }

    @Override
    public Fragment getItem(int i) {
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }
}
