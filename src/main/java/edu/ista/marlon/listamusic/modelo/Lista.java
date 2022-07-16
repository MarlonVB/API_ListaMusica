package edu.ista.marlon.listamusic.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "lista")
@Data
@AllArgsConstructor
public class Lista {
    @Id
    private String nombre;
    private String descripcion;

    @OneToMany(mappedBy = "nombre",cascade = CascadeType.ALL)
    private List<Cancion>  cancion;

    public Lista() {}
}