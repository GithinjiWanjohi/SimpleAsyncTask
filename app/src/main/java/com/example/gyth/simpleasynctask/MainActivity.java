package com.example.gyth.simpleasynctask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // String to store the state of the TextView
    private static final String TEXT_STATE = "currentText";

    private TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.textView1);

        // Restore text view if there is a savedInstanceState
        if(savedInstanceState != null){
            mTextView.setText(savedInstanceState.getString(TEXT_STATE));
        }
    }

    public void startTask(View view) {
        // Add message to the texview
        mTextView.setText("Napping...");

        // Start the AsyncTask
        // AsyncTask has a callback that will update the textview
        new SimpleAsyncTask(mTextView).execute();
    }

    /*
    * Saves the contents of the TextView on configuration change
    * @param outside the bundle in which the state of the activity is saved when it is spontaneously destroyed
    * */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save the state of the TextView
        outState.putString(TEXT_STATE, mTextView.getText().toString());
    }
}
