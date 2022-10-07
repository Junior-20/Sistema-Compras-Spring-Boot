package com.Compras.Web.Entidadades;

import javax.persistence.*;
@Entity
public  class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Empleado_id", unique = true)
    private Long id;
    @Column(name = "Cedula",nullable = false,length = 50)
    private String Cedula;
    @Column(name = "Nombre",nullable = false,length = 50)
    private String Nombre;
    @ManyToOne()
    @JoinColumn(name = "Departamento_id")
    private Departamento departamento;
    @Column(name = "Estado",nullable = false,length = 50)
    private String Estado;

    public Empleado(Long id, String cedula, String nombre, Departamento departamento, String estado) {
        this.id = id;
        Cedula = cedula;
        Nombre = nombre;
        this.departamento = departamento;
        Estado = estado;
    }
    public Empleado(String cedula, String nombre, Departamento departamento, String estado) {
        Cedula = cedula;
        Nombre = nombre;
        this.departamento = departamento;
        Estado = estado;
    }

    public Empleado() {
    }

    public Empleado(Long id) {
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

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", Cedula='" + Cedula + '\'' +
                ", Nombre='" + Nombre + '\'' +
                ", departamento=" + departamento +
                ", Estado='" + Estado + '\'' +
                '}';
    }
}
