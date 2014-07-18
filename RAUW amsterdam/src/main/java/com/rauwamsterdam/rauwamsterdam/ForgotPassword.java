package com.rauwamsterdam.rauwamsterdam;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ForgotPassword extends Activity implements View.OnClickListener {

    private EditText email;
    private Button mRetrieve;

    // Progress Dialog
    private ProgressDialog pDialog;

    // JSON parser class
    JSONParser jsonParser = new JSONParser();

    //php login script location:
    private static final String LOGIN_URL = "http://www.rauwamsterdam.com/rauwdatabase/forgotpassword.php";

    //JSON element ids from response of php script:
    private static final String TAG_SUCCESS = "success";
    private static final String TAG_MESSAGE = "message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.password_forgot);

        //setup input fields
        email = (EditText) findViewById(R.id.fieldForgotEmail);

        //setup buttons
        mRetrieve = (Button) findViewById(R.id.buttonPassword);

        //register listeners
        mRetrieve.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // determine which button was pressed:
        switch (v.getId()) {
            case R.id.buttonPassword:
                new RetrievePassword().execute();
                break;


            default:
                break;
        }
    }

    //AsyncTask is a separate thread than the thread that runs the GUI
    //Any type of networking should be done with asynctask.
    class RetrievePassword extends AsyncTask<String, String, String> {
        /**
         * Before starting background thread Show Progress Dialog
         */
        boolean failure = false;

        //three methods get called, first onPreExecute, then doInBackground, and once
        //doInBackground is completed, the onPostExecute method will be called.

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(ForgotPassword.this);
            pDialog.setMessage("Sending password...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }

        @Override
        protected String doInBackground(String... args) {
            // TODO Auto-generated method stub
            // Check for success tag
            int success;
            String emailadres = email.getText().toString();
            try {
                // Building Parameters
                List<NameValuePair> params = new ArrayList<NameValuePair>();
                params.add(new BasicNameValuePair("emailadres", emailadres));

                Log.d("request!", "starting");
                // getting product details by making HTTP request
                JSONObject json = jsonParser.makeHttpRequest(
                        LOGIN_URL, "POST", params);

                // check your log for json response
                Log.d("Login attempt", json.toString());

                // json success tag
                success = json.getInt(TAG_SUCCESS);
                if (success == 1) {
                    Log.d("Wachtwoord verzonden!", json.toString());
                    Intent i = new Intent(ForgotPassword.this, Login.class);
                    finish();
                    startActivity(i);
                    return json.getString(TAG_MESSAGE);
                } else {
                    Log.d("Wachtwoord niet verzonden!", json.getString(TAG_MESSAGE));
                    return json.getString(TAG_MESSAGE);

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        protected void onPostExecute(String file_url) {
            // dismiss the dialog once product deleted
            pDialog.dismiss();
            if (file_url != null) {
                Toast.makeText(ForgotPassword.this, file_url, Toast.LENGTH_LONG).show();
            }

        }
    }

    public void clickBackLogin(View view)
    {
        Intent intent = new Intent(ForgotPassword.this, Login.class);
        startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    //double tap 'back-button' to quit app
    private boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onResume() {
        super.onResume();
        // .... other stuff in my onResume ....
        this.doubleBackToExitPressedOnce = false;
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }
        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, R.string.exit_press_back_twice_message, Toast.LENGTH_SHORT).show();
    }
}