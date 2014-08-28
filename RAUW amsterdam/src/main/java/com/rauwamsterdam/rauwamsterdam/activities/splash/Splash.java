package com.rauwamsterdam.rauwamsterdam.activities.splash;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.rauwamsterdam.rauwamsterdam.R;

public class Splash extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        Thread timer = new Thread(){
            public void run(){
                try{
                    sleep(1000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                } finally {
                    Intent openLogin = new Intent("com.rauwamsterdam.rauwamsterdam.activities.login.LOGIN");
                    startActivity(openLogin);
                }
            }
        };
        timer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

}
