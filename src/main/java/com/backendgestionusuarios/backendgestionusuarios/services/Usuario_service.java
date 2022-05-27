package com.backendgestionusuarios.backendgestionusuarios.services;

import java.util.List;

import com.backendgestionusuarios.backendgestionusuarios.dao.Usuario_repository_dao;
import com.backendgestionusuarios.backendgestionusuarios.models.Usuario;

import org.springframework.beans.factory.annotation.Autowired;

public class Usuario_service implements IUsuario {

    @Autowired
    private Usuario_repository_dao usuario_dao;

    @Override
    public List<Usuario> findAll() {
        return null;
    }

    @Override
    public Usuario findById(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Usuario save(Usuario usuario) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void delete(Integer id) {
        // TODO Auto-generated method stub

    }

}
