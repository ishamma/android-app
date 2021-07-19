package com.example.test01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Toast.makeText(getApplicationContext(), "We are moved to second Activity", Toast.LENGTH_LONG).show();
        Button btn = findViewById(R.id.btnurl);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent url = new Intent(Intent.ACTION_VIEW);
                url.setData(Uri.parse("https://www.Google.com"));
                startActivity(url);
            }
        });


        Button nav = findViewById(R.id.button2);
        nav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity3.this, sqllite.class));
            }
        });
    }













}