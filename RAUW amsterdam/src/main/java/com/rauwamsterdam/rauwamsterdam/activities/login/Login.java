package com.rauwamsterdam.rauwamsterdam.activities.login;

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

import com.rauwamsterdam.rauwamsterdam.activities.main.MainActivity;
import com.rauwamsterdam.rauwamsterdam.activities.register.Register;
import com.rauwamsterdam.rauwamsterdam.activities.forgotpassword.ForgotPassword;
import com.rauwamsterdam.rauwamsterdam.utils.JSONParser;
import com.rauwamsterdam.rauwamsterdam.R;
import com.rauwamsterdam.rauwamsterdam.data.DataManager;
import com.rauwamsterdam.rauwamsterdam.services.AbstractCallback;
import com.rauwamsterdam.rauwamsterdam.services.DataResult;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Login extends Activity implements View.OnClickListener
{
	private static final String _TAG = "LoginActivity";

	//php login script location:
    private static final String LOGIN_URL = "http://www.rauwamsterdam.com/php-login-advanced-2/index.php";

	//JSON element ids from response of php script:
	private static final String TAG_SUCCESS = "success";
	private static final String TAG_MESSAGE = "message";

    private EditText email, pass;
    private Button mSubmit, mRegister;

    // Progress Dialog
    private ProgressDialog pDialog;

    // JSON parser class
    private JSONParser jsonParser = new JSONParser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        //setup input fields
        email = (EditText) findViewById(R.id.fieldEmail);
        pass = (EditText) findViewById(R.id.fieldPassword);

        //setup buttons
        mSubmit = (Button) findViewById(R.id.buttonLogin);
        mRegister = (Button) findViewById(R.id.buttonRegister);

        //register listeners
        mSubmit.setOnClickListener(this);
        mRegister.setOnClickListener(this);

    }

    @Override
    public void onClick(View v)
	{
		Log.d(_TAG, "onClick" + v.getId());

        // determine which button was pressed:
        switch (v.getId()) {
            case R.id.buttonLogin:
				String emailValue = email.getText().toString();
				String passValue = pass.getText().toString();
				//TODO: Add Validation before we sent it to the backend!

                //new AttemptLogin().execute();
				Log.d(_TAG, "email: " + emailValue + ", password: " + passValue);
				DataManager.getInstance().getWebservice().login(new LoginCallback(), emailValue, passValue);
                break;
            case R.id.buttonRegister:
                Intent i = new Intent(this, Register.class);
                startActivity(i);
                break;
            default:
                break;
        }
    }

	private void gotoMain()
	{
		Intent i = new Intent(Login.this, MainActivity.class);
		finish();
		startActivity(i);
	}

	class LoginCallback extends AbstractCallback
	{
		public void onResult(DataResult result)
		{
			Log.d(_TAG, "Login result: " + result.getMessage());
			//TODO: Check how we can fix this so the getter will always return a typed instance
			JSONObject data = (JSONObject) result.getData();

			try
			{
				Boolean success = data.getBoolean("success");
				if (success)
				{
					DataManager.getInstance().getUserModel().addUser(data.getJSONObject("user"));

					gotoMain();
				}
			}
			catch (Exception error)
			{
				Log.e("Something went wrong parsing! ", _TAG);
				error.printStackTrace();
			}
		}
	}



    //AsyncTask is a separate thread than the thread that runs the GUI
    //Any type of networking should be done with asynctask.
    class AttemptLogin extends AsyncTask<String, String, String> {
        /**
         * Before starting background thread Show Progress Dialog
         */
        boolean failure = false;

        //three methods get called, first onPreExecute, then doInBackground, and once
        //doInBackground is completed, the onPostExecute method will be called.

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(Login.this);
            pDialog.setMessage("Attempting login...");
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
            String password = pass.getText().toString();
            try {
                // Building Parameters
                List<NameValuePair> params = new ArrayList<NameValuePair>();
                params.add(new BasicNameValuePair("emailadres", emailadres));
                params.add(new BasicNameValuePair("password", password));

                Log.d("request!", "starting");
                // getting product details by making HTTP request
                JSONObject json = jsonParser.makeHttpRequest(
                        LOGIN_URL, "POST", params);

                // check your log for json response
                Log.d("Login attempt", json.toString());

                // json success tag
                success = json.getInt(TAG_SUCCESS);
                if (success == 1) {
                    Log.d("Login Successful!", json.toString());
                    Intent i = new Intent(Login.this, MainActivity.class);
                    finish();
                    startActivity(i);
                    return json.getString(TAG_MESSAGE);
                } else {
                    Log.d("Login Failure!", json.getString(TAG_MESSAGE));
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
                Toast.makeText(Login.this, file_url, Toast.LENGTH_LONG).show();
            }

        }


    }

    public void clickPassword(View view)
    {
        Intent intent = new Intent(Login.this, ForgotPassword.class);
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



