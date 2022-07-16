package edu.ista.marlon.listamusic.service;

import edu.ista.marlon.listamusic.modelo.Cancion;
import edu.ista.marlon.listamusic.modelo.Lista;
import edu.ista.marlon.listamusic.repositorio.CancionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CancionServicioImpl implements CancionServicio{
    @Autowired
    CancionRepositorio cancionRepositorio;


    @Override
    public List<Cancion> findByAll() {
        return cancionRepositorio.findAll();
    }

    @Override
    public Cancion crear(Cancion c) {
        return cancionRepositorio.save(c);
    }

    @Override
    public Cancion findById(String titulo) {
        return cancionRepositorio.findById(titulo).orElse(null);
    }

    @Override
    public void delete(String titulo) {
        cancionRepositorio.deleteById(titulo);
    }
}
