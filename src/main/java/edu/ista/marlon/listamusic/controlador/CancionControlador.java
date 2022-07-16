package edu.ista.marlon.listamusic.controlador;

import edu.ista.marlon.listamusic.modelo.Cancion;
import edu.ista.marlon.listamusic.modelo.Lista;
import edu.ista.marlon.listamusic.service.CancionServicioImpl;
import edu.ista.marlon.listamusic.service.ListaServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cancion")
public class CancionControlador {

    @Autowired
    CancionServicioImpl cancionServicio;
    @Autowired
    ListaServicioImpl listaServicio;

    @GetMapping("/listar")
    public List<Cancion> getLista() {
        return cancionServicio.findByAll();
    }

    @PostMapping("/crear/{lista}")
    public ResponseEntity<Cancion> crear(Cancion l, @RequestParam String lista) {

        Lista list = listaServicio.findById(lista);

        if (list != null) {
            l.setNombre(list);
            return new ResponseEntity<>(cancionServicio.crear(l), HttpStatus.CREATED);
        } else {
            System.out.println("HOLA HOLA HOLA HOLA HOLA HOLA HOLA HOLA HOLA HOLA HOLA HOLA HOLA HOLA HOLA HOLA HOLA HOLA HOLA HOLA HOLA HOLA HOLA HOLA ");
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Cancion> actualizarUsuario(@RequestParam String titulo, @RequestParam String lista, @RequestBody Cancion c) {
        Cancion cacnionActual = cancionServicio.findById(titulo);
        Lista list = listaServicio.findById(lista);

        if (!cacnionActual.getTitulo().equals(c.getTitulo())) {
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        } else {
            if (list != null) {
                if (cacnionActual != null) {
                    cacnionActual.setNombre(list);
                    cacnionActual.setAlbum(c.getAlbum());
                    cacnionActual.setArtista(c.getArtista());
                    cacnionActual.setAnio(c.getAnio());
                    cacnionActual.setTitulo(titulo);

                    return new ResponseEntity<>(cancionServicio.crear(cacnionActual), HttpStatus.NO_CONTENT);
                } else {
                    return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
                }
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        }

    }

    @GetMapping("/lista/{codigo}")
    public Cancion listarByCodigo(@RequestParam String nombre) {
        return cancionServicio.findById(nombre);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Cancion> eliminar(@RequestParam String titulo) {
        Cancion cancion = cancionServicio.findById(titulo);
        if (cancion != null) {
            cancionServicio.delete(titulo);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
