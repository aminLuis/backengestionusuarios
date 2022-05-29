package com.backendgestionusuarios.backendgestionusuarios.services;

import java.util.List;

import com.backendgestionusuarios.backendgestionusuarios.dao.Rol_repository_dao;
import com.backendgestionusuarios.backendgestionusuarios.models.Rol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Rol_service implements IRol {

    @Autowired
    private Rol_repository_dao rol_dao;

    @Override
    public List<Rol> findAll() {
        return (List<Rol>) rol_dao.findAll();
    }

    @Override
    public Rol findById(Integer id) {
        return rol_dao.findById(id).orElseThrow(null);
    }

    @Override
    public Rol save(Rol rol) {
        return rol_dao.save(rol);
    }

    @Override
    public void delete(Integer id) {
        rol_dao.deleteById(id);
    }

}
