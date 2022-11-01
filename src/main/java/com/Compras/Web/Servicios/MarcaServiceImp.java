package com.Compras.Web.Servicios;

import com.Compras.Web.Entidadades.Marca;
import com.Compras.Web.Repositorios.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MarcaServiceImp implements MarcaService{
    @Autowired
    MarcaRepository db;


    @Override
    public List<Marca> listarmarcas(String keyWord) {
        if(keyWord!=null){
            return db.findAll(keyWord);
        }
        return db.findAll();
    }

    @Override
    public Marca guardarmarca(Marca marca) {
        return db.save(marca);
    }

    @Override
    public Marca obtenermarcaId(Long id) {
        return db.findById(id).get();
    }

    @Override
    public Marca actualizarMarca(Marca marca) {
        return db.save(marca);
    }

    @Override
    public void eliminarmarca(Long id) {
     db.deleteById(id);
    }
}
