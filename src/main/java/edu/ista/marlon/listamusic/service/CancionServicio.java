package edu.ista.marlon.listamusic.service;

import edu.ista.marlon.listamusic.modelo.Cancion;
import edu.ista.marlon.listamusic.modelo.Lista;

import java.util.List;

public interface CancionServicio {
    public List<Cancion> findByAll();
    public Cancion crear(Cancion c);

    public Cancion findById(String titulo);

    public void delete(String nombre);
}
