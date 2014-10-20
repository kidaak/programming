package com.example.hoangnv.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by hoangnv on 10/11/2014.
 */
public class PagerFragment extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View result = inflater.inflate(R.layout.pager, container, false);
        ViewPager pager = (ViewPager)result.findViewById(R.id.pager);
        pager.setAdapter(buildAdapter());
        return result;
    }

    private PagerAdapter buildAdapter(){
        return (new SampleAdapter(getActivity(), getChildFragmentManager()));
    }
}
