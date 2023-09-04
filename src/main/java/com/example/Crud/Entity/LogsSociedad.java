package com.example.Crud.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "tbl_logs_sociedad")
public class LogsSociedad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sociedad_id")
    private Sociedad sociedad;

    @ManyToOne
    @JoinColumn(name = "usuario_creador_id")
    private Usuario usuarioCreador;

    @Column(name = "creationDate")
    private Date fecha_creación;

    @Column(name = "descripcion")
    private String descripcion;
}
