package com.csto.prueba3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView tv_blanco, tv_nulo, tv_boric, tv_kast;
    Button btn_volver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tv_blanco= (TextView)findViewById(R.id.Id_Blanco);
        tv_nulo= (TextView)findViewById(R.id.Id_Nulo);
        tv_boric= (TextView)findViewById(R.id.Id_Boric);
        tv_kast= (TextView)findViewById(R.id.Id_Kast);

        btn_volver= (Button)findViewById(R.id.Btn_Volver);

        Integer Blanco=0,Nulo=0,Boric=0, Kast=0;

        SQLiteDatabase db;
        DbHelper conn = new DbHelper(getApplicationContext());
        db= conn.getReadableDatabase();
        Cursor C =db.query("voto",null,null,null,null,null,null);
        if(C!=null)
        {
            if(C.moveToFirst())
            {
                do{
                    if(C.getString(2).equals("N"))
                    {
                        Nulo++; //incrementar el contador total

                    }
                    if (C.getString(2).equals("B"))
                    {
                        Boric++; //incrementar el contador total
                    }
                    if (C.getString(2).equals("K"))
                    {
                        Kast++; //incrementar el contador total
                    }
                    else
                    {
                        Blanco++; //incrementar el contador total

                    }
                }
                while(C.moveToNext());
            }

        }
        tv_blanco.setText(""+Blanco);
        tv_nulo.setText(""+Nulo);
        tv_boric.setText(""+Boric);
        tv_kast.setText(""+Kast);

        btn_volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent I = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(I);

            }
        });

    }
}