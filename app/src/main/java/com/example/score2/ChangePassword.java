package com.example.score2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ChangePassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        Firebase firebase = new Firebase();

        ((EditText)findViewById(R.id.username)).setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus) {
                    String userName = ((EditText)findViewById(R.id.username)).getText().toString() ;
                    firebase.getKeyOfUser(userName);


                }
            }
        });

        findViewById(R.id.next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = ((EditText)findViewById(R.id.username)).getText().toString() ;
                String key = ((EditText)findViewById(R.id.key)).getText().toString() ;
                if(firebase.getKey().equals(key)) {
                    Intent intent = new Intent(getApplicationContext(), ConfirmNewPassword.class);
                    intent.putExtra("userName", userName);
                    intent.putExtra("key", key);
                    startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext() , "key or username is wrong" , Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}