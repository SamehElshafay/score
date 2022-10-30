package com.example.score2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class Requests extends AppCompatActivity {
    int position = 0 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requests);
        Firebase firebase = new Firebase();

        String key[] = getIntent().getExtras().getString("key").split(" ") ;

        firebase.getMatchInformation(key);

        LoadingDialog loadingDialog = new LoadingDialog(this) ;
        loadingDialog.startLoadingDialog();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ListView lv = findViewById(R.id.RequestList);
                ResultAdapter resultAdapter = new ResultAdapter(firebase.getMatch() , getApplication());
                lv.setAdapter(resultAdapter);
                //resultAdapter.notifyDataSetChanged();
                loadingDialog.dismisDialog();
            }
        }, 3000);


        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Sure !!!");
        builder.setMessage("Are you sure that you want to add this match?");


        String requ = "" ;

        for(int  i = 0 ; i < key.length ; i++){
            if(i == position)
                requ = requ + " " + key[i] ;
            System.out.println(requ + " =:::W");
        }

        String finalRequ = requ;
        System.out.println(finalRequ + "final =:::W");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                firebase.getTwoPlayerMatchs(firebase.getMatch().get(position));
                loadingDialog.startLoadingDialog();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        firebase.acceptRequest
                ( firebase.getMatch().get(position),key[position] , finalRequ, firebase.getPlayersMatch() );
                        loadingDialog.dismisDialog();
                    }
                }, 3000);

                Toast.makeText(getApplicationContext() , "match has added successfully" , Toast.LENGTH_LONG ).show();
                dialog.dismiss();
            }
        });

        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext() , "It will be there until you agree to it" , Toast.LENGTH_LONG ).show();
                dialog.dismiss();
            }
        });

        AlertDialog alert = builder.create();

        ((ListView)findViewById(R.id.RequestList)).setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                position = i ;
                alert.show();
            }
        });
    }
}