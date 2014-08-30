package com.cachiruloapps.pirales.pilares.dao.eventos;

import com.cachiruloapps.pirales.pilares.models.Eventos;

import java.util.ArrayList;

/**
 * Created by javierjavier on 27/08/14.
 */
public interface EventosDAO {

    public void insertEventos(Eventos eventos);
    public void updateEventos();
    public Eventos getEvento(int position);
    public ArrayList <Eventos> getAllEventos();

}
