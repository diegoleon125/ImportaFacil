package com.utp.ImportaFacil.repository;

import com.utp.ImportaFacil.model.Importador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImportadorRepository extends JpaRepository<Importador, Long> {
}
