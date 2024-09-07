package com.sadio.gestion_de_stock.repository;

import com.sadio.gestion_de_stock.model.Category;
import com.sadio.gestion_de_stock.model.dto.CategoryDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {



   void deleteById(Long categoryId);


    Optional<Category> findByName(String name);
}
