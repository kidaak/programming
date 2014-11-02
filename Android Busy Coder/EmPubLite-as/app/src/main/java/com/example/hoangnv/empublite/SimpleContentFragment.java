package com.example.hoangnv.empublite;

import android.os.Bundle;

/**
 * Created by hoangnv on 10/26/2014.
 */
public class SimpleContentFragment extends AbstractContentFragment {
    private static final String KEY_FILE="file";

    protected static SimpleContentFragment newInstance(String file){
        SimpleContentFragment f = new SimpleContentFragment();

        Bundle args = new Bundle();
        args.putString(KEY_FILE, file);
        f.setArguments(args);

        return f;
    }

    @Override
    String getPage() {
        return getArguments().getString(KEY_FILE);
    }
}
