package com.Compras.Web.Controladores;

import com.Compras.Web.Entidadades.Departamento;
import com.Compras.Web.Entidadades.Empleado;
import com.Compras.Web.Repositorios.DepartamentoRepository;
import com.Compras.Web.Servicios.EmpleadoServices;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.swing.*;
import java.util.List;

@Controller
public class EmpleadoController {
    @Autowired
   private DepartamentoRepository dp;
    @Autowired
    private EmpleadoServices db;
    @GetMapping({"Empleados"})
    public String ListarEmpleados(Model model, @Param("keyWord") String KeyWord) {
        model.addAttribute("Empleados", db.ListarEmpleados(KeyWord));
        model.addAttribute("KeyWork",KeyWord);
        return "Empleados";
    }
    @GetMapping("/Empleados/nuevo")
    public String RegistrarEmpleados(Model modelo) {
        Empleado emp = new Empleado();
        List<Departamento> Departamentolist = dp.findAll();
        modelo.addAttribute("emp", emp);
        modelo.addAttribute("Departamentolist", Departamentolist);
        return "Agregar_Empleado";
    }
    @PostMapping("Empleados")
    public String GuardarEmpleado(@ModelAttribute("Empleado") Empleado empleado) {
        db.GuardarEmpleado(empleado);
        return "redirect:Empleados";
    }
    @GetMapping("/Empleados/editar/{id}")
    public String MostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("Empleado", db.ObtenerEmpleadoId(id));
        List<Departamento> Departamentolist = dp.findAll();
        modelo.addAttribute("Departamentolist", Departamentolist);
        return "Editar_Empleado";
    }

    @PostMapping("/Empleados/{id}")
    public String ActualizarEmpleado(@PathVariable Long id, @ModelAttribute("Empleado") Empleado empleado, Model model) {
        Empleado Existente = db.ObtenerEmpleadoId(id);
        List<Departamento> Departamentolist = dp.findAll();
        Existente.setId(id);
        Existente.setCedula(empleado.getCedula());
        Existente.setNombre(empleado.getNombre());
        Existente.setEstado(empleado.getEstado());
        Existente.setDepartamento(empleado.getDepartamento());

        model.addAttribute("Departamentolist", Departamentolist);
        db.ActualizarEmpleado(Existente);
        return "redirect:/Empleados";
    }
    @GetMapping("/Empleados/{id}")
    public String EliminarEmpleado(@PathVariable Long id) {
        try{
            db.EliminarEmpleado(id);
           }
        catch(ConstraintViolationException e ){
            JOptionPane.showMessageDialog(null,"Datos Relacionados!!!!!", "Error",JOptionPane.ERROR_MESSAGE);
        }
        return "redirect:/Empleados";
    }

}
