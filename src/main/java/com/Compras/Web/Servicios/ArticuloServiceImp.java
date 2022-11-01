package com.Compras.Web.Servicios;
import com.Compras.Web.Entidadades.Articulo;
import com.Compras.Web.Repositorios.ArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticuloServiceImp implements ArticuloService {
    @Autowired
    ArticuloRepository db;
    @Override
    public List<Articulo> listararticulo(String KeyWord) {
       if(KeyWord!=null){
           return db.findAll(KeyWord);
       }
       return db.findAll();
    }

    @Override
    public Articulo guardararticulo(Articulo articulo) {
        return db.save(articulo);
    }

    @Override
    public Articulo obtenerarticuloId(Long id) {
        return db.findById(id).get();
    }

    @Override
    public Articulo actualizarticulo(Articulo articulo) {
        return db.save(articulo);
    }

    @Override
    public void Eliminararticulo(Long id) {
     db.deleteById(id);
    }
}
