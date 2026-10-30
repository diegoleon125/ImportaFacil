package com.utp.ImportaFacil.controller;

import com.utp.ImportaFacil.model.Usuario;
import com.utp.ImportaFacil.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/login")
    public String login(HttpSession session, Model model) {
        if (session.getAttribute("logged") != null) {
            return "redirect:/";
        }
        model.addAttribute("usuario", new Usuario());
        return "login"; 
    }

    @PostMapping("/login")
    public String procesarLogin(@RequestParam String correo, @RequestParam String password,
                                HttpSession session, Model model) {
        
        Optional<Usuario> usuarioOpt = usuarioService.buscarPorCorreo(correo);
        
        if (usuarioOpt.isEmpty()) {
            model.addAttribute("errorLogin", "El correo electrónico no está registrado.");
            model.addAttribute("usuario", new Usuario());
            return "login";
        }
        
        if (usuarioService.verificarCredenciales(correo, password)) {
            session.setAttribute("logged", usuarioOpt.get());
            return "redirect:/";
        } else {
            model.addAttribute("errorLogin", "Contraseña incorrecta. Inténtalo de nuevo.");
            model.addAttribute("usuario", new Usuario());
            return "login";
        }
    }

    @PostMapping("/registro")
    public String procesarRegistro(@Valid @ModelAttribute("usuario") Usuario usuario, 
                                   BindingResult result, Model model) {
        
        if (result.hasErrors()) {
             result.getFieldErrors().forEach(error -> {
                System.out.println("ERROR VALIDACIÓN -> Campo: '" + error.getField() + "' | Mensaje: " + error.getDefaultMessage());
            });
            model.addAttribute("errorRegistro", "Por favor, corrija los errores en el formulario.");
            return "login"; // Regresa a la vista manteniendo los mensajes de error en rojo
        }

        Optional<Usuario> correoExistente = usuarioService.buscarPorCorreo(usuario.getCorreo());
        if (correoExistente.isPresent()) {
            model.addAttribute("errorRegistro", "El correo electrónico ya se encuentra registrado.");
            return "login";
        }

        usuarioService.registrar(usuario);
        model.addAttribute("exitoRegistro", "Usuario registrado correctamente. Ahora puede iniciar sesión.");
        model.addAttribute("usuario", new Usuario());
        return "login";
    }
    
    @GetMapping("/registro/verificar-correo")
    @ResponseBody
    public boolean verificarCorreo(@RequestParam String correo) {
        return usuarioService.buscarPorCorreo(correo).isPresent();
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
