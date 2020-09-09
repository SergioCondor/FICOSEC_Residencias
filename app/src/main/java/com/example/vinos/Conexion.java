package com.example.vinos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Conexion extends SQLiteOpenHelper {
    String tablausarios="create table usuarios (Id integer not null primary key autoincrement, " +
            "Name text, "+
            "Img text, "+
            "Nivel text, "+
            "Email text, "+
            "Password text)";
    String tablaproductos="create table productos (Id integer not null primary key autoincrement, " +
            "Name text, "+
            "Img text, "+
            "Stock text, "+
            "Codigo text)";
    String tablatipovinos="create table tipovinos (Id integer not null primary key autoincrement, " +
            "Nombre text, "+
            "Color text, "+
            "Grado text)";
    String tablaedadvinos="create table edadvinos (Id integer not null primary key autoincrement, " +
            "Nombre text, "+
            "TiempoBarrica text, "+
            "TiempoBotella text, "+
            "TiempoTotal text, "+
            "Crianza text, "+
            "Reserva text, "+
            "GranReserva text)";
    String tablaazucarvino="create table azucarvinos (Id integer not null primary key autoincrement, " +
            "Nombre text, "+
            "AzucarResidual text)";//secos, abocados, semisecos, semidulces, dulces y dulces naturales


    public Conexion (Context context){
        super(context, "Vinos",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tablausarios);
        db.execSQL(tablaproductos);
        db.execSQL(tablatipovinos);
        db.execSQL(tablaedadvinos);
        db.execSQL(tablaazucarvino);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
