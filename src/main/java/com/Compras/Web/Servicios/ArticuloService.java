package com.Compras.Web.Servicios;

import com.Compras.Web.Entidadades.Articulo;

import java.util.List;

public interface ArticuloService {
    public List<Articulo> listararticulo(String KeyWord);
    public Articulo guardararticulo(Articulo articulo);
    public Articulo obtenerarticuloId(Long id);
    public Articulo actualizarticulo(Articulo articulo);
    public void Eliminararticulo(Long id);
}
