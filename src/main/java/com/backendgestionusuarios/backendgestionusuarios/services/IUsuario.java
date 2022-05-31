package com.backendgestionusuarios.backendgestionusuarios.services;

import java.util.List;

import com.backendgestionusuarios.backendgestionusuarios.models.Usuario;

public interface IUsuario {

    public List<Usuario> findAll();

    public Usuario findById(Integer id);

    public Usuario save(Usuario usuario);

    public void delete(Integer id);

    public List<Usuario> findByName(String nombre);
}
