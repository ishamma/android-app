package com.example.test01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("Bonjour");
          Log.i("message","on Create");
        TextView tv1 = (TextView)findViewById(R.id.text1);
        tv1.setText("on Create");
        Button btn =(Button)findViewById(R.id.button1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Bonjour", Toast.LENGTH_SHORT).show();
                tv1.setText("Bonjour");
            }
        });
        EditText n1 = (EditText)findViewById(R.id.n1);
        EditText n2 = (EditText)findViewById(R.id.n2);
        TextView res = (TextView)findViewById(R.id.result);

        Button calc =(Button)findViewById(R.id.btncalc);
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                float v1 = Float.valueOf(n1.getText().toString());
                float v2 = Float.valueOf(n2.getText().toString());
                float somme =v1  + v2;
                Toast.makeText(MainActivity.this, String.valueOf(somme), Toast.LENGTH_SHORT).show();
                res.setText("Le resultat est :"+String.valueOf(somme));
            }
        });



        Button multy =(Button)findViewById(R.id.btnmulty);
        multy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                float v1 = Float.valueOf(n1.getText().toString());
                float v2 = Float.valueOf(n2.getText().toString());
                float multiplication =v1  * v2;
                Toast.makeText(MainActivity.this, String.valueOf(multiplication), Toast.LENGTH_SHORT).show();
                res.setText("Le resultat est :"+String.valueOf(multiplication));
            }
        });


        Button moins =(Button)findViewById(R.id.btnmuns);
        moins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float v1 = Float.valueOf(n1.getText().toString());
                float v2 = Float.valueOf(n2.getText().toString());
                float subtraction =v1  - v2;
                Toast.makeText(MainActivity.this, String.valueOf(subtraction), Toast.LENGTH_SHORT).show();
                res.setText("Le resultat est : "+String.valueOf(subtraction));
            }
        });


        Button div = (Button)findViewById(R.id.btndiv);
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float v1 = Float.valueOf(n1.getText().toString());
                float v2 = Float.valueOf(n2.getText().toString());
                float division =v1  / v2;
                Toast.makeText(MainActivity.this, String.valueOf(division), Toast.LENGTH_SHORT).show();
                res.setText("Le resultat est :"+String.valueOf(division));
            }
        });


        Button nav = findViewById(R.id.nav);
        nav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainActivity2.class));
            }
        });

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("message","on Stop");
        TextView tv1 = (TextView)findViewById(R.id.text1);
        tv1.setText("on Stop");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("message","on Resume");
        TextView tv1 = (TextView)findViewById(R.id.text1);
        tv1.setText("on Resume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("message","on Destroy");
        TextView tv1 = (TextView)findViewById(R.id.text1);
        tv1.setText("on Destroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("message","on Restart");
        TextView tv1 = (TextView)findViewById(R.id.text1);
        tv1.setText("on Restart");
    }
}