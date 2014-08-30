package com.cachiruloapps.pirales.pilares.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cachiruloapps.pirales.pilares.R;

/**
 * Created by javierjavier on 27/08/14.
 */
public class MainActivity extends Activity {

    Button bAnadirEvento,bVerEventos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bAnadirEvento = (Button)findViewById(R.id.bAnadirEvento);
        bVerEventos = (Button)findViewById(R.id.bVerEventos);

        bAnadirEvento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, AnadirEventoActivity.class);

               startActivity(i);
            }
        });
        bVerEventos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ListaEventos.class);
                startActivity(i);
            }
        });

    }

}
