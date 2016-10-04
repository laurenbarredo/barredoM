package com.example.lauren.firstandroidapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        final EditText userName = (EditText) findViewById(R.id.username);
        final EditText password = (EditText) findViewById(R.id.password);
        final Button btnSignUp = (Button) findViewById(R.id.btnSignUp);
        final Button btnLogIn = (Button) findViewById(R.id.btnLogIn);
        final Button btnShow = (Button) findViewById(R.id.btnShow);
        final DatabaseAdapter sqlDB = new DatabaseAdapter(getApplicationContext());
        final Context context = this;

        btnLogIn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (userName.equals("") || password.equals("")) {
                    Toast.makeText(getApplicationContext(), "Fill up required fields", Toast.LENGTH_LONG).show();
                    return;
                }
                if (!validateEmail(userName.getText().toString())) {
                    userName.setError("Invalid username/email!");

                }
                if (!validatePassword(password.getText().toString())) {
                    password.setError("Invalid password!");
                } else {
                    userName.setError(null);
                    password.setError(null);
                    doLogin();

                }
            }
        });
        btnShow.setOnTouchListener(new View.OnTouchListener() {
            @Override

            public boolean onTouch(View view, MotionEvent motionEvent) {

                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        password.setTransformationMethod(null);
                        password.setSelection(password.getText().length());
                        return true;
                    }
                    case MotionEvent.ACTION_UP: {
                        password.setTransformationMethod(new PasswordTransformationMethod());
                        password.setSelection(password.getText().length());
                        return true;
                    }
                }
                return false;
            }

        });
        btnLogIn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (userName.equals("") || password.equals("")) {
                    Toast.makeText(getApplicationContext(), "Fill up required fields", Toast.LENGTH_LONG).show();
                    return;
                }
                if (!validateEmail(userName.getText().toString())) {
                    userName.setError("Invalid username/email!");

                }
                if (!validatePassword(password.getText().toString())) {
                    password.setError("Invalid password!");
                } else {
                    userName.setError(null);
                    password.setError(null);
                    doLogin();

                }
            }
        });
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LogIn.this, SignUp.class);
                startActivity(i);
            }
        });

    }

    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9#_~!$&'()*+,;=:.\"(),:;<>@\\[\\]\\\\]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$";
    private Pattern pattern = Pattern.compile(EMAIL_PATTERN);
    private Matcher matcher;

    public boolean validateEmail(String email) {
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private static final String USERNAME = "^[a-z0-9_-]{3,15}$";
    private Pattern pattern1 = Pattern.compile(USERNAME);
    private Matcher matcher1;


    public boolean validatePassword(String Pw) {
        return Pw.length() >= 8;
    }

    public void doLogin() {
        Toast.makeText(getApplicationContext(), "Log In Success!", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(LogIn.this, OnTouch.class);

        startActivity(i);
    }

    protected void onPause() {
        super.onPause();
        finish();
    }
    public void onBackPressed()
    {
        moveTaskToBack(true);
    }

}
