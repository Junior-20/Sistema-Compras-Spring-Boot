package com.Compras.Web.Repositorios;

import com.Compras.Web.Entidadades.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento,Long> {
    @Query("select l from Departamento l where"+
            " CONCAT(l.id,l.Nombre,l.Estado)"
            + " like %?1% ")
    public List<Departamento> findAll(String keyWord);
}
