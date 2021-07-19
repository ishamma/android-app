package com.example.test01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Menuapp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuapp);
        EditText txt = findViewById(R.id.editTextTextPersonName);
        Button btn = findViewById(R.id.button);
        this.registerForContextMenu(btn);
        txt.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                v.showContextMenu();
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater  = getMenuInflater();
        inflater.inflate(R.menu.navigation,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.home:
//                Toast.makeText(Menuapp.this, "Home", Toast.LENGTH_SHORT).show();
//                Intent intent=new Intent();
//                intent.setAction(Intent.ACTION_SEND);
//                intent.putExtra(Intent.EXTRA_TEXT,"haw ae you?");
//                intent.setType("text/plain");
//                startActivity(Intent.createChooser(intent,"send text to.."));
//                break;
                startActivity(new Intent(this, MainActivity3.class));
                break;
            case R.id.about:
                Toast.makeText(Menuapp.this, "About", Toast.LENGTH_SHORT).show();

                    String s="01222";
                 Uri telnumber=Uri.parse("tel:"+s);
                 Intent call=new Intent(Intent.ACTION_DIAL, telnumber);
                 startActivity(call);
                 break;



        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        MenuInflater inflater  = getMenuInflater();
        inflater.inflate(R.menu.contextmenu,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.item1:
                Toast.makeText(Menuapp.this, "Contex Item 1", Toast.LENGTH_SHORT).show();
                Uri location=Uri.parse("geo:0,0?q=1600+Amphitheatre+Parkway,+Mountain+View,California");
                Intent mapIntent=new Intent(Intent.ACTION_VIEW,location);
                startActivity(mapIntent);
        
            case R.id.item2:
                Toast.makeText(Menuapp.this, "Contex Item 2", Toast.LENGTH_SHORT).show();
        }
        return super.onContextItemSelected(item);
    }
}