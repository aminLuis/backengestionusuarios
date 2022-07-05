package com.backendgestionusuarios.backendgestionusuarios.dao;

import java.util.List;

import com.backendgestionusuarios.backendgestionusuarios.models.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Usuario_repository_dao extends JpaRepository<Usuario, Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM usuario WHERE nombre LIKE %?1%")
    public List<Usuario> findAll(String nombre);

    @Query(nativeQuery = true, value = "SELECT * FROM usuario WHERE correo=?1 AND nombre=?2")
    public Usuario findByCredentials(String correo, String nombre);
}
