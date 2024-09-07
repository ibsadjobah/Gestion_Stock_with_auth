package com.sadio.gestion_de_stock.repository;

import com.sadio.gestion_de_stock.model.Entree;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EntreeRepository extends JpaRepository<Entree, Long> {

}
