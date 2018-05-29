package com.example.gyth.simpleasynctask;

import android.os.AsyncTask;
import android.widget.TextView;

import java.util.Random;

public class SimpleAsyncTask extends AsyncTask <Void, Void, String> {

    private final TextView mTextView;

    public SimpleAsyncTask(TextView tv){
        mTextView = tv;
    }

    @Override
    protected String doInBackground(Void... voids) {
        // Generate a random number between 0 and 10
        Random r = new Random();
        int n = r.nextInt(11);

        // Make the task take long enough that we have
        // enough time to rotate the phone while it is running
        int s = n * 200;

        // Sleep for a random amount of time
        try{
            Thread.sleep(s);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        // Return a string result
        return "Awake at last after sleeping for" + s + "milliseconds";
    }

    protected void  onPostExecute(String result){
        mTextView.setText(result);
    }
}
