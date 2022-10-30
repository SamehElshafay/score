package com.example.score2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static String username ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText _username = findViewById(R.id.username);
        EditText _password = findViewById(R.id.password);
        TextView _signup   = findViewById(R.id.signin);
        TextView _forgetpassword   = findViewById(R.id.forgetpassword);

        Firebase firebase = new Firebase();
        _username.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus) {
                    preparePassword(_username , firebase);
                }
            }
        });

        findViewById(R.id.signUp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn(_password , firebase);
            }
        });

        _signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(new Intent(getApplicationContext(), signupActivity.class));
            }
        });

        _forgetpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(new Intent(getApplicationContext(), ChangePassword.class));
            }
        });
    }

    void signIn(EditText password , Firebase firebase){
        if(password.getText().toString().equals(firebase.getPassword())){
            finish();
            Intent intent = new Intent(getApplicationContext(), mainPage.class) ;
            intent.putExtra("username", ((EditText)findViewById(R.id.username)).getText().toString());
            intent.putExtra("userimage", firebase.getLink());
            username = ((EditText)findViewById(R.id.username)).getText().toString() ;
            startActivity(intent);
        }
        else{
            System.out.println("sign in hasn't done successfuly");
        }
    }

    void preparePassword(EditText username , Firebase firebase){
        firebase.getUserInformation(username.getText().toString().replaceAll(" ",""));
    }

    @Override
    public void onBackPressed() {

    }

}