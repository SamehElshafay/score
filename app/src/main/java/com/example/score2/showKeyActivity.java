package com.example.score2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class showKeyActivity extends AppCompatActivity {
    public static String username ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_key);
        TextView _key = findViewById(R.id.Key);

        _key.setText(getIntent().getExtras().getString("key"));
        getIntent().getExtras().getString("key") ;

        findViewById(R.id.copyButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String KEY = ((TextView)findViewById(R.id.Key)).getText().toString();
                ClipboardManager clipboard = (ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("Copied Key", KEY);
                clipboard.setPrimaryClip(clip);
            }
        });

        findViewById(R.id.next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), mainPage.class) ;

                intent.putExtra("key", getIntent().getExtras().getString("key") );
                intent.putExtra("username", getIntent().getExtras().getString("username") );
                intent.putExtra("link", getIntent().getExtras().getString("link") );
                username = getIntent().getExtras().getString("username") ;
                startActivity(intent);
            }
        });
    }
}