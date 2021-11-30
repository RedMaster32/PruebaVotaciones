package com.csto.prueba3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    public static String Votos_BD="Voto.bd";
    public static int Version_DB=1;
    public static String Tabla_Votos= "create table voto(id_voto integer  primary key autoincrement, voto_blaco integer, voto_nulo integer, voto_boric integer, voto_kast integer)";

    public DbHelper( Context context ) {
        super(context, Votos_BD, null, Version_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Tabla_Votos);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists voto");
        sqLiteDatabase.execSQL(Tabla_Votos);
    }
}
