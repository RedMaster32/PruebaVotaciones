package com.csto.prueba3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup votos;
    Button votar, ver;
    RadioButton nulo, boric, kast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        votar=(Button)findViewById(R.id.btn_votar);
        ver=(Button)findViewById(R.id.btn_resultado);
        votos=(RadioGroup)findViewById(R.id.Votos);
        nulo=(RadioButton)findViewById(R.id.Id_nulo);
        boric=(RadioButton)findViewById(R.id.id_GB);
        kast=(RadioButton)findViewById(R.id.id_kast);
        ContentValues BD = new ContentValues();



        votar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(nulo.isChecked()==false || boric.isChecked()==false || kast.isChecked()==false){
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("Boto Blanco?")
                            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    SQLiteDatabase db;
                                    DbHelper conn = new DbHelper(getApplicationContext());
                                    db = conn.getReadableDatabase();
                                    db.insert("voto",null,BD);
                                    Intent I = new Intent(getApplicationContext(),MainActivity2.class);
                                    startActivity(I);
                                }
                            })
                            .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                }
                            });
                    builder.create();
                    builder.show();
                }
                SQLiteDatabase db;
                DbHelper conn = new DbHelper(getApplicationContext());
                db= conn.getWritableDatabase();
                if(nulo.isChecked()==true){
                    BD.put("Nulo",nulo.getText().toString());
                    db.insert("voto",null,BD);
                    Toast.makeText(getApplicationContext(),"Guardado", Toast.LENGTH_LONG).show();
                    Intent I = new Intent(getApplicationContext(),MainActivity2.class);
                    startActivity(I);
                }
                if(boric.isChecked()==true){

                    BD.put("Boric",boric.getText().toString());
                    db.insert("voto",null,BD);
                    Toast.makeText(getApplicationContext(),"Guardado", Toast.LENGTH_LONG).show();
                    Intent I = new Intent(getApplicationContext(),MainActivity2.class);
                    startActivity(I);
                }
                if(kast.isChecked()==true){
                    BD.put("Kast",kast.getText().toString());
                    db.insert("voto",null,BD);
                    Toast.makeText(getApplicationContext(),"Guardado", Toast.LENGTH_LONG).show();
                    Intent I = new Intent(getApplicationContext(),MainActivity2.class);
                    startActivity(I);
                }


            }
        });
        ver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(getApplicationContext(),MainActivity2.class);
                I.putExtra("Blanco","0");
                I.putExtra("Nulo","0");
                I.putExtra("Boric","0");
                I.putExtra("Kast","0");
                startActivity(I);
            }
        });
    }
}



