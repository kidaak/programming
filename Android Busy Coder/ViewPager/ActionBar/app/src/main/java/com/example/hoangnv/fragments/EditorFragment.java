package com.example.hoangnv.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * Created by hoangnv on 10/11/2014.
 */
public class EditorFragment extends Fragment {
    private static final String KEY_POSITION = "position";

    static EditorFragment newInstance(int position){
        EditorFragment frag = new EditorFragment();
        Bundle args = new Bundle();
        args.putInt(KEY_POSITION, position);
        frag.setArguments(args);
        return frag;
    }

    static String getTitle(Context ctxt, int position){
        return (String.format(ctxt.getString(R.string.hint), position + 1));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View result = inflater.inflate(R.layout.editor, container, false);
        EditText editor = (EditText) result.findViewById(R.id.editor);
        int position = getArguments().getInt(KEY_POSITION);
        editor.setHint(getTitle(getActivity(), position));

        if(position % 2 == 0){
            setHasOptionsMenu(true);
        }
        return result;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.actions, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }
}
