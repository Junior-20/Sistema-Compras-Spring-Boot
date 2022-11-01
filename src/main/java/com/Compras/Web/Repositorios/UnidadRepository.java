package com.Compras.Web.Repositorios;

import com.Compras.Web.Entidadades.Marca;
import com.Compras.Web.Entidadades.Unidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UnidadRepository extends JpaRepository<Unidad,Long> {
    @Query("select l from Unidad l where"+
            " CONCAT(l.id,l.Descripcion,l.Estado)"
            + " like %?1% ")
    public List<Unidad> findAll(String keyWord);
}
