package com.Compras.Web.Controladores;
import com.Compras.Web.Entidadades.Proveedor;
import com.Compras.Web.Servicios.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProveedorController {
    @Autowired
    ProveedorService db;
    @GetMapping({"Proveedores"})
    public String ListarProveedores(Model model, @Param("keyWord") String KeyWord) {
        model.addAttribute("Proveedores", db.listarproveedor(KeyWord));
        model.addAttribute("KeyWork",KeyWord);
        return "Proveedores";
    }
    @GetMapping("/Proveedores/nuevo")
    public String RegistrarProveedor(Model modelo) {
        Proveedor pro = new Proveedor();
        modelo.addAttribute("pro",pro);
        return "Agregar_Proveedor";
    }
    @PostMapping("Proveedores")
    public String GuardarProveedores(@ModelAttribute("Proveedor") Proveedor proveedor) {
        db.guardarproveedor(proveedor);
        return "redirect:Proveedores";
    }
    @GetMapping("/Proveedores/editar/{id}")
    public String MostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("Proveedores", db.obtenerproveedorId(id));
        return "editar_Proveedor";
    }
    @PostMapping("/Proveedores/{id}")
    public String ActualizarProveedor(@PathVariable Long id, @ModelAttribute("Proveedor") Proveedor pro) {
        Proveedor Existente = db.obtenerproveedorId(id);
        Existente.setId(id);
        Existente.setCedula(pro.getCedula());
        Existente.setNombre(pro.getNombre());
        Existente.setEstado(pro.getEstado());
        db.actualizarproveedor(Existente);
        return "redirect:/Proveedores";
    }
    @GetMapping("/Proveedores/{id}")
    public String EliminarProveedor(@PathVariable Long id) {
        db.eliminarproveedor(id);
        return "redirect:/Proveedores";
    }
}
