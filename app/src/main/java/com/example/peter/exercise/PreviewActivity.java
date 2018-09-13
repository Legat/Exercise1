package com.example.peter.exercise;

import android.content.Intent;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.peter.exercise.Models.Message;


public class PreviewActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText greatText;
    private Button emailButton;
    private Message shortmessage;
    public static final String PREVIEW_CODE = "greeting.message";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);
        greatText = findViewById(R.id.greeting_edit);
        emailButton = findViewById(R.id.prev_but);

        emailButton.setOnClickListener(this);
    }

    private Message getShortMsg(){
        if(getFillMsg(greatText)){

            shortmessage = new Message(greatText.getText().toString());
            return shortmessage;
        }else {

            return null;
        }
    }

    private boolean getFillMsg(EditText editMsg){
        if(editMsg.getText().toString().length() >0)
            return true;
        else
            Toast.makeText(this,getString(R.string.emptymsg),Toast.LENGTH_SHORT).show();
        return false;
    }
    private Intent getIntent(Message mes){
        Intent intent = new Intent(this,EmailActivity.class);
        intent.putExtra(PREVIEW_CODE, mes);
        return intent;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.prev_but) {
            if (getFillMsg(greatText)) {
                getShortMsg();
                Intent intent = getIntent(shortmessage);
                startActivity(intent);
            }
        }
    }
}