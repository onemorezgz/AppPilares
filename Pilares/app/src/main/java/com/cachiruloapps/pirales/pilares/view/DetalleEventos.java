package com.cachiruloapps.pirales.pilares.view;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.cachiruloapps.pirales.pilares.R;
import com.cachiruloapps.pirales.pilares.dao.DAOFactory;
import com.cachiruloapps.pirales.pilares.models.Eventos;

/**
 * Created by javierjavier on 30/08/14.
 */
public class DetalleEventos extends Activity{

    TextView tvTipo, tvTitulo, tvDescripcion, tvFecha, tvHora, tvLugar, tvLongitud, tvLatitud;
    String tipo, titulo, descripcion, fecha, hora, lugar, longitud, latitud;
    int position;
    DAOFactory daoFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_evento);

        position = getIntent().getIntExtra("position",position);

        tvTipo = (TextView)findViewById(R.id.tvTipo);
        tvTitulo = (TextView)findViewById(R.id.tvTitulo);
        tvDescripcion = (TextView)findViewById(R.id.tvDescripcion);
        tvHora = (TextView)findViewById(R.id.tvHora);
        tvFecha = (TextView)findViewById(R.id.tvFecha);
        tvLugar = (TextView)findViewById(R.id.tvLugar);
        tvLongitud = (TextView)findViewById(R.id.tvLongitud);
        tvLatitud = (TextView)findViewById(R.id.tvLatitud);

        daoFactory = new DAOFactory(getApplicationContext());
        Eventos eventos = daoFactory.getEventosDAO().getEvento(position);

        tvTipo.setText(eventos.getTipo());
        tvTitulo.setText(eventos.getTitulo());
        tvDescripcion.setText(eventos.getDescripcion());
        tvHora.setText(eventos.getHora());
        tvFecha.setText(eventos.getFecha());
        tvLongitud.setText(String.valueOf(eventos.getLugarlongitud()));
        tvLatitud.setText(String.valueOf(eventos.getLugarLatitud()));
        tvLugar.setText(eventos.getLugarNombre());






    }
}
