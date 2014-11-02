package com.example.hoangnv.empublite;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by hoangnv on 10/11/2014.
 */
public class ContentsAdapter extends FragmentStatePagerAdapter {
    private BookContents contents = null;

    public ContentsAdapter(FragmentActivity ctxt, BookContents contents) {
        super(ctxt.getSupportFragmentManager());
        this.contents = contents;
    }

    @Override
    public Fragment getItem(int position) {
        String path = contents.getChapterFile(position);
        return SimpleContentFragment.newInstance("file:///android_asset/book/" + path);
    }

    @Override
    public int getCount() {
        return contents.getChapterCount();
    }
}
