package com.Compras.Web.Entidadades;

import javax.persistence.*;

@Entity
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Proveedor_id", unique = true)
    private Long id;
    @Column(name = "Cedula",nullable = false,length = 50)
    private String Cedula;
    @Column(name = "Nombre_Comercial",nullable = false,length = 50)
    private String Nombre;
    @Column(name = "Estado",nullable = false,length = 50)
    private String Estado;

    public Proveedor() {
    }

    public Proveedor(Long id, String cedula, String nombre, String estado) {
        this.id = id;
        Cedula = cedula;
        Nombre = nombre;
        Estado = estado;
    }
    public Proveedor(String cedula, String nombre, String estado) {
        Cedula = cedula;
        Nombre = nombre;
        Estado = estado;
    }
    public Proveedor(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String cedula) {
        Cedula = cedula;
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

    @Override
    public String toString() {
        return "Proveedor{" +
                "id=" + id +
                ", Cedula='" + Cedula + '\'' +
                ", Nombre='" + Nombre + '\'' +
                ", Estado='" + Estado + '\'' +
                '}';
    }
}
