package edu.ista.marlon.listamusic.controlador;

import edu.ista.marlon.listamusic.modelo.Cancion;
import edu.ista.marlon.listamusic.modelo.Lista;
import edu.ista.marlon.listamusic.service.CancionServicioImpl;
import edu.ista.marlon.listamusic.service.ListaServicio;
import edu.ista.marlon.listamusic.service.ListaServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/lista")
public class ListaControlador {

    @Autowired
    ListaServicioImpl listaServicio;

    @GetMapping("/listar")
    public List<Lista> getLista() {
        return listaServicio.findByAll();
    }

    @PostMapping("/crear")
    public ResponseEntity<Lista> crear(Lista l) {

        if (listaServicio.findById(l.getNombre()) == null) {
            return new ResponseEntity<>(listaServicio.crear(l), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Lista> actualizarUsuario(@RequestParam String nombre, @RequestBody Lista l) {
        Lista listaActual = listaServicio.findById(nombre);
        if (listaActual != null) {
            if (listaActual.getNombre().equals(l.getNombre())) {//
                listaActual.setNombre(nombre);
                listaActual.setDescripcion(l.getDescripcion());

                return new ResponseEntity<>(listaServicio.crear(listaActual), HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/lista/{codigo}")
    public ResponseEntity<Lista> listarByCodigo(@RequestParam String nombre) {
        Lista list = listaServicio.findById(nombre);

        if (list != null) {
            return new ResponseEntity<>(list, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Lista> eliminar(@RequestParam String nombre) {
        if (listaServicio.findById(nombre) != null) {
            listaServicio.delete(nombre);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
