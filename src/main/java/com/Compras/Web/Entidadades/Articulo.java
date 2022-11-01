package com.Compras.Web.Entidadades;

import javax.persistence.*;

@Entity
public class Articulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Articulo_id", unique = true)
    private Long id;
    @Column(name = "Descripcion",nullable = false,length = 50)
    private String Descripcion;
    @ManyToOne()
    @JoinColumn(name = "Marca_id")
    private Marca marca;
    @ManyToOne()
    @JoinColumn(name = "Unidad_id")
    private Unidad unidad;
    @Column(name = "Existencia",nullable = false)
    private int Existencia;
    @Column(name = "Estado",nullable = false,length = 50)
    private String Estado;

    public Articulo() {
    }

    public Articulo(Long id, String descripcion, Marca marca, Unidad unidad, int existencia, String estado) {
        this.id = id;
        Descripcion = descripcion;
        this.marca = marca;
        this.unidad = unidad;
        Existencia = existencia;
        Estado = estado;
    }
    public Articulo(String descripcion, Marca marca, Unidad unidad, int existencia, String estado) {
        Descripcion = descripcion;
        this.marca = marca;
        this.unidad = unidad;
        Existencia = existencia;
        Estado = estado;
    }
    public Articulo(Long id) {
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

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Unidad getUnidad() {
        return unidad;
    }

    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
    }

    public int getExistencia() {
        return Existencia;
    }

    public void setExistencia(int existencia) {
        Existencia = existencia;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    @Override
    public String toString() {
        return "Articulo{" +
                "id=" + id +
                ", Descripcion='" + Descripcion + '\'' +
                ", marca=" + marca +
                ", unidad=" + unidad +
                ", Existencia=" + Existencia +
                ", Estado='" + Estado + '\'' +
                '}';
    }
}
