package com.Compras.Web.Servicios;

import com.Compras.Web.Entidadades.Departamento;
import com.Compras.Web.Entidadades.Empleado;
import com.Compras.Web.Repositorios.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.List;
@Service
public class EmpleadoServiceImp implements EmpleadoServices {

    @Autowired
    EmpleadoRepository db;

    @Override
    public List<Empleado> ListarEmpleados(String keyWord) {
        if(keyWord!=null){
            return db.findAll(keyWord);
        }
        return db.findAll();
    }

    @Override
    public Empleado GuardarEmpleado(Empleado empleado) {
        return db.save(empleado);
    }

    @Override
    public Empleado ObtenerEmpleadoId(Long id) {
        return db.findById(id).get();
    }

    @Override
    public Empleado ActualizarEmpleado(Empleado empleado) {
        return db.save(empleado);
    }

    @Override
    public void EliminarEmpleado(Long id) {
     db.deleteById(id);
    }
}
