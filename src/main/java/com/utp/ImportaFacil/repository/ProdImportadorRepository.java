package com.utp.ImportaFacil.repository;

import com.utp.ImportaFacil.model.ProdImportador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdImportadorRepository extends JpaRepository<ProdImportador, Long> {
}
