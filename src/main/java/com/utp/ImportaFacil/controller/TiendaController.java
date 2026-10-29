package com.utp.ImportaFacil.controller;

import org.springframework.boot.webmvc.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TiendaController implements ErrorController {

    @GetMapping("/")
    public String inicio(Model model) {
        model.addAttribute("paginaActual", "inicio");
        return "inicio"; 
    }

    @GetMapping("/contacto")
    public String contacto(Model model) {
        model.addAttribute("paginaActual", "contacto");
        return "contacto"; 
    }
}
