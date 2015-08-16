package bkstorm.org.intent_explicit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Nguyen on 8/9/2015.
 */
public class ResultActivity extends Activity {

    private TextView tbxInput;
    private EditText edtOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        loadUI();
    }

    private void loadUI(){
        tbxInput = (TextView) findViewById(R.id.displayintentextra);
        String value = (String) getIntent().getExtras().get("input");
        tbxInput.setText(value);

        edtOutput = (EditText) findViewById(R.id.returnValue);
    }

    @Override
    public void finish() {
        Intent intent = new Intent();
        intent.putExtra("result", edtOutput.getText().toString());
        setResult(RESULT_OK, intent);

        super.finish();
    }
}
