package com.example.Crud.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "tbl_sociedades")
public class Sociedad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "creationDate")
    private Date fecha_creación;

    @Column(name = "updateDate")
    private Date fecha_actualización;

    @Column(name = "deleteDate")
    private Date fecha_eliminación;

    private Long indicador;

    @ManyToOne
    @JoinColumn(name = "usuario_creador_id")
    private Usuario usuarioCreador;

    @ManyToOne
    @JoinColumn(name = "usuario_modificador_id")
    private Usuario usuarioModificador;
}
