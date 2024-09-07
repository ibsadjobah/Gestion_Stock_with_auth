package com.sadio.gestion_de_stock.repository;

import com.sadio.gestion_de_stock.model.Avis;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvisRepository extends JpaRepository<Avis, Long> {
}
