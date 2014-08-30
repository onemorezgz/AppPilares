package com.cachiruloapps.pirales.pilares.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by javierjavier on 27/08/14.
 */
public class PilaresSQliteOpenHelper extends SQLiteOpenHelper {



    //Tabla Eventos
    public static final String TABLA_EVENTOS = "eventos";
    public static final String COLUMNA_ID_EVENTO = "id_evento";
    public static final String COLUMNA_TIPO = "tipo";
    public static final String COLUMNA_TITULO = "titulo";
    public static final String COLUMNA_DESCRIPCION = "descripcion";
    public static final String COLUMNA_FECHA = "fecha";
    public static final String COLUMNA_HORA = "hora";
    public static final String COLUMNA_LUGAR_NOMBRE = "lugar_nombre";
    public static final String COLUMNA_LUGAR_LONGUITUD = "lugar_longuitud";
    public static final String COLUMNA_LUGAR_LATITUD = "lugar_latitud";

    //Tabla Favoritos
    public static final String TABLA_FAVORITOS = "favoritos";
    public static final String COLUMNA_ID_FAVORITOS = "id_favoritos";
    public static final String COLUMNA_ES_FAVORITOS = "es_favoritos";

    private static final String DATABASE_NAME = "pilares.db";
    private static final int DATABASE_VERSION = 1;

    private static final String SQL_CREATE_EVENTOS = "create table "
            + TABLA_EVENTOS + "(" +
            COLUMNA_ID_EVENTO+ " integer primary key autoincrement, " +
            COLUMNA_TIPO + " text not null, " +
            COLUMNA_TITULO + " text not null, " +
            COLUMNA_DESCRIPCION + " text not null, " +
            COLUMNA_FECHA + " text not null, " +
            COLUMNA_HORA + " text not null, " +
            COLUMNA_LUGAR_NOMBRE + " text not null, " +
            COLUMNA_LUGAR_LONGUITUD + " text not null, " +
            COLUMNA_LUGAR_LATITUD + " text not null);";

    private static final String SQL_CREATE_FAVORITOS = "create table "
            + TABLA_FAVORITOS + "(" +
            COLUMNA_ID_FAVORITOS+ " integer primary key autoincrement, " +
            COLUMNA_ES_FAVORITOS + " text not null);";



    public PilaresSQliteOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_EVENTOS);
        db.execSQL(SQL_CREATE_FAVORITOS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLA_FAVORITOS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLA_EVENTOS);
        onCreate(db);
    }
}
