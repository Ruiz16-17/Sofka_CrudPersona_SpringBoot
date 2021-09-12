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
    public Object listarPersonaId(@PathVariable("id") int id){

        try {

            return serviciosPersona.listarId(id);
        }catch (Exception e){

            return e.getMessage();
        }
    }

    @PostMapping(value = "/guardarPersona")
    public Persona guardarPersona(@RequestBody Persona persona){

        return serviciosPersona.guardar(persona);
    }
/*
    @PostMapping(value = "/actualizarPersona")
    public Persona actualizarPersona(@RequestBody Persona persona){

        if((serviciosPersona.listarId(persona.getId())).orElse(null) != null){
            return serviciosPersona.guardar(persona);
        }else {
            return null;
        }
    }
*/
    @DeleteMapping(value = "/eliminarPersona/{id}")
    public void eliminarPersona(@PathVariable("id") int id){

        serviciosPersona.eliminar(id);
    }
}
