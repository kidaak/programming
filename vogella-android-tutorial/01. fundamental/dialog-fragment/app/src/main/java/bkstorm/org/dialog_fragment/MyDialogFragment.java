package bkstorm.org.dialog_fragment;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Nguyen on 8/15/2015.
 */
public class MyDialogFragment extends DialogFragment implements TextView.OnEditorActionListener {

    private EditText editText;

    public interface UserNameListener {
        void onFinishUserDialog(String user);
    }

    // Empty constructor required for DialogFragment
    public MyDialogFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_username, container);
        editText = (EditText) view.findViewById(R.id.username);
        editText.setOnEditorActionListener(this);
        editText.requestFocus();
        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        getDialog().setTitle("Please enter username");
        return view;
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        UserNameListener activity = (UserNameListener) getActivity();
        activity.onFinishUserDialog(editText.getText().toString());
        this.dismiss();
        return true;
    }
}
