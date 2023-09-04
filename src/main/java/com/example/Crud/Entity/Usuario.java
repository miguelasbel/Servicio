package com.example.Crud.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "tbl_usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "email", unique = true, nullable = false)
    private String correo;

    @Column(name = "fecha_creacion")
    private Date fechaCreacion;

    @Column(name = "fecha_actualizacion")
    private Date fechaActualizacion;

    @Column(name = "fecha_eliminacion")
    private Date fechaEliminacion;

    private Long indicador;
    private Boolean eliminado; // Nuevo campo para indicar si el registro está eliminado o no
}
