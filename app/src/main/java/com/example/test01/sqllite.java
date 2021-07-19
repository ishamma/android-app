package com.example.test01;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class sqllite extends AppCompatActivity {
        SQLiteDatabase DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqllite);

        DB=openOrCreateDatabase("bd",MODE_PRIVATE,null);
        DB.execSQL("Create table if not exists user(nom varchar,prenom varchar,tel varchar , email varchar , adresse varchar); ");

        Button btn_insert = findViewById(R.id.btninsert);
        btn_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText edit_nom = findViewById(R.id.nom);
                EditText edit_prenom = findViewById(R.id.prenom);
                EditText edit_tel = findViewById(R.id.tel);
                EditText edit_email = findViewById(R.id.email);
                EditText edit_adresse = findViewById(R.id.adress);


                String nom = edit_nom.getText().toString();
                String prenom = edit_prenom.getText().toString();
                String tel = edit_tel.getText().toString();
                String email = edit_email.getText().toString();
                String adresse = edit_adresse.getText().toString();

                DB.execSQL("insert into user(nom,prenom,tel,email,adresse) values('"+nom+"','"+prenom+"','"+tel+"','"+email+"','"+adresse+"')");

            }
        });


        Button btn_show = findViewById(R.id.btnsohw);
        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor result = DB.rawQuery("select * from user",null);
                if (result.getCount() ==0)
                {
                    Toast.makeText(getApplicationContext(),"Aucune ligne",Toast.LENGTH_LONG);
                    return;
                }
                else {
                    //StringBuffer b = new StringBuffer();
                    String b = "";
                    while (result.moveToNext())
                    {
                        b=("nom : "+result.getString(0)+"\n");
                        b+=("Prenom : "+result.getString(1)+"\n");
                        b+=("Telephone : "+result.getString(2)+"\n");
                        b+=("Email : "+result.getString(3)+"\n");
                        b+=("Adresse : "+result.getString(4)+"\n");

                    }
                    Toast.makeText(getApplicationContext(),b,Toast.LENGTH_LONG);
//                    AlertDialog.Builder alt = new AlertDialog.Builder(getApplicationContext());
//                    alt.setCancelable(true);
//                    alt.setTitle("Users");
//                    alt.setMessage(b.toString());
//                    alt.show();
                }



            }
        });
    }
}