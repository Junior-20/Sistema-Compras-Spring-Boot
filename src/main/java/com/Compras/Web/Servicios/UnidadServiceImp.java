package com.Compras.Web.Servicios;

import com.Compras.Web.Entidadades.Unidad;
import com.Compras.Web.Repositorios.UnidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnidadServiceImp implements UnidadService{
    @Autowired
    UnidadRepository db;

    @Override
    public List<Unidad> listarUnidad(String KeyWord) {
        if(KeyWord!=null){
            return db.findAll(KeyWord);
        }
        return db.findAll();
    }

    @Override
    public Unidad guardarunidad(Unidad unidad) {
        return db.save(unidad);
    }

    @Override
    public Unidad obtenerunidadId(Long id) {
        return db.findById(id).get();
    }

    @Override
    public Unidad actualizarunidad(Unidad unidad) {
        return db.save(unidad);
    }

    @Override
    public void eliminarunidad(Long id) {
     db.deleteById(id);
    }
}
