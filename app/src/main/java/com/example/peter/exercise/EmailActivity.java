package com.example.peter.exercise;

import android.content.Intent;
import android.net.Uri;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.peter.exercise.Models.Message;

public class EmailActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView wishTxt;
    private Button emailbutton;
    private Message message; // message
    public static final String PREVIEW_CODE = "greeting.message";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
        wishTxt = findViewById(R.id.wish_txt);
        emailbutton = findViewById(R.id.email_txt);


        getMsg();

        wishTxt.setText(message.getMessage());

        emailbutton.setOnClickListener(this);
    }


    private Message getMsg(){
        message = (Message) getIntent().getSerializableExtra(PREVIEW_CODE);
        return message;
    }

    private void initMsg(Message message){
        String subject = getString(R.string.subject);
        String academymail = getString(R.string.acdemymail);

        message.setSubject(subject);
        message.setMail(academymail);

    }



    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.email_txt) {

            sendEmail(message);
        }

    }

    private void sendEmail(Message message){
        initMsg(message);
        Intent intent = getMailInten(message);

        try {
            startActivity(intent);
        }catch (android.content.ActivityNotFoundException ex){
            Toast.makeText(this, getString(R.string.emailNotfound),Toast.LENGTH_LONG).show();
        }

    }

    private Intent getMailInten(Message message){
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, message.getSubject());
        intent.putExtra(Intent.EXTRA_TEXT, message.getMessage());
        intent.setData(Uri.parse("mailto:" + message.getMail())); // or just "mailto:" for blank
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // this will make such that when user returns to your app, your app is displayed, instead of the email app.
        return intent;
    }
}