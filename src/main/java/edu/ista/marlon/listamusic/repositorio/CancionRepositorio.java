package edu.ista.marlon.listamusic.repositorio;

import edu.ista.marlon.listamusic.modelo.Cancion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CancionRepositorio extends JpaRepository<Cancion, String> {
}
