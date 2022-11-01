package com.Compras.Web.Repositorios;

import com.Compras.Web.Entidadades.Articulo;
import com.Compras.Web.Entidadades.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ArticuloRepository extends JpaRepository<Articulo,Long> {
    @Query("select l from Articulo l where"+
            " CONCAT(l.id,l.Descripcion,l.Estado,l.marca,l.unidad)"
            + " like %?1% ")
    public List<Articulo> findAll(String keyWord);
}
