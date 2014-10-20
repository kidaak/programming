package com.example.hoangnv.actionbar;

import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by hoangnv on 10/9/2014.
 */
public class ActionBarFragment extends ListFragment implements TextView.OnEditorActionListener{
    private static final String[] items= { "lorem", "ipsum", "dolor",
            "sit", "amet", "consectetuer", "adipiscing", "elit", "morbi",
            "vel", "ligula", "vitae", "arcu", "aliquet", "mollis", "etiam",
            "vel", "erat", "placerat", "ante", "porttitor", "sodales",
            "pellentesque", "augue", "purus" };
    private ArrayList<String> words=null;
    private ArrayAdapter<String> adapter=null;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setRetainInstance(true);
        setHasOptionsMenu(true);


    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.actions, menu);

        configureActionItem(menu);

        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.reset) {
            initAdapter();
            return(true);
        }

        return(super.onOptionsItemSelected(item));
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (event == null || event.getAction() == KeyEvent.ACTION_UP) {
            adapter.add(v.getText().toString());
            v.setText("");

            InputMethodManager imm=
                    (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);

            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
        }

        return(true);
    }

    private void configureActionItem(Menu menu) {
        EditText add=
                (EditText)menu.findItem(R.id.add).getActionView()
                        .findViewById(R.id.title);

        add.setOnEditorActionListener(this);
    }

    private void initAdapter() {
        words=new ArrayList<String>();

        for (String s : items) {
            words.add(s);
        }

        adapter=
                new ArrayAdapter<String>(getActivity(),
                        android.R.layout.simple_list_item_1,
                        words);

        setListAdapter(adapter);
    }
}
