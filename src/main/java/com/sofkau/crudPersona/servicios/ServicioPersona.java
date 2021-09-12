package com.sofkau.crudPersona.servicios;

import com.sofkau.crudPersona.entidades.Persona;
import com.sofkau.crudPersona.excepciones.excepcion.BadRequestException;
import com.sofkau.crudPersona.excepciones.excepcion.NotFoundException;
import com.sofkau.crudPersona.repositorio.InterfazRepositorioPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioPersona implements InterfazServiciosPersona{

    @Autowired
    private InterfazRepositorioPersona personaRepository;

    @Override
    public List<Persona> listar() {
        return (List<Persona>) personaRepository.findAll();
    }

    @Override
    public Optional<Persona> listarId(int id) {

        if (personaRepository.existsById(id)){

            return personaRepository.findById(id);
        }

        throw new NotFoundException("Persona no encontrada");
    }

    @Override
    public Persona guardar(Persona persona) {

        if (persona.getNombre() != null || persona.getNombre() != ""){
            return personaRepository.save(persona);
        }

        throw new BadRequestException("Datos vacíos");
    }

    @Override
    public Persona actualizar(Persona persona) {

        if (personaRepository.existsById(persona.getId())){
            return guardar(persona);
        }

        throw new NotFoundException("Persona no encontrada");
    }

    @Override
    public void eliminar(int id) {
        if (personaRepository.existsById(id)) {

            personaRepository.deleteById(id);
        }else {

            throw new NotFoundException("Persona no encontrada");
        }

    }

}
