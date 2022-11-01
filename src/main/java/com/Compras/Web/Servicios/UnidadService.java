package com.Compras.Web.Servicios;

import com.Compras.Web.Entidadades.Marca;
import com.Compras.Web.Entidadades.Unidad;

import java.util.List;

public interface UnidadService {

    public List<Unidad> listarUnidad(String KeyWord);

    public Unidad guardarunidad(Unidad unidad);

    public Unidad obtenerunidadId(Long id);

    public Unidad actualizarunidad(Unidad unidad);

    public void eliminarunidad(Long id);
}
