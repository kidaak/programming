package com.example.hoangnv.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by hoangnv on 10/6/2014.
 */
public class ContentFragment extends Fragment implements View.OnClickListener{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View result = inflater.inflate(R.layout.mainfrag, container, false);
        result.findViewById(R.id.showOther).setOnClickListener(this);
        return result;
    }

    @Override
    public void onClick(View view) {
        ((StaticDemoActivity)getActivity()).showOther(view);
    }
}
