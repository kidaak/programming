package com.bkstorm.contentprovider;

import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class ContactsAcitivity extends Activity {
    /**
     * Called when the activity is first created.
     */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        TextView contactView = (TextView) findViewById(R.id.contactview);

        Cursor cursor = getContacts();

        while (cursor.moveToNext()) {
            String displayName = cursor.getString(cursor
                    .getColumnIndex(ContactsContract.Data.DISPLAY_NAME));
            contactView.append("Name: ");
            contactView.append(displayName);
            contactView.append("\n");
        }
    }

    private Cursor getContacts() {
        // Run query
        Uri uri = ContactsContract.Contacts.CONTENT_URI;
        String[] projection = new String[]{ContactsContract.Contacts._ID,
                ContactsContract.Contacts.DISPLAY_NAME};
        String selection = ContactsContract.Contacts.IN_VISIBLE_GROUP + " = '"
                + ("1") + "'";
        String[] selectionArgs = null;
        String sortOrder = ContactsContract.Contacts.DISPLAY_NAME
                + " COLLATE LOCALIZED ASC";

        return getContentResolver().query(uri, projection, selection, selectionArgs,
                sortOrder);
    }
}
