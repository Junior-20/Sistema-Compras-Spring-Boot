package com.Compras.Web.Controladores;
import com.Compras.Web.Entidadades.Departamento;
import com.Compras.Web.Servicios.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
public class DepartamentoController {
    @Autowired
    private DepartamentoService db;
 
    @GetMapping({"Departamentos"})
    public String ListarDepartamentos(Model model, @Param("keyWord") String KeyWord) {
        model.addAttribute("Departamentos", db.listarDepartamentos(KeyWord));
        model.addAttribute("KeyWork",KeyWord);
        return "Departamentos";
    }

    @GetMapping("/Departamentos/nuevo")
    public String RegistrarDepartamento(Model modelo) {
        Departamento Dep = new Departamento();
        modelo.addAttribute("Dep", Dep);
        return "Formulario";
    }

    @PostMapping("Departamentos")
    public String GuardarDepartamento(@ModelAttribute("Departamento") Departamento departamento) {
        db.guardarDepartamento(departamento);
        return "redirect:Departamentos";
    }

    @GetMapping("/Departamentos/editar/{id}")
    public String MostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("Departamento", db.obtenerDepartamentoId(id));
        return "editar_Departamento";
    }

    @PostMapping("/Departamentos/{id}")
    public String ActualizarDepartamento(@PathVariable Long id, @ModelAttribute("Departamento") Departamento departamento) {
        Departamento Existente = db.obtenerDepartamentoId(id);
        Existente.setId(id);
        Existente.setNombre(departamento.getNombre());
        Existente.setEstado(departamento.getEstado());

        db.actualizarDepartamento(Existente);
        return "redirect:/Departamentos";
    }

    @GetMapping("/Departamentos/{id}")
    public String EliminarDepartamento(@PathVariable Long id) {
            db.eliminarDepartamento(id);
            return "redirect:/Departamentos";
    }
}

