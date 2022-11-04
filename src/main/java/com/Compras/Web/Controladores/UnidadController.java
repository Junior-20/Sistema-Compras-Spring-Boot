package com.Compras.Web.Controladores;
import com.Compras.Web.Entidadades.Unidad;
import com.Compras.Web.Servicios.UnidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class UnidadController {
    @Autowired
    UnidadService db;
    @GetMapping({"Unidades"})
    public String ListarUnidades(Model model, @Param("keyWord") String KeyWord) {
        model.addAttribute("Unidades", db.listarUnidad(KeyWord));
        model.addAttribute("KeyWork",KeyWord);
        return "Unidades";
    }
    @GetMapping("/Unidades/nuevo")
    public String RegistrarUnidad(Model modelo) {
        Unidad uni = new Unidad();
        modelo.addAttribute("uni",uni);
        return "Agregar_Unidad";
    }
    @PostMapping("Unidades")
    public String GuardarUnidad(@ModelAttribute("Unidad") Unidad unidad) {
        db.guardarunidad(unidad);
        return "redirect:Unidades";
    }
    @GetMapping("/Unidades/editar/{id}")
    public String MostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("Unidad", db.obtenerunidadId(id));
        return "editar_Unidad";
    }
    @PostMapping("/Unidades/{id}")
    public String ActualizarUnidad(@PathVariable Long id, @ModelAttribute("Unidad") Unidad uni) {
        Unidad Existente = db.obtenerunidadId(id);
        Existente.setId(id);
        Existente.setDescripcion(uni.getDescripcion());
        Existente.setEstado(uni.getEstado());
        db.actualizarunidad(Existente);
        return "redirect:/Unidades";
    }
    @GetMapping("/Unidades/{id}")
    public String EliminarUnidad(@PathVariable Long id) {
        db.eliminarunidad(id);
        return "redirect:/Unidades";
    }
}
