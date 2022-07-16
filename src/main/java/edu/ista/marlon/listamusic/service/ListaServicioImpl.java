package edu.ista.marlon.listamusic.service;

import edu.ista.marlon.listamusic.modelo.Lista;
import edu.ista.marlon.listamusic.repositorio.ListaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListaServicioImpl implements ListaServicio{

    @Autowired
    ListaRepositorio listaRepositorio;

    @Override
    public List<Lista> findByAll() {
        return listaRepositorio.findAll();
    }

    @Override
    public Lista crear(Lista c) {
        return listaRepositorio.save(c);
    }

    @Override
    public Lista findById(String nombre) {
        return listaRepositorio.findById(nombre).orElse(null);
    }



    @Override
    public void delete(String nombre) {
        listaRepositorio.deleteById(nombre);
    }

}
