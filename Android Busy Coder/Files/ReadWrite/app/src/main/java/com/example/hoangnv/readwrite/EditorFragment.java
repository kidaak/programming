package com.example.hoangnv.readwrite;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Created by hoangnv on 10/24/2014.
 */
public class EditorFragment extends Fragment {
    private static final String FILENAME = "notes.txt";
    private CheckBox external = null;
    private EditText editor = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View result = inflater.inflate(R.layout.editor, container, false);
        editor = (EditText)result.findViewById(R.id.editor);
        return result;
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.actions, menu);
        external = (CheckBox)menu.findItem(R.id.location).getActionView();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    private File getTarget(){
        File root = null;

        if(external != null && external.isChecked()){
            root = getActivity().getExternalFilesDir(null);
        }else{
            root = getActivity().getFilesDir();
        }
        return new File(root, FILENAME);
    }

    private String load(File target) throws IOException{
        String result = "";

        try{
            InputStream in = new FileInputStream(target);

            if(in != null){
                try{
                    InputStreamReader tmp = new InputStreamReader(in);
                    BufferedReader reader = new BufferedReader(tmp);
                    String str;
                    StringBuilder buf = new StringBuilder();
                    while ((str = reader.readLine()) != null){
                        buf.append(str);
                        buf.append("\n");
                    }
                    result = buf.toString();
                }finally {
                    in.close();
                }
            }
        }catch(FileNotFoundException e){
            //that's OK, we probably haven't created it yet
        }
        return result;
    }

    private void save(String text, File target) throws IOException {
        FileOutputStream fos = new FileOutputStream(target);
        OutputStreamWriter out = new OutputStreamWriter(fos);

        out.write(text);
        out.flush();
        fos.getFD().sync();
        out.close();
    }
}
