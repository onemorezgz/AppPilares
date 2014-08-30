package com.cachiruloapps.pirales.pilares.dao;

import android.content.Context;

import com.cachiruloapps.pirales.pilares.dao.eventos.EventosDAO;
import com.cachiruloapps.pirales.pilares.dao.eventos.EventosSQliteDAO;

/**
 * Created by javierjavier on 27/08/14.
 */
public class DAOFactory {

    private DAOFactory daoFactory;
    private Context context;
    private EventosDAO eventosDAO;

    public DAOFactory (Context context){
        this.context = context;
    }

    public EventosDAO getEventosDAO(){
        if(eventosDAO==null)eventosDAO=new EventosSQliteDAO(context);
        return eventosDAO;
    }
}
