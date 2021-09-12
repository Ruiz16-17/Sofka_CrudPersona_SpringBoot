package com.sofkau.crudPersona.servicios;

import com.sofkau.crudPersona.entidades.Persona;

import java.util.List;
import java.util.Optional;

public interface InterfazServiciosPersona{

    public List<Persona>listar();
    public Optional<Persona> listarId(int id) throws Exception;
    public Persona guardar(Persona persona);
    public void eliminar(int id);
}
