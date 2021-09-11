package com.sofkau.crudPersona.controlador;

import com.sofkau.crudPersona.entidades.Persona;
import com.sofkau.crudPersona.servicios.InterfazServiciosPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class ControladorPersona{

    @Autowired
    private InterfazServiciosPersona serviciosPersona;

    @GetMapping(value = "/listarPersonas")
    public Iterable<Persona> listarPersonas(){
        return serviciosPersona.listar();
    }

    @PostMapping(value = "/guardarPersona")
    public Persona guardarPersona(@RequestBody Persona persona){

        return serviciosPersona.guardar(persona);
    }
}
