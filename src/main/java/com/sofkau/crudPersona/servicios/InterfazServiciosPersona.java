package com.sofkau.crudPersona.servicios;

import com.sofkau.crudPersona.entidades.Persona;

import java.util.List;

public interface InterfazServiciosPersona{

    public List<Persona>listar();
    public Persona listarId(int id);
    public Persona guardar(Persona persona);
    public void eliminar(int id);
    public Persona actualizar(Persona persona);
}
