package com.example.lauren.firstandroidapp;

/**
 * Created by lauren on 04/10/2016.
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OnTouch extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_touch);
        final Button btnOnTouch = (Button) findViewById(R.id.btnOnTouch);
        btnOnTouch.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v){
                Intent i = new Intent(OnTouch.this,MainActivity.class);
                startActivity(i);
            }

        });}

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(OnTouch.this, LogIn.class);
        startActivity(intent);
    }}
