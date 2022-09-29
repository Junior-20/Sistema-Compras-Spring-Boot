package com.Compras.Web.Servicios;

import com.Compras.Web.Entidadades.Departamento;

import java.util.List;

public interface DepartamentoService {

    public List<Departamento> listarDepartamentos( String keyWord);

    public Departamento guardarDepartamento(Departamento departamento);

    public Departamento obtenerDepartamentoId(Long id);

    public Departamento actualizarDepartamento(Departamento departamento);

    public void eliminarDepartamento(Long id);
}
