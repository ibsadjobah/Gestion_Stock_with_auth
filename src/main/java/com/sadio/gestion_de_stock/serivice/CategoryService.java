package com.sadio.gestion_de_stock.serivice;

import com.sadio.gestion_de_stock.model.Category;
import com.sadio.gestion_de_stock.model.dto.CategoryDto;

import java.util.List;


public interface CategoryService {
    Category saveCategory(CategoryDto categoryDto);

    List<CategoryDto> findAll();

    Category deleteById(Long categoryId);
}
