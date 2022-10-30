package com.example.score2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class signupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        EditText _password = findViewById(R.id.password);
        EditText _confirmPassword = findViewById(R.id.confirmPassword);
        EditText _userName = findViewById(R.id.username);
        Firebase firebase = new Firebase();

        findViewById(R.id.signUp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String password = _password.getText().toString() ;
                String confirmPassword = _confirmPassword.getText().toString() ;
                String userName = _userName.getText().toString() ;
                if(password.equals("") || confirmPassword.equals("") || userName.equals("")){
                    Toast.makeText(getApplicationContext() , "empty failed !!" , Toast.LENGTH_LONG).show();
                }
                else {
                    if(!password.equals(confirmPassword)){
                        Toast.makeText(getApplicationContext() , "confirm password dosn't same the pasword" , Toast.LENGTH_LONG).show();
                    }
                    else {
                        if(password.length() < 8){
                            Toast.makeText(getApplicationContext() , "pasword shouldn't be not less than 8 charachter" , Toast.LENGTH_LONG).show();
                        }
                        else {
                            if(userName.length() < 8){
                                Toast.makeText(getApplicationContext() , "username shouldn't be not less than 8 charachter" , Toast.LENGTH_LONG).show();
                            }
                            else {
                                finish();
                                String link = returnLinkUsingName(userName) ;
                                Intent intent = new Intent(getApplicationContext() , showKeyActivity.class) ;
                                String key =  firebase.addUser(userName , password , link);
                                intent.putExtra("key", key );
                                intent.putExtra("username", userName );
                                intent.putExtra("link", link );
                                startActivity(intent);
                            }
                        }
                    }
                }
            }
        });
        ((TextView)findViewById(R.id.signin)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(new Intent(getApplicationContext() , MainActivity.class));
            }
        });
    }

    public String returnLinkUsingName(String name){
        String firstChar = name.charAt(0) + "" ;
        String link ;
        if(firstChar.equals("A") || firstChar.equals("a")){link = "https://firebasestorage.googleapis.com/v0/b/score2-55ca3.appspot.com/o/AChar.jpg?alt=media&token=235c7387-aac8-47b8-8552-92aea61bbeb9";}
        else if(firstChar.equals("B") || firstChar.equals("b")){link = "https://firebasestorage.googleapis.com/v0/b/score2-55ca3.appspot.com/o/BChar.jpg?alt=media&token=da3cc5ef-6043-4805-b0bd-796ca642ae01";}
        else if(firstChar.equals("C") || firstChar.equals("c")){link = "https://firebasestorage.googleapis.com/v0/b/score2-55ca3.appspot.com/o/CChar.jpg?alt=media&token=aa8c0fd0-e674-4b31-8b53-b36de0d1ff3f";}
        else if(firstChar.equals("D") || firstChar.equals("d")){link = "https://firebasestorage.googleapis.com/v0/b/score2-55ca3.appspot.com/o/DChar.jpg?alt=media&token=8e6bcbf0-7f41-4072-8994-871b2d844fb4";}
        else if(firstChar.equals("E") || firstChar.equals("e")){link = "https://firebasestorage.googleapis.com/v0/b/score2-55ca3.appspot.com/o/EChar.jpg?alt=media&token=ff602418-a674-4470-a0ed-f95098ce490e";}
        else if(firstChar.equals("F") || firstChar.equals("f")){link = "https://firebasestorage.googleapis.com/v0/b/score2-55ca3.appspot.com/o/FChar.jpg?alt=media&token=900fd51c-45c9-470c-80e8-a77e8d614dc9";}
        else if(firstChar.equals("G") || firstChar.equals("g")){link = "https://firebasestorage.googleapis.com/v0/b/score2-55ca3.appspot.com/o/GChar.jpg?alt=media&token=47edafb6-88a2-401f-912a-0040f2cd3ec6";}
        else if(firstChar.equals("H") || firstChar.equals("h")){link = "https://firebasestorage.googleapis.com/v0/b/score2-55ca3.appspot.com/o/HChar.jpg?alt=media&token=692771d6-01af-4756-a7bd-2ce2984a3e1d";}
        else if(firstChar.equals("I") || firstChar.equals("i")){link = "https://firebasestorage.googleapis.com/v0/b/score2-55ca3.appspot.com/o/IChar.jpg?alt=media&token=713eb80b-f7fc-4e52-b7dd-48e988f44d5e";}
        else if(firstChar.equals("J") || firstChar.equals("j")){link = "https://firebasestorage.googleapis.com/v0/b/score2-55ca3.appspot.com/o/JChar.jpg?alt=media&token=072190b8-9577-49a6-93a9-c01eaa1f8470";}
        else if(firstChar.equals("K") || firstChar.equals("k")){link = "https://firebasestorage.googleapis.com/v0/b/score2-55ca3.appspot.com/o/KChar.jpg?alt=media&token=b53fb9e1-dd3b-4888-97e9-19993de34152";}
        else if(firstChar.equals("L") || firstChar.equals("l")){link = "https://firebasestorage.googleapis.com/v0/b/score2-55ca3.appspot.com/o/LChar.jpg?alt=media&token=325d5cc1-36fc-489c-a469-ceb761d50bf2";}
        else if(firstChar.equals("M") || firstChar.equals("m")){link = "https://firebasestorage.googleapis.com/v0/b/score2-55ca3.appspot.com/o/MChar.jpg?alt=media&token=fb4a8a9f-0fb5-429e-8572-2f37a0c32516";}
        else if(firstChar.equals("N") || firstChar.equals("n")){link = "https://firebasestorage.googleapis.com/v0/b/score2-55ca3.appspot.com/o/NChar.jpg?alt=media&token=cc06f447-7ef7-47b1-816b-402e432f9f8f";}
        else if(firstChar.equals("O") || firstChar.equals("o")){link = "https://firebasestorage.googleapis.com/v0/b/score2-55ca3.appspot.com/o/OChar.jpg?alt=media&token=6884bd03-0503-4295-8a75-4fa5f468b063";}
        else if(firstChar.equals("P") || firstChar.equals("p")){link = "https://firebasestorage.googleapis.com/v0/b/score2-55ca3.appspot.com/o/PChar.jpg?alt=media&token=44e9c0f5-d164-476e-a48a-34ae17569a71";}
        else if(firstChar.equals("Q") || firstChar.equals("q")){link = "https://firebasestorage.googleapis.com/v0/b/score2-55ca3.appspot.com/o/QChar.jpg?alt=media&token=5493ab34-2d2f-44c7-bca9-e667c0e526e6";}
        else if(firstChar.equals("R") || firstChar.equals("r")){link = "https://firebasestorage.googleapis.com/v0/b/score2-55ca3.appspot.com/o/RChar.jpg?alt=media&token=c638685a-94e7-45af-b883-d710d22f1125";}
        else if(firstChar.equals("S") || firstChar.equals("s")){link = "https://firebasestorage.googleapis.com/v0/b/score2-55ca3.appspot.com/o/SChar.jpg?alt=media&token=4941600b-0173-4b4c-a8bd-688dee7af10b";}
        else if(firstChar.equals("T") || firstChar.equals("t")){link = "https://firebasestorage.googleapis.com/v0/b/score2-55ca3.appspot.com/o/TChar.jpg?alt=media&token=be7a5777-fa99-4c7f-a801-3bc00fca7f54";}
        else if(firstChar.equals("U") || firstChar.equals("u")){link = "https://firebasestorage.googleapis.com/v0/b/score2-55ca3.appspot.com/o/UChar.jpg?alt=media&token=96fa4c8b-5631-40f8-a2d2-463bc51213f0";}
        else if(firstChar.equals("V") || firstChar.equals("v")){link = "https://firebasestorage.googleapis.com/v0/b/score2-55ca3.appspot.com/o/VChar.jpg?alt=media&token=829c6cf1-059f-4b94-87f4-6e0e5209a106";}
        else if(firstChar.equals("W") || firstChar.equals("w")){link = "https://firebasestorage.googleapis.com/v0/b/score2-55ca3.appspot.com/o/WChar.jpg?alt=media&token=c138b112-3bcd-44b0-9523-3e21e3ec2b8f";}
        else if(firstChar.equals("X") || firstChar.equals("x")){link = "https://firebasestorage.googleapis.com/v0/b/score2-55ca3.appspot.com/o/XChar.jpg?alt=media&token=6f8a04c8-34ee-4f73-8165-6501d49c5970";}
        else if(firstChar.equals("Y") || firstChar.equals("y")){link = "https://firebasestorage.googleapis.com/v0/b/score2-55ca3.appspot.com/o/YChar.jpg?alt=media&token=e3b511b4-b484-4636-89c6-bdefc71bbfe1";}
        else {link = "https://firebasestorage.googleapis.com/v0/b/score2-55ca3.appspot.com/o/ZChar.jpg?alt=media&token=407ac578-e6cf-425a-bbe7-d0ed1b127b63";}
        return link ;
    }
//    @Override
//    public void onBackPressed() {
//
//    }

}