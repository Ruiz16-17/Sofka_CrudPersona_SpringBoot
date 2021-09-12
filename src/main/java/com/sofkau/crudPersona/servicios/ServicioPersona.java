package com.sofkau.crudPersona.servicios;

import com.sofkau.crudPersona.entidades.Persona;
import com.sofkau.crudPersona.repositorio.InterfazRepositorioPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioPersona implements InterfazServiciosPersona{

    @Autowired
    private InterfazRepositorioPersona data;

    @Override
    public List<Persona> listar() {
        return (List<Persona>) data.findAll();
    }

    @Override
    public Optional<Persona> listarId(int id) throws Exception {

        Persona persona = data.findById(id).orElse(null);

        if (persona != null){

            return data.findById(id);
        }

        throw new Exception("No se encontró el registro");

    }

    @Override
    public Persona guardar(Persona persona) {
        return data.save(persona);
    }

    @Override
    public void eliminar(int id) {
        data.deleteById(id);
    }

}
