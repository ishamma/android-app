package com.example.test01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Conversation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversation);

        EditText v1 = findViewById(R.id.valeur1);
        TextView result = findViewById(R.id.textView4);

        Spinner sp1 = findViewById(R.id.spinner);
        String[] items = new String[]{"1", "2", "three"};
        List<String> list = new ArrayList<String>();
        list.add("select");
        list.add("DH");
        list.add("$");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, list);
        sp1.setAdapter(adapter);
        Spinner sp2 = findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, list);
        sp2.setAdapter(adapter2);

        Button convert = findViewById(R.id.convert);
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sp1.getSelectedItem()=="select" || sp2.getSelectedItem()=="select"  ){
                    Toast.makeText(Conversation.this, "Select a currency ", Toast.LENGTH_SHORT).show();
                    result.setText("Select a currency");
                }
                else if (sp1.getSelectedItem() == sp2.getSelectedItem()  ){
                    Toast.makeText(Conversation.this, "Select different currencies ", Toast.LENGTH_SHORT).show();
                    result.setText("Select different currencies");
                }
                else if (sp1.getSelectedItem() =="DH" ){
                    float res = Float.valueOf(v1.getText().toString())/10 ;
                    Toast.makeText(Conversation.this, ""+res+"$", Toast.LENGTH_SHORT).show();
                    result.setText(""+res+"$");
                }
                else if (sp1.getSelectedItem() =="$" ){
                    float res = Float.valueOf(v1.getText().toString())*10 ;
                    Toast.makeText(Conversation.this, ""+res+"DH", Toast.LENGTH_SHORT).show();
                    result.setText(""+res+"DH");
                }
            }
        });
        Button nav = findViewById(R.id.next);
        nav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Conversation.this, Menuapp.class));
            }
        });

    }
}