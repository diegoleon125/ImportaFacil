package com.utp.ImportaFacil.service;

import com.utp.ImportaFacil.model.ProdImportador;
import com.utp.ImportaFacil.repository.ProdImportadorRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProdImportadorService {

    private final ProdImportadorRepository prodImportadorRepository;

    public ProdImportadorService(ProdImportadorRepository prodImportadorRepository) {
        this.prodImportadorRepository = prodImportadorRepository;
    }

    public List<ProdImportador> listarTodos() {
        return prodImportadorRepository.findAll();
    }
}
