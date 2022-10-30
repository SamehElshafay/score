package com.example.score2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ConfirmNewPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_new_password);

        Firebase firebase = new Firebase();
        getIntent().getExtras().getString("userName");
        EditText _newPassword = findViewById(R.id.newPassword) ;
        EditText _confirmNewPassword = findViewById(R.id.confirmNewPassword) ;

        findViewById(R.id.next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newPassword = _newPassword.getText().toString() ;
                String confirmNewPassword = _confirmNewPassword.getText().toString();
                if( newPassword.equals(confirmNewPassword) && newPassword.length() >= 8 ){
                    firebase.updatePassword(getIntent().getExtras().getString("userName") , newPassword );
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    Toast.makeText(getApplicationContext() , "password is updated successfully" , Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getApplicationContext() , "confirmation is wrong or password less than 8 character" , Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}