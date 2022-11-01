package com.Compras.Web.Servicios;

import com.Compras.Web.Entidadades.Proveedor;
import com.Compras.Web.Repositorios.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorServiceImp implements ProveedorService{
    @Autowired
    ProveedorRepository db;
    @Override
    public List<Proveedor> listarproveedor(String KeyWord) {
        if(KeyWord!=null){
            return db.findAll(KeyWord);
        }
        return db.findAll();
    }

    @Override
    public Proveedor guardarproveedor(Proveedor proveedor) {
        return db.save(proveedor);
    }

    @Override
    public Proveedor obtenerproveedorId(Long id) {
        return db.findById(id).get();
    }

    @Override
    public Proveedor actualizarproveedor(Proveedor proveedor) {
        return db.save(proveedor);
    }

    @Override
    public void eliminarproveedor(Long id) {
     db.deleteById(id);
    }
}
