package com.cachiruloapps.pirales.pilares.dao.eventos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.cachiruloapps.pirales.pilares.dao.PilaresSQliteOpenHelper;
import com.cachiruloapps.pirales.pilares.models.Eventos;

import java.util.ArrayList;

/**
 * Created by javierjavier on 27/08/14.
 */
public class EventosSQliteDAO implements EventosDAO {

    PilaresSQliteOpenHelper mDbHelper = null;

    public EventosSQliteDAO (Context context){
        mDbHelper = new PilaresSQliteOpenHelper(context);

    }

    SQLiteDatabase db;

    @Override
    public void insertEventos(Eventos eventos) {

        db = mDbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(PilaresSQliteOpenHelper.COLUMNA_TIPO, eventos.getTipo());
        values.put(PilaresSQliteOpenHelper.COLUMNA_TITULO, eventos.getTitulo());
        values.put(PilaresSQliteOpenHelper.COLUMNA_DESCRIPCION, eventos.getDescripcion());
        values.put(PilaresSQliteOpenHelper.COLUMNA_FECHA, eventos.getFecha());
        values.put(PilaresSQliteOpenHelper.COLUMNA_HORA, eventos.getHora());
        values.put(PilaresSQliteOpenHelper.COLUMNA_LUGAR_NOMBRE, eventos.getLugarNombre());
        values.put(PilaresSQliteOpenHelper.COLUMNA_LUGAR_LATITUD, eventos.getLugarLatitud());
        values.put(PilaresSQliteOpenHelper.COLUMNA_LUGAR_LONGUITUD, eventos.getLugarlongitud());
        db.insert(PilaresSQliteOpenHelper.TABLA_EVENTOS, null, values);
        db.close();

    }

    @Override
    public void updateEventos() {

    }

    @Override
    public Eventos getEvento(int position) {
        db = mDbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + PilaresSQliteOpenHelper.TABLA_EVENTOS, null);
        Eventos eventos = new Eventos();
        cursor.moveToPosition(position);
        eventos.setFecha(cursor.getString(cursor.getColumnIndex(PilaresSQliteOpenHelper.COLUMNA_FECHA)));
        eventos.setTipo(cursor.getString(cursor.getColumnIndex(PilaresSQliteOpenHelper.COLUMNA_TIPO)));
        eventos.setTitulo(cursor.getString(cursor.getColumnIndex(PilaresSQliteOpenHelper.COLUMNA_TITULO)));
        eventos.setDescripcion(cursor.getString(cursor.getColumnIndex(PilaresSQliteOpenHelper.COLUMNA_DESCRIPCION)));
        eventos.setHora(cursor.getString(cursor.getColumnIndex(PilaresSQliteOpenHelper.COLUMNA_HORA)));
        eventos.setLugarNombre(cursor.getString(cursor.getColumnIndex(PilaresSQliteOpenHelper.COLUMNA_LUGAR_NOMBRE)));
        eventos.setLugarLatitud(cursor.getDouble(cursor.getColumnIndex(PilaresSQliteOpenHelper.COLUMNA_LUGAR_LATITUD)));
        eventos.setLugarlongitud(cursor.getDouble(cursor.getColumnIndex(PilaresSQliteOpenHelper.COLUMNA_LUGAR_LONGUITUD)));
        cursor.close();
        db.close();
        return eventos;
    }

    @Override
    public ArrayList<Eventos> getAllEventos(){

        db = mDbHelper.getReadableDatabase();

        Cursor query = db.query(PilaresSQliteOpenHelper.TABLA_EVENTOS,null,null,null,null,null,null);
        ArrayList<Eventos> eventos = new ArrayList<Eventos>();
        query.moveToFirst();
        for(int i=0;i<query.getCount();i++){
            Eventos evento = cursorEvento(query);
            eventos.add(evento);
            query.moveToNext();
        }
        query.close();
        db.close();
        return eventos;

    }

    private Eventos cursorEvento(Cursor query) {

        Eventos evento = new Eventos();
        evento.setTitulo(query.getString(query.getColumnIndex(PilaresSQliteOpenHelper.COLUMNA_TITULO)));
        evento.setDescripcion(query.getString(query.getColumnIndex(PilaresSQliteOpenHelper.COLUMNA_DESCRIPCION)));
        evento.setFecha(query.getString(query.getColumnIndex(PilaresSQliteOpenHelper.COLUMNA_FECHA)));
        evento.setHora(query.getString(query.getColumnIndex(PilaresSQliteOpenHelper.COLUMNA_HORA)));
        evento.setTipo(query.getString(query.getColumnIndex(PilaresSQliteOpenHelper.COLUMNA_TIPO)));
        evento.setLugarNombre(query.getString(query.getColumnIndex(PilaresSQliteOpenHelper.COLUMNA_LUGAR_NOMBRE)));
        evento.setLugarLatitud(query.getInt(query.getColumnIndex(PilaresSQliteOpenHelper.COLUMNA_LUGAR_LATITUD)));
        evento.setLugarlongitud(query.getInt(query.getColumnIndex(PilaresSQliteOpenHelper.COLUMNA_LUGAR_LONGUITUD)));

        return evento;
    }
}
