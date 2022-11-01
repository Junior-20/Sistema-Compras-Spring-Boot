package com.Compras.Web.Entidadades;

import javax.persistence.*;

@Entity
public class Marca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Marca_id", unique = true)
    private Long id;
    @Column(name = "Descripcion",nullable = false,length = 50)
    private String Descripcion;
    @Column(name = "Estado",nullable = false,length = 50)
    private String Estado;

    public Marca(Long id, String descripcion, String estado) {
        this.id = id;
        Descripcion = descripcion;
        Estado = estado;
    }
    public Marca() {
    }
    public Marca(String descripcion, String estado) {
        Descripcion = descripcion;
        Estado = estado;
    }
    public Marca(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    @Override
    public String toString() {
        return "Marca{" +
                "id=" + id +
                ", Descripcion='" + Descripcion + '\'' +
                ", Estado='" + Estado + '\'' +
                '}';
    }
}
