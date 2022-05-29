package com.backendgestionusuarios.backendgestionusuarios.services;

import java.util.List;

import com.backendgestionusuarios.backendgestionusuarios.models.Rol;

public interface IRol {

    public List<Rol> findAll();

    public Rol findById(Integer id);

    public Rol save(Rol rol);

    public void delete(Integer id);
}
