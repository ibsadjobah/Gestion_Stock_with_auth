package com.sadio.gestion_de_stock.repository;

import com.sadio.gestion_de_stock.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
