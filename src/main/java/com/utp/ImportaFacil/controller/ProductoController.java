package com.utp.ImportaFacil.controller;

import com.utp.ImportaFacil.model.Producto;
import com.utp.ImportaFacil.model.ProdImportador;
import com.utp.ImportaFacil.service.ProductoService;
import com.utp.ImportaFacil.service.CategoriaService;
import com.utp.ImportaFacil.service.ProdImportadorService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class ProductoController {

    private final ProductoService productoService;
    private final CategoriaService categoriaService;
    private final ProdImportadorService prodImportadorService;

    public ProductoController(ProductoService productoService, 
                              CategoriaService categoriaService, 
                              ProdImportadorService prodImportadorService) {
        this.productoService = productoService;
        this.categoriaService = categoriaService;
        this.prodImportadorService = prodImportadorService;
    }

    @GetMapping("/productos")
    public String productos(Model model, HttpSession session) {
        if (session.getAttribute("logged") == null) {
            return "redirect:/login";
        }
        
        model.addAttribute("paginaActual", "productos");
        model.addAttribute("categorias", categoriaService.listarTodos());
        model.addAttribute("listaRelaciones", prodImportadorService.listarTodos());
        return "productos"; 
    }

    @GetMapping("/comparar")
    public String comparar(@RequestParam(required = false) Long id, Model model, HttpSession session) {
        if (session.getAttribute("logged") == null) {
            return "redirect:/login";
        }

        model.addAttribute("paginaActual", "comparar");

        if (id == null) {
            model.addAttribute("productoSeleccionado", null);
            return "comparar";
        }

        Optional<Producto> productoOpt = productoService.buscarPorId(id);
        if (productoOpt.isEmpty()) {
            model.addAttribute("productoSeleccionado", null);
            return "comparar";
        }

        Producto productoEncontrado = productoOpt.get();
        List<ProdImportador> todasLasRelaciones = prodImportadorService.listarTodos();
        List<ProdImportador> ofertasDelProducto = new ArrayList<>();
        double precioMinimo = Double.MAX_VALUE;

        for (ProdImportador rel : todasLasRelaciones) {
            if (rel.getProducto().getId().equals(id)) {
                ofertasDelProducto.add(rel);
                if (rel.getPrecio() < precioMinimo) {
                    precioMinimo = rel.getPrecio();
                }
            }
        }

        model.addAttribute("productoSeleccionado", productoEncontrado);
        model.addAttribute("ofertas", ofertasDelProducto);
        model.addAttribute("precioMinimo", precioMinimo == Double.MAX_VALUE ? 0.0 : precioMinimo);
        
        return "comparar"; 
    }
}
