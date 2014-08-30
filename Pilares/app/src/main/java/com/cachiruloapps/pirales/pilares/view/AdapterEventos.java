package com.cachiruloapps.pirales.pilares.view;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.cachiruloapps.pirales.pilares.R;
import com.cachiruloapps.pirales.pilares.models.Eventos;

import java.util.ArrayList;

/**
 * Created by javierjavier on 29/08/14.
 */
public class AdapterEventos extends BaseAdapter{

    private Activity activity;
    private ArrayList<Eventos> eventos;
    private static LayoutInflater inflater;

    public AdapterEventos(Activity activity, ArrayList<Eventos> eventos) {
        super();
        this.activity = activity;
        this.eventos = eventos;
        this.inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return eventos.size();
    }

    @Override
    public Object getItem(int position) {
        return eventos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=null;

        if (convertView == null) {

            convertView = inflater.inflate(R.layout.celda_evento,null);

            viewHolder = new ViewHolder();
            viewHolder.titulo = (TextView) convertView.findViewById(R.id.tvTipo);
            viewHolder.fecha = (TextView) convertView.findViewById(R.id.tvFecha);
            viewHolder.hora = (TextView) convertView.findViewById(R.id.tvHora);
            viewHolder.position=position;
            convertView.setTag(viewHolder);

        }else{
            viewHolder =  (ViewHolder)  convertView.getTag();
        }

        viewHolder.position = position;
        viewHolder.titulo.setText( eventos.get(position).getTitulo());
        viewHolder.fecha.setText(eventos.get(position).getFecha());
        return convertView;
    }

    public static class ViewHolder{
        public TextView titulo;
        public TextView fecha;
        public TextView hora;
        public static int position;
    }

}
