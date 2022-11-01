package com.Compras.Web.Repositorios;

import com.Compras.Web.Entidadades.Departamento;
import com.Compras.Web.Entidadades.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MarcaRepository extends JpaRepository<Marca,Long> {
    @Query("select l from Marca l where"+
            " CONCAT(l.id,l.Descripcion,l.Estado)"
            + " like %?1% ")
    public List<Marca> findAll(String keyWord);
}
