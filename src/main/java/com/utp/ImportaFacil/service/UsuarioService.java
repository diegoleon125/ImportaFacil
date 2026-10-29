package com.utp.ImportaFacil.service;

import com.utp.ImportaFacil.model.Usuario;
import com.utp.ImportaFacil.repository.UsuarioRepository;
import com.utp.ImportaFacil.util.HexCrypter;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public Usuario registrar(Usuario usuario) {
        String passwordEncriptada = HexCrypter.encrypt(usuario.getPassword());
        usuario.setPassword(passwordEncriptada);
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public Optional<Usuario> buscarPorCorreo(String correo) {
        return usuarioRepository.findByCorreo(correo);
    }

    public boolean verificarCredenciales(String correo, String passwordPlana) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByCorreo(correo);
        if (usuarioOpt.isPresent()) {
            return HexCrypter.checkMatch(passwordPlana, usuarioOpt.get().getPassword());
        }
        return false;
    }

    public void eliminar(Long id) {
        usuarioRepository.deleteById(id);
    }
}
