package com.utp.ImportaFacil.repository;

import com.utp.ImportaFacil.model.PerfilPremium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilPremiumRepository extends JpaRepository<PerfilPremium, Long> {
}
