package com.Compras.Web.Repositorios;

import com.Compras.Web.Entidadades.Departamento;
import com.Compras.Web.Entidadades.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmpleadoRepository extends JpaRepository<Empleado,Long> {
    @Query("select l from Empleado l where"+
            " CONCAT(l.id,l.Cedula,l.Nombre,l.departamento)"
            + " like %?1% ")
    public List<Empleado> findAll(String keyWord);
}
