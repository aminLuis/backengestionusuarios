package com.backendgestionusuarios.backendgestionusuarios.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.backendgestionusuarios.backendgestionusuarios.models.Rol;
import com.backendgestionusuarios.backendgestionusuarios.services.IRol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Rol_controller {

    @Autowired
    private IRol rol_service;

    @GetMapping("/rol")
    public List<Rol> getRoles() {
        return rol_service.findAll();
    }

    @GetMapping("/rol/{id}")
    public ResponseEntity<?> getRol(@PathVariable Integer id) {
        Rol rol = null;
        Map<String, Object> response = new HashMap<>();

        try {
            rol = rol_service.findById(id);
        } catch (DataAccessException e) {
            response.put("Mensaje", "Error al realizar la consulta en la base de datos");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (rol == null) {
            response.put("Mensaje", "El rol " + id + " no fue encontrado");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Rol>(rol, HttpStatus.OK);
    }
}
