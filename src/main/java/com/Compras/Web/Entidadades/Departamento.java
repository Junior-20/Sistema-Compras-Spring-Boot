package com.Compras.Web.Entidadades;

import javax.persistence.*;

@Entity
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Departamento_id", unique = true)
    private Long id;
    @Column(name = "Nombre",nullable = false,length = 50)
    private String Nombre;
    @Column(name = "Estado",nullable = false,length = 50)
    private String Estado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public Departamento(Long id, String nombre, String estado) {
        this.id = id;
        Nombre = nombre;
        Estado = estado;
    }

    public Departamento(String nombre, String estado) {
        Nombre = nombre;
        Estado = estado;
    }

    public Departamento() {
    }

    public Departamento(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "id=" + id +
                ", Nombre='" + Nombre + '\'' +
                ", Estado='" + Estado + '\'' +
                '}';
    }
}
