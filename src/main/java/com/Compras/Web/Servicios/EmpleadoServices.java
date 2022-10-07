package com.Compras.Web.Servicios;

import com.Compras.Web.Entidadades.Departamento;
import com.Compras.Web.Entidadades.Empleado;

import java.util.List;

public interface EmpleadoServices {
    public List<Empleado> ListarEmpleados(String keyWord);

    public Empleado GuardarEmpleado(Empleado empleado);

    public Empleado ObtenerEmpleadoId(Long id);

    public Empleado ActualizarEmpleado(Empleado empleado);

    public void EliminarEmpleado(Long id);
}
