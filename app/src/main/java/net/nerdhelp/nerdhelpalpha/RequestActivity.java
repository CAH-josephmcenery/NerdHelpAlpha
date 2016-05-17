package net.nerdhelp.nerdhelpalpha;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class RequestActivity extends AppCompatActivity {
    String[] joeysEmail = {"joey.mcenery@gmail.com"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);
    }
public void onSubmit(View view){
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

    String emailBody = (""+ name+"\n"+emailAddress+"\n"+phoneNumber+"\n"+streetAddress+"\n"+problemDescription);
    createEmail(joeysEmail, "NerdHelp request via android app", emailBody);
}
    public void createEmail(String[] addresses, String subject, String body){

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, body);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
