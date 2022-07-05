package com.backendgestionusuarios.backendgestionusuarios.services;

import java.util.List;

import com.backendgestionusuarios.backendgestionusuarios.dao.Usuario_repository_dao;
import com.backendgestionusuarios.backendgestionusuarios.models.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Usuario_service implements IUsuario {

    @Autowired
    private Usuario_repository_dao usuario_dao;

    @Override
    public List<Usuario> findAll() {
        return (List<Usuario>) usuario_dao.findAll();
    }

    @Override
    public Usuario findById(Integer id) {
        return usuario_dao.findById(id).orElseThrow(null);
    }

    @Override
    public Usuario save(Usuario usuario) {
        return usuario_dao.save(usuario);
    }

    @Override
    public void delete(Integer id) {
        usuario_dao.deleteById(id);
    }

    @Override
    public List<Usuario> findByName(String nombre) {
        return (List<Usuario>) usuario_dao.findAll(nombre);
    }

    @Override
    public Usuario findByCredentials(String correo, String nombre) {
        return usuario_dao.findByCredentials(correo, nombre);
    }

}
