package com.example.hoangnv.asynctask;

import android.app.ListFragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by hoangnv on 10/21/2014.
 */
public class AsyncDemoFragment extends ListFragment {
    private static final String[] items= { "lorem", "ipsum", "dolor",
            "sit", "amet", "consectetuer", "adipiscing", "elit", "morbi",
            "vel", "ligula", "vitae", "arcu", "aliquet", "mollis", "etiam",
            "vel", "erat", "placerat", "ante", "porttitor", "sodales",
            "pellentesque", "augue", "purus" };
    private ArrayList<String> model = null;
    private ArrayAdapter<String> adapter = null;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setRetainInstance(true);

        if(model == null){
            model = new ArrayList<String>();
            new AddStringTask().execute();
        }
        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, model);
        getListView().setScrollbarFadingEnabled(false);
        setListAdapter(adapter);
    }

    class AddStringTask extends AsyncTask<Void, String, Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            for(String item : items){
                publishProgress(item);
                SystemClock.sleep(400);
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void unused) {
            Toast.makeText(getActivity(), R.string.done, Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onProgressUpdate(String... values) {
            adapter.add(values[0]);
        }
    }
}
