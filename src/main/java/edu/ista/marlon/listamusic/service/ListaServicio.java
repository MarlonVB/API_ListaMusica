package edu.ista.marlon.listamusic.service;

import edu.ista.marlon.listamusic.modelo.Lista;

import java.util.List;

public interface ListaServicio {

    public List<Lista> findByAll();
    public Lista crear(Lista c);

    public Lista findById(String nombre);

    public void delete(String nombre);
}
