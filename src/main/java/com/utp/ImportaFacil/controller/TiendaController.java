package com.utp.ImportaFacil.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.webmvc.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;

import com.utp.ImportaFacil.model.Categoria;
import com.utp.ImportaFacil.model.Importador;
import com.utp.ImportaFacil.model.PerfilPremium;
import com.utp.ImportaFacil.model.ProdImportador;
import com.utp.ImportaFacil.model.Producto;
import com.utp.ImportaFacil.model.Usuario;
import com.utp.ImportaFacil.util.HexCrypter;

import jakarta.servlet.http.HttpSession;

@Controller
public class TiendaController implements ErrorController {

    //base de datos de prueba
    private static List<Usuario> dbUsuarios = new ArrayList<>();
    private static List<Importador> dbImportadores = new ArrayList<>();
    private static List<Categoria> dbCategorias = new ArrayList<>();
    private static List<Producto> dbProductos = new ArrayList<>();
    private static List<ProdImportador> dbProdImportadores = new ArrayList<>();

    static {
        String hashDiego = HexCrypter.encrypt("Dieg_025");
        String hashThirsa = HexCrypter.encrypt("Thirsa_18");
        String hashDana = HexCrypter.encrypt("Danae_26");

        // TABLA: USUARIO
        Usuario u1 = new Usuario(1L, "Diego León", "diegoleon6431@gmail.com", hashDiego, "987654321", "2026-08-22", null);
        PerfilPremium premiumThirsa = new PerfilPremium(2L, 100, "2026-10-06");
        Usuario u2 = new Usuario(2L, "Thirsa Alvarez", "thirsa18utp@gmail.com", hashThirsa, "999888777", "2026-09-14", premiumThirsa);
        PerfilPremium premiumDana = new PerfilPremium(3L, 200, "2026-10-07");
        Usuario u3 = new Usuario(3L, "Dana Quiñones", "dana@gmail.com", hashDana, "987654567", "2026-10-01", premiumDana);


        dbUsuarios.add(u1);
        dbUsuarios.add(u2);
        dbUsuarios.add(u3);

        // TABLA: IMPORTADOR
        dbImportadores.add(new Importador(1L, "Asia Import Perú S.A.C.", "ventas@asiaimport.pe", "+51999888777", "Av. Garcilaso de la Vega 1234, Lima", "Activo"));
        dbImportadores.add(new Importador(2L, "Logística Global del Pacífico", "contacto@loglobal.pe", "+51999111222", "Calle Los Pinos 456, San Isidro", "Activo"));
        dbImportadores.add(new Importador(3L, "Importaciones Hiraoka S.A.", "soporte@hiraoka.com.pe", "+5114113000", "Av. Abancay 483, Lima", "Activo"));
        dbImportadores.add(new Importador(4L, "MegaDistribuidora Lima", "info@megadistribuidora.pe", "+51988777666", "Jr. Cuzco 567, Cercado de Lima", "Activo"));
        dbImportadores.add(new Importador(5L, "Inversiones Alpa S.A.C.", "ventas@inversionesalpa.pe", "+51955444333", "Av. Larco 789, Miraflores", "Activo"));

        // TABLA: CATEGORIA
        dbCategorias.add(new Categoria(1L, "Tecnología", "#d5e6f3"));
        dbCategorias.add(new Categoria(2L, "Ropa y Accesorios", "#d2ece4"));
        dbCategorias.add(new Categoria(3L, "Hogar y Cocina", "#f5eed3"));
        dbCategorias.add(new Categoria(4L, "Belleza y Salud", "#e8dbfd"));
        dbCategorias.add(new Categoria(5L, "Juguetes", "#fadcd9"));

        // TABLA: PRODUCTO
        Producto p1 = new Producto(1L, dbCategorias.get(0), "Audífonos Inalámbricos SoundPro X1", "Audio de alta resolución con cancelación activa de ruido.", "/img/p1.webp");
        Producto p2 = new Producto(2L, dbCategorias.get(0), "Reloj Inteligente FitTrack Pro", "Smartwatch con monitoreo de frecuencia cardíaca y pasos.", "/img/p2.webp");
        Producto p3 = new Producto(3L, dbCategorias.get(2), "Olla Arrocera Digital ChefMax", "Olla arrocera inteligente con panel de control digital.", "/img/p3.webp");
        Producto p4 = new Producto(4L, dbCategorias.get(2), "Set de Ollas Antiadherentes 5 Piezas", "Juego de ollas de aluminio con revestimiento de alta resistencia.", "/img/p4.webp");
        Producto p5 = new Producto(5L, dbCategorias.get(1), "Casaca Impermeable Unisex", "Casaca térmica ligera y resistente al agua.", "/img/p5.webp");
        Producto p6 = new Producto(6L, dbCategorias.get(1), "Pack de 3 Polos Básicos Algodón", "Polos de algodón 100% peruano, disponibles en varias tallas.", "/img/p6.webp");

        dbProductos.add(p1);
        dbProductos.add(p2);
        dbProductos.add(p3);
        dbProductos.add(p4);
        dbProductos.add(p5);
        dbProductos.add(p6);

        // --- TABLA INTERMEDIA: PRODIMPORTADOR (Tus ofertas físicas cruzadas) ---
        dbProdImportadores.add(new ProdImportador(1L, dbImportadores.get(0), p1, 79.9, 50));
        dbProdImportadores.add(new ProdImportador(2L, dbImportadores.get(1), p1, 85.0, 20));
        dbProdImportadores.add(new ProdImportador(3L, dbImportadores.get(2), p1, 82.5, 15));
        
        dbProdImportadores.add(new ProdImportador(4L, dbImportadores.get(0), p2, 145.0, 30));
        dbProdImportadores.add(new ProdImportador(5L, dbImportadores.get(3), p2, 139.9, 100));
        dbProdImportadores.add(new ProdImportador(6L, dbImportadores.get(4), p2, 142.5, 45));
        
        dbProdImportadores.add(new ProdImportador(7L, dbImportadores.get(1), p3, 289.9, 12));
        dbProdImportadores.add(new ProdImportador(8L, dbImportadores.get(2), p3, 295.0, 40));
        dbProdImportadores.add(new ProdImportador(9L, dbImportadores.get(4), p3, 292.5, 18));
        
        dbProdImportadores.add(new ProdImportador(10L, dbImportadores.get(1), p4, 120.0, 25));
        dbProdImportadores.add(new ProdImportador(11L, dbImportadores.get(3), p4, 115.9, 60));
        
        dbProdImportadores.add(new ProdImportador(12L, dbImportadores.get(0), p5, 59.9, 80));
        dbProdImportadores.add(new ProdImportador(13L, dbImportadores.get(3), p5, 55.0, 200));
        
        dbProdImportadores.add(new ProdImportador(14L, dbImportadores.get(3), p6, 35.0, 150));
        dbProdImportadores.add(new ProdImportador(15L, dbImportadores.get(4), p6, 39.9, 90));
    }

    //Vistas publicas
    @GetMapping("/")
    public String inicio() {
        return "inicio"; 
    }

    @GetMapping("/contacto")
    public String contacto() {
        return "contacto"; 
    }

    //Vistas exclusivas de Invitado
    @GetMapping("/login")
    public String login(HttpSession session) {
        if (session.getAttribute("logged") != null){
            return "redirect:/";
        }
        return "login"; 
    }

    @PostMapping("/login")
    public String procesarLogin(@RequestParam String correo, @RequestParam String password,
        HttpSession session, Model model) {
        
        Usuario usuarioEncontrado = null;
        for (Usuario u : dbUsuarios) {
            if (u.getCorreo().equalsIgnoreCase(correo)) {
                usuarioEncontrado = u;
                break;
            }
        }
        if (usuarioEncontrado == null) {
            model.addAttribute("errorLogin", "El correo electrónico no está registrado.");
            return "login";
        }
        
        if (HexCrypter.checkMatch(password, usuarioEncontrado.getContraseña())) {
            session.setAttribute("logged", usuarioEncontrado);
            return "redirect:/";
        } else {
            model.addAttribute("errorLogin", "Contraseña incorrecta. Inténtalo de nuevo.");
            return "login";
        }
    }

    @PostMapping("/registro")
    public String procesarRegistro(@RequestParam String nombre, @RequestParam String correo,
        @RequestParam String password, RedirectAttributes redirectAttributes) {
        nombre = nombre.trim();
        correo = correo.trim();
        password = password.trim();

        if (nombre.isEmpty() || correo.isEmpty()) {
            redirectAttributes.addFlashAttribute("errorRegistro", "Los datos enviados no cumplen con los requisitos de seguridad.");
            return "redirect:/login?registrar=true";
        }

        for (Usuario u : dbUsuarios) {
            if (u.getCorreo().equalsIgnoreCase(correo)) {
                redirectAttributes.addFlashAttribute("errorRegistro", "El correo ya se encuentra registrado. Intenta con otro.");
                return "redirect:/login?registrar=true";
            }
        }

        String passwordCifrada = HexCrypter.encrypt(password);
        Long nuevoId = (long) (dbUsuarios.size() + 1);
        String fechaActual = java.time.LocalDate.now().toString();

        Usuario nuevoUsuario = new Usuario(nuevoId, nombre, correo, passwordCifrada, null, fechaActual, null);
        dbUsuarios.add(nuevoUsuario);
        
        return "redirect:/login?registrado=true"; 
    }
    
    @GetMapping("/registro/verificar-correo")
    @ResponseBody
    public boolean verificarCorreo(@RequestParam String correo) {
        for (Usuario u : dbUsuarios) {
            if (u.getCorreo().equalsIgnoreCase(correo.trim())) {
                return true;
            }
        }
        return false;
    }

    //Vistas exclusivas de User
    @GetMapping("/productos")
    public String productos(Model model, HttpSession session) {
        if (session.getAttribute("logged") == null){
            return "redirect:/login";
        }
        model.addAttribute("categorias",dbCategorias);
        model.addAttribute("listaRelaciones", dbProdImportadores);
        return "productos"; 
    }

    @GetMapping("/comparar")
    public String comparar(@RequestParam(required = false) Long id, Model model, HttpSession session) {
        if (session.getAttribute("logged") == null){
            return "redirect:/login";
        }
        if (id == null){
            model.addAttribute("productoSeleccionado",null);
            return "comparar";
        }

        Producto productoEncontrado = dbProductos.stream()
            .filter(p -> p.getIdProducto().equals(id)).findFirst().orElse(null);
        if (productoEncontrado == null){
            model.addAttribute("productoSeleccionado",null);
            return "comparar";
        }

        List<ProdImportador> ofertasDelProducto = new ArrayList<>();
        double precioMinimo = Double.MAX_VALUE;

        for (ProdImportador rel : dbProdImportadores){
            if (rel.getProducto().getIdProducto().equals(id)){
                ofertasDelProducto.add(rel);
                if (rel.getPrecio() < precioMinimo){
                    precioMinimo = rel.getPrecio();
                }
            }
        }

        model.addAttribute("productoSeleccionado", productoEncontrado);
        model.addAttribute("ofertas", ofertasDelProducto);
        model.addAttribute("precioMinimo", precioMinimo == Double.MAX_VALUE ? 0.0 : precioMinimo);
        
        return "comparar"; 
    }

    //Redirecciones
    @GetMapping("/logout")
    public  String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }

    @RequestMapping("/error")
    public String manejarError() {
        return "error404";
    }

    //Para visualizar el layout
    @GetMapping("/layout")
    public  String layout(){
        return "layout";
    }
}
