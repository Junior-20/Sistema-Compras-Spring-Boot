package com.Compras.Web.Controladores;
import com.Compras.Web.Entidadades.*;
import com.Compras.Web.Repositorios.MarcaRepository;
import com.Compras.Web.Repositorios.UnidadRepository;
import com.Compras.Web.Servicios.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ArticuloController {
    @Autowired
   private UnidadRepository un;
    @Autowired
   private MarcaRepository mar;

    @Autowired
    private ArticuloService db;
    @GetMapping({"Articulos"})
    public String ListarArticulos(Model model, @Param("keyWord") String KeyWord) {
        model.addAttribute("Articulos", db.listararticulo(KeyWord));
        model.addAttribute("KeyWork",KeyWord);
        return "Articulos";
    }
    @GetMapping("/Articulos/nuevo")
    public String RegistrarArticulos(Model modelo) {
        Articulo art = new Articulo();
        List<Unidad> Unidadlist = un.findAll();
        List<Marca> Marcalist = mar.findAll();
        modelo.addAttribute("art", art);
        modelo.addAttribute("Unidadlist", Unidadlist);
        modelo.addAttribute("Marcalist", Marcalist);
        return "Agregar_Articulo";
    }
    @PostMapping("Articulos")
    public String GuardarArticulo(@ModelAttribute("Articulo") Articulo articulo) {
        db.guardararticulo(articulo);
        return "redirect:Articulos";
    }
    @GetMapping("/Articulos/editar/{id}")
    public String MostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("Articulo", db.obtenerarticuloId(id));
        List<Unidad> Unidadlist = un.findAll();
        List<Marca> Marcalist = mar.findAll();
        modelo.addAttribute("Unidadlist", Unidadlist);
        modelo.addAttribute("Marcalist", Marcalist);
        return "Editar_Articulo";
    }

    @PostMapping("/Articulos/{id}")
    public String ActualizarArticulo(@PathVariable Long id, @ModelAttribute("Articulo") Articulo articulo, Model model) {
        Articulo Existente = db.obtenerarticuloId(id);
        List<Unidad> Unidadlist = un.findAll();
        List<Marca> Marcalist = mar.findAll();
        Existente.setId(id);
        Existente.setDescripcion(articulo.getDescripcion());
        Existente.setMarca(articulo.getMarca());
        Existente.setUnidad(articulo.getUnidad());
        Existente.setExistencia(articulo.getExistencia());
        Existente.setEstado(articulo.getEstado());

        model.addAttribute("Unidadlist", Unidadlist);
        model.addAttribute("Marcalist", Marcalist);
        db.actualizarticulo(Existente);
        return "redirect:/Articulos";
    }
    @GetMapping("/Articulos/{id}")
    public String EliminarArticulos(@PathVariable Long id) {
        db.Eliminararticulo(id);
        return "redirect:/Articulos";
    }

}
