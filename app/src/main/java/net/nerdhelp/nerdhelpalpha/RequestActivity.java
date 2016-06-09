package net.nerdhelp.nerdhelpalpha;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.creativityapps.gmailbackgroundlibrary.BackgroundMail;

public class RequestActivity extends AppCompatActivity {
    String[] joeysEmail = {"joey.mcenery@gmail.com"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);
    }


    public void onSubmit(View view) {
        EditText nameF = (EditText) findViewById(R.id.name);
        String name = nameF.getText().toString();

        EditText emailAddressF = (EditText) findViewById(R.id.email_address);
        String emailAddress = emailAddressF.getText().toString();

        EditText phoneNumberF = (EditText) findViewById(R.id.phone_number);
        String phoneNumber = phoneNumberF.getText().toString();

        EditText streetAddressF = (EditText) findViewById(R.id.street_address);
        String streetAddress = streetAddressF.getText().toString();

        EditText problemDescriptionF = (EditText) findViewById(R.id.problem_description);
        String problemDescription = problemDescriptionF.getText().toString();

        EditText prefTimesF = (EditText) findViewById(R.id.pref_times);
        String prefTimes = prefTimesF.getText().toString();

        String emailBody = ("" + name + "\n" + emailAddress + "\n" + phoneNumber + "\n" + streetAddress + "\n" + problemDescription + "\n" + prefTimes);
        createEmail(emailBody);
    }

    public void createEmail(String body) {

        BackgroundMail.newBuilder(this)
                .withUsername("nerdhelpapp@gmail.com")
                .withPassword("mceneryandroid")
                .withMailto("joey.mcenery@gmail.com")
                .withSubject("NerdHelp Inquiry from app")
                .withBody(body)
                .withOnSuccessCallback(new BackgroundMail.OnSuccessCallback() {
                    @Override
                    public void onSuccess() {
                        Context context = getApplicationContext();
                        CharSequence text = "Your request has been submitted. We will contact you soon!";
                        int duration = Toast.LENGTH_LONG;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    }
                })
                .withOnFailCallback(new BackgroundMail.OnFailCallback() {
                    @Override
                    public void onFail() {
                        //do some magic
                    }
                })
                .send();

        Context context = getApplicationContext();
        CharSequence text = "Your request has been submitted. We will contact you soon!";
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        Intent intent = new Intent(RequestActivity.this, NaviActivity.class);
        startActivity(intent);
    }
}
