package edu.ista.marlon.listamusic.repositorio;

import edu.ista.marlon.listamusic.modelo.Lista;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Entity;
import javax.persistence.Table;

public interface ListaRepositorio extends JpaRepository <Lista, String> {
}