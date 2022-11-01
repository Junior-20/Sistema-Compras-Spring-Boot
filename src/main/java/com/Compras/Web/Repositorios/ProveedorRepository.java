package com.Compras.Web.Repositorios;

import com.Compras.Web.Entidadades.Marca;
import com.Compras.Web.Entidadades.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProveedorRepository extends JpaRepository<Proveedor,Long> {
    @Query("select l from Proveedor l where"+
            " CONCAT(l.id,l.Nombre,l.Estado,l.Cedula)"
            + " like %?1% ")
    public List<Proveedor> findAll(String keyWord);
}
