package com.example.hoangnv.fragmentsbc;

import android.app.Fragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by hoangnv on 10/26/2014.
 */
public class PreferenceContentsFragment extends Fragment {
    private TextView checkbox;
    private TextView ringtone;
    private TextView checkbox2;
    private TextView text;
    private TextView list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View result = inflater.inflate(R.layout.content, container, false);

        checkbox = (TextView)result.findViewById(R.id.checkbox);
        ringtone = (TextView)result.findViewById(R.id.ringtone);
        checkbox2 = (TextView)result.findViewById(R.id.checkbox2);
        text = (TextView)result.findViewById(R.id.text);
        list = (TextView)result.findViewById(R.id.list);

        return result;
    }

    @Override
    public void onResume() {
        super.onResume();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
    }
}
