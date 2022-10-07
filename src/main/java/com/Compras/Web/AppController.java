package com.Compras.Web;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
    @GetMapping("Inicio")
    public String ListarDepartamentos() {
        return "Inicio";
    }
}
