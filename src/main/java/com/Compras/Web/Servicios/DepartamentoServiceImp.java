package com.Compras.Web.Servicios;

import com.Compras.Web.Entidadades.Departamento;
import com.Compras.Web.Repositorios.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Service
public class DepartamentoServiceImp implements  DepartamentoService {

    @Autowired
    DepartamentoRepository db;

    @Override
    public List<Departamento> listarDepartamentos(String keyWord) {
        if(keyWord!=null){
            return db.findAll(keyWord);
        }
        return db.findAll();
    }

    @Override
    public Departamento guardarDepartamento(Departamento departamento) {
        return db.save(departamento);
    }

    @Override
    public Departamento obtenerDepartamentoId(Long id) {
        return db.findById(id).get();
    }

    @Override
    public Departamento actualizarDepartamento(Departamento departamento) {
        return db.save(departamento);
    }

    @Override
    public void eliminarDepartamento(Long id) {
  db.deleteById(id);
    }
}
