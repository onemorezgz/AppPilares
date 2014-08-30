package com.cachiruloapps.pirales.pilares.view;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.cachiruloapps.pirales.pilares.R;
import com.cachiruloapps.pirales.pilares.dao.DAOFactory;
import com.cachiruloapps.pirales.pilares.models.Eventos;

import java.util.ArrayList;

/**
 * Created by javierjavier on 29/08/14.
 */
public class ListaEventos extends Activity {

    ListView listEventos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_eventos);

        listEventos = (ListView) findViewById(R.id.listEventos);

        DAOFactory daoFactory = new DAOFactory(getApplicationContext());
        ArrayList <Eventos> eventos = daoFactory.getEventosDAO().getAllEventos();

        listEventos.setAdapter(new AdapterEventos(ListaEventos.this,eventos));

        listEventos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(ListaEventos.this, DetalleEventos.class);
                Eventos eventos = (Eventos) listEventos.getItemAtPosition(position);
                i.putExtra ("position",position);
                startActivity(i);
            }
        });
    }
}
