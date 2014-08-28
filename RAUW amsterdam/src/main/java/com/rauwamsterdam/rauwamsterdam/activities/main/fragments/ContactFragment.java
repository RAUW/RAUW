package com.rauwamsterdam.rauwamsterdam;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import static com.rauwamsterdam.rauwamsterdam.R.id.buttonContactMail;

public class ContactFragment extends Fragment {

    Button button1, button2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_contact, container, false);

        button1 = (Button) rootView.findViewById(buttonContactMail);
        button1.setOnClickListener(imgButtonHandler);

        button2 = (Button) rootView.findViewById(R.id.buttonContactPhone);
        button2.setOnClickListener(imgButtonHandler);

        return rootView;
    }

    protected View.OnClickListener imgButtonHandler = new View.OnClickListener() {

        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.buttonContactMail:

                    Intent emailIntent = new Intent(Intent.ACTION_SEND);

                    //We can get To,CC,BCC,Subject,Body information from user by using EditText
                    emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"info@rauwamsterdam.com"});
                    //emailIntent.putExtra(Intent.EXTRA_CC, new String[]{"lmn@xyz.com"});
                    //emailIntent.putExtra(Intent.EXTRA_BCC, new String[]{"lmn@xyz.com"});
                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, "");
                    emailIntent.putExtra(Intent.EXTRA_TEXT, "");

                    emailIntent.setType("message/rfc822");
                    startActivity(Intent.createChooser(emailIntent, "Mail RAUW met:"));
                    break;
                case R.id.buttonContactPhone:

                    Intent dial = new Intent();
                    dial.setAction("android.intent.action.DIAL");
                    dial.setData(Uri.parse("tel:0612409537"));
                    startActivity(dial);
                    break;
                default:
                    break;

            }
        }
    };
}
















