package com.sadio.gestion_de_stock.repository;

import com.sadio.gestion_de_stock.model.Sortie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SortieRepository extends JpaRepository<Sortie, Long> {

}
