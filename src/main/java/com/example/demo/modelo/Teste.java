package com.example.demo.modelo;

import jakarta.persistence.Entity;


import jakarta.persistence.*;

@Entity
@Table(name = "tb_teste")
public class Teste {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
