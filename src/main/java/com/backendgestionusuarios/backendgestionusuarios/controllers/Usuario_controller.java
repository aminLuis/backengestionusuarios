package com.backendgestionusuarios.backendgestionusuarios.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.backendgestionusuarios.backendgestionusuarios.models.Usuario;
import com.backendgestionusuarios.backendgestionusuarios.services.IUsuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Usuario_controller {

    @Autowired
    private IUsuario usuario_service;

    @GetMapping("/usuario")
    public List<Usuario> getUsuarios() {
        return usuario_service.findAll();
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<?> getUsuario(@PathVariable Integer id) {
        Usuario usuario = null;
        Map<String, Object> response = new HashMap<>();

        try {
            usuario = usuario_service.findById(id);
        } catch (DataAccessException e) {
            response.put("Mensaje", "Error al realizar la consulta en la base de datos");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (usuario == null) {
            response.put("Mensaje", "El usuario " + id + " no fue encontrado");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
    }

    @PostMapping("/usuario")
    public ResponseEntity<?> save(@RequestBody Usuario nuevo) {
        Usuario usuario = null;
        Map<String, Object> response = new HashMap<>();

        try {
            usuario = usuario_service.save(nuevo);
            response.put("Mensaje", "Usuario registrado con exito");
        } catch (DataAccessException e) {
            response.put("Mensaje", "Error al registrar en la base de datos");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(usuario, HttpStatus.CREATED);
    }

    @PutMapping("/usuario/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Usuario data) {
        Usuario actual = usuario_service.findById(id);
        Map<String, Object> response = new HashMap<>();

        if (actual == null) {
            response.put("Mensaje", "El usuario " + id + " no fue encontrado");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        try {
            actual.setRol(data.getRol());
            actual.setNombre(data.getNombre());
            actual.setActivo(data.getActivo());
            actual.setCorreo(data.getCorreo());
            usuario_service.save(actual);
        } catch (DataAccessException e) {
            response.put("Mensaje", "Error al buscar usuario");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(actual, HttpStatus.CREATED);
    }

    @DeleteMapping("usuario/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Map<String, Object> response = new HashMap<>();

        try {
            usuario_service.delete(id);
            response.put("Mensaje", "Usuario eliminado con exito");
        } catch (DataAccessException e) {
            response.put("Mensaje", "Error al eliminar usuario");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }
}
