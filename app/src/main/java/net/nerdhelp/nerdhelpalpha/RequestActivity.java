package net.nerdhelp.nerdhelpalpha;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.provider.Settings.Secure;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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

        writeToFirebase(name, emailAddress, phoneNumber, streetAddress, problemDescription);
    }

    public void writeToFirebase(String name, String email, String phone, String add, String prbdesc) {
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("inquiries");
        myRef.child("newInquiryFrom  " + name).child("name").setValue(name);
        myRef.child("newInquiryFrom  " + name).child("email").setValue(email);
        myRef.child("newInquiryFrom  " + name).child("phone").setValue(phone);
        myRef.child("newInquiryFrom  " + name).child("address").setValue(add);
        myRef.child("newInquiryFrom  " + name).child("problem desc").setValue(prbdesc);

        //display submittal message
        Context context = getApplicationContext();
        CharSequence text = "Your inquiry has been submitted! NerdHelp will be contacting you soon!";
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        Intent intent = new Intent(RequestActivity.this, NaviActivity.class);
        startActivity(intent);
    }
}
