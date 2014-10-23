package com.example.hoangnv.fragmentbundle;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by hoangnv on 10/20/2014.
 */
public class RotationFragment extends Fragment implements View.OnClickListener{
    static final int PICK_REQUEST = 1337;
    Uri contact = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View result = inflater.inflate(R.layout.main, container, false);
        result.findViewById(R.id.pick).setOnClickListener(this);
        View v = result.findViewById(R.id.view);
        v.setOnClickListener(this);
        if(savedInstanceState != null){
            contact = (Uri)savedInstanceState.getParcelable("contact");
        }
        v.setEnabled(contact != null);
        return result;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if(contact != null){
            outState.putString("contact", contact.toString());
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PICK_REQUEST) {
            if (resultCode == Activity.RESULT_OK) {
                contact=data.getData();
                getView().findViewById(R.id.view).setEnabled(true);
            }
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.pick) {
            pickContact(view);
        }
        else {
            viewContact(view);
        }
    }

    public void pickContact(View v) {
        Intent i=
                new Intent(Intent.ACTION_PICK,
                        ContactsContract.Contacts.CONTENT_URI);

        startActivityForResult(i, PICK_REQUEST);
    }

    public void viewContact(View v) {
        startActivity(new Intent(Intent.ACTION_VIEW, contact));
    }
}
