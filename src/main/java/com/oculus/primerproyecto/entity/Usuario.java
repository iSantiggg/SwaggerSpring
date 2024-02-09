package com.oculus.primerproyecto.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String usuario;
    @Column(nullable = false)
    private String pais;
    @Column(nullable = false)
    private String hobbie;
}
