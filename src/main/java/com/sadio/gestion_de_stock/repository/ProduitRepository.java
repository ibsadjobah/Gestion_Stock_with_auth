package com.sadio.gestion_de_stock.repository;

import com.sadio.gestion_de_stock.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
    Optional<Produit> findByName(String name);
}
