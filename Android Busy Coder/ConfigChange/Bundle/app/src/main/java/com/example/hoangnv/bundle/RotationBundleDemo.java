package com.example.hoangnv.bundle;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;


public class RotationBundleDemo extends Activity implements View.OnClickListener{
    static final int PICK_REQUEST = 1337;
    Uri contact = null;

    Button viewButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        findViewById(R.id.pick).setOnClickListener(this);
        viewButton = (Button)findViewById(R.id.view);
        viewButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.pick){
            pickContact(view);
        }else{
            viewContact(view);
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if(contact != null){
            savedInstanceState.putString("contact", contact.toString());
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String contactUri = outState.getString("contact");

        if(contactUri != null){
            contact = Uri.parse(contactUri);
            viewButton.setEnabled(contact != null);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == PICK_REQUEST){
            if(resultCode == Activity.RESULT_OK){
                contact = data.getData();
                viewButton.findViewById(R.id.view).setEnabled(true);
            }
        }
    }

    public void pickContact(View v){
        Intent i = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
        startActivityForResult(i, PICK_REQUEST);
    }

    public void viewContact(View v){
        startActivity(new Intent(Intent.ACTION_VIEW, contact));
    }
}
