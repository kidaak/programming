package com.example.hoangnv.empublite;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by hoangnv on 10/26/2014.
 */
public class ModelFragment extends Fragment {
    private BookContents contents;
    private ContentsLoadTask contentsTask;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setRetainInstance(true);
        deliverModel();
    }

    synchronized private void deliverModel(){
        if(contents != null){
            ((EmPubLiteActivity)getActivity()).setupPager(contents);
        }else{
            if(contents == null && contentsTask == null){
                contentsTask = new ContentsLoadTask();
                executeAsyncTask(contentsTask, getActivity().getApplicationContext());
            }
        }
    }

    @TargetApi(11)
    static public <T> void executeAsyncTask(AsyncTask<T, ?, ?> task, T... params){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB){
            task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, params);
        }else{
            task.execute(params);
        }
    }

    private class ContentsLoadTask extends AsyncTask<Context, Void, Void>{
        private BookContents localContents = null;
        private Exception e = null;

        @Override
        protected Void doInBackground(Context... contexts) {
            try{
                StringBuilder buf = new StringBuilder();
                InputStream json = contexts[0].getAssets().open("book/contents.json");
                BufferedReader in = new BufferedReader(new InputStreamReader(json));
                String str;
                while((str = in.readLine()) != null){
                    buf.append(str);
                }

                in.close();
                localContents = new BookContents(new JSONObject(buf.toString()));
            } catch (JSONException e1) {
                e1.printStackTrace();
                this.e = e1;
            } catch (IOException e1) {
                e1.printStackTrace();
                this.e = e1;
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            if(e == null){
                ModelFragment.this.contents = localContents;
                ModelFragment.this.contentsTask = null;
                deliverModel();
            }else{
                Log.e(getClass().getSimpleName(), "Exception loading contents", e);
            }
        }
    }
}
