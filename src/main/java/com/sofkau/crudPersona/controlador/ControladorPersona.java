package com.sofkau.crudPersona.controlador;

import com.sofkau.crudPersona.entidades.Persona;
import com.sofkau.crudPersona.servicios.InterfazServiciosPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api")
public class ControladorPersona{

    @Autowired
    private InterfazServiciosPersona serviciosPersona;

    @GetMapping(value = "/listarPersonas")
    public Iterable<Persona> listarPersonas(){
        return serviciosPersona.listar();
    }

    @GetMapping(value = "/listarPersona/{id}")
    public Optional<Persona> listarPersonaId(@PathVariable("id") int id){
        return serviciosPersona.listarId(id);
    }

    @PostMapping(value = "/guardarPersona")
    public Persona guardarPersona(@RequestBody Persona persona){

        return serviciosPersona.guardar(persona);
    }

    @PostMapping(value = "/actualizarPersona")
    public Persona actualizarPersona(@RequestBody Persona persona){
            return serviciosPersona.actualizar(persona);
    }

    @DeleteMapping(value = "/eliminarPersona/{id}")
    public void eliminarPersona(@PathVariable("id") int id){

        serviciosPersona.eliminar(id);
    }
}
