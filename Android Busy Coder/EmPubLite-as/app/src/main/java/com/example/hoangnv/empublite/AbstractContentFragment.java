package com.example.hoangnv.empublite;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by hoangnv on 10/9/2014.
 */
abstract public class AbstractContentFragment extends WebViewFragment {

    abstract String getPage();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View result = super.onCreateView(inflater, container, savedInstanceState);
        getWebView().getSettings().setJavaScriptEnabled(true);
        getWebView().getSettings().setSupportZoom(true);
        getWebView().getSettings().setBuiltInZoomControls(true);
        getWebView().loadUrl(getPage());
        return result;
    }
}
