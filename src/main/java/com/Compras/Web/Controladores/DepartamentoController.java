package com.Compras.Web.Controladores;

import com.Compras.Web.Entidadades.Departamento;
import com.Compras.Web.Servicios.DepartamentoService;
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

@Controller
public class DepartamentoController {
    @Autowired
    private DepartamentoService db;
 
    @GetMapping({"Departamentos","/"})
    public String listarDepartamentos(Model model, @Param("keyWord") String KeyWord) {
        model.addAttribute("Departamentos", db.listarDepartamentos(KeyWord));
        model.addAttribute("KeyWork",KeyWord);
        return "Departamentos";
    }

    @GetMapping("/Departamentos/nuevo")
    public String registrarCarro(Model modelo) {
        Departamento Dep = new Departamento();
        modelo.addAttribute("Dep", Dep);
        return "Formulario";
    }

    @PostMapping("Departamentos")
    public String guardarCarro(@ModelAttribute("Departamento") Departamento departamento) {
        db.guardarDepartamento(departamento);
        return "redirect:Departamentos";
    }

    @GetMapping("/Departamentos/editar/{id}")
    public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("Departamento", db.obtenerDepartamentoId(id));
        return "editar_Departamento";
    }

    @PostMapping("/Departamentos/{id}")
    public String actualizarDepartamento(@PathVariable Long id, @ModelAttribute("carro") Departamento departamento) {
        Departamento Existente = db.obtenerDepartamentoId(id);
        Existente.setId(id);
        Existente.setNombre(departamento.getNombre());
        Existente.setEstado(departamento.getEstado());

        db.actualizarDepartamento(Existente);
        return "redirect:/Departamentos";
    }

    @GetMapping("/Departamentos/{id}")
    public String eliminarDepartamento(@PathVariable Long id) {
        db.eliminarDepartamento(id);
        return "redirect:/Departamentos";
    }
}

