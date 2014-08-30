package com.cachiruloapps.pirales.pilares.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cachiruloapps.pirales.pilares.R;
import com.cachiruloapps.pirales.pilares.dao.DAOFactory;
import com.cachiruloapps.pirales.pilares.models.Eventos;

/**
 * Created by javierjavier on 27/08/14.
 */
public class AnadirEventoActivity extends Activity{

    EditText etTipo,etTitulo,etDescripcion,etFecha,etHora,etLugarNombre,etLugarLatitud,etLugarlongitud;
    Button bAnadir;
    String tipo, titulo, descripcion, fecha, hora, lugarNombre;
    Double  lugarLatitud, lugarlongitud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anadir_evento);

        etTipo = (EditText) findViewById(R.id.etTipo);
        etTitulo = (EditText) findViewById(R.id.etTitulo);
        etDescripcion = (EditText) findViewById(R.id.etDescripcion);
        etFecha = (EditText) findViewById(R.id.etFecha);
        etHora = (EditText) findViewById(R.id.etHora);
        etLugarNombre = (EditText) findViewById(R.id.etLugarNombre);
        etLugarLatitud = (EditText) findViewById(R.id.etLugarLatitud);
        etLugarlongitud = (EditText) findViewById(R.id.etLugarLongitud);
        bAnadir = (Button) findViewById(R.id.bAnadir);

        bAnadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tipo = etTipo.getText().toString();
                titulo = etTitulo.getText().toString();
                descripcion = etDescripcion.getText().toString();
                fecha = etFecha.getText().toString();
                hora = etHora.getText().toString();
                lugarNombre = etLugarNombre.getText().toString();
                lugarLatitud = Double.valueOf(etLugarLatitud.getText().toString());
                lugarlongitud = Double.valueOf(etLugarlongitud.getText().toString());


                Eventos eventos = new Eventos();
                DAOFactory daoFactory = new DAOFactory(getApplicationContext());

                eventos.setTipo(tipo);
                eventos.setTitulo(titulo);
                eventos.setDescripcion(descripcion);
                eventos.setFecha(fecha);
                eventos.setHora(hora);
                eventos.setLugarNombre(lugarNombre);
                eventos.setLugarLatitud(lugarLatitud);
                eventos.setLugarlongitud(lugarlongitud);

                daoFactory.getEventosDAO().insertEventos(eventos);

                Toast toast = Toast.makeText(getApplicationContext(),"guardando",Toast.LENGTH_SHORT);
                toast.show();

                Intent i = new Intent(AnadirEventoActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

    }

}
