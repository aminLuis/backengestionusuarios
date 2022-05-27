package com.backendgestionusuarios.backendgestionusuarios.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "usuario")
@EntityListeners(AuditingEntityListener.class)
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer id_rol;

    @Column(nullable = false, unique = true)
    private String nombre;

    @Column(nullable = false)
    private char activo;

    @Column(nullable = false, unique = true)
    private String correo;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId_rol(Integer id_rol) {
        this.id_rol = id_rol;
    }

    public Integer getId_rol() {
        return id_rol;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setActivo(char activo) {
        this.activo = activo;
    }

    public char getActivo() {
        return activo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCorreo() {
        return correo;
    }

}
