package com.Compras.Web.Controladores;

import com.Compras.Web.Entidadades.Departamento;
import com.Compras.Web.Entidadades.Marca;
import com.Compras.Web.Servicios.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MarcaController {
    @Autowired
    MarcaService db;
    @GetMapping({"Marcas"})
    public String ListarMarcas(Model model, @Param("keyWord") String KeyWord) {
        model.addAttribute("Marcas", db.listarmarcas(KeyWord));
        model.addAttribute("KeyWork",KeyWord);
        return "Marcas";
    }
    @GetMapping("/Marcas/nuevo")
    public String RegistrarMarca(Model modelo) {
        Marca mar = new Marca();
        modelo.addAttribute("mar",mar);
        return "Agregar_Marcas";
    }
    @PostMapping("Marcas")
    public String GuardarMarca(@ModelAttribute("Marcas") Marca marca) {
        db.guardarmarca(marca);
        return "redirect:Marcas";
    }
    @GetMapping("/Marcas/editar/{id}")
    public String MostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("Marca", db.obtenermarcaId(id));
        return "editar_Marca";
    }
    @PostMapping("/Marcas/{id}")
    public String ActualizarMarca(@PathVariable Long id, @ModelAttribute("Marca") Marca mar) {
        Marca Existente = db.obtenermarcaId(id);
        Existente.setId(id);
        Existente.setDescripcion(mar.getDescripcion());
        Existente.setEstado(mar.getEstado());
        db.actualizarMarca(Existente);
        return "redirect:/Marcas";
    }
    @GetMapping("/Marcas/{id}")
    public String EliminarMarca(@PathVariable Long id) {
        db.eliminarmarca(id);
        return "redirect:/Marcas";
    }
}
