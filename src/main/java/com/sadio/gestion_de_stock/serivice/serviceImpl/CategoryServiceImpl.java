package com.sadio.gestion_de_stock.serivice.serviceImpl;

import com.sadio.gestion_de_stock.handler.ResourceAlreadyExistException;
import com.sadio.gestion_de_stock.handler.ResourceNotFoundException;
import com.sadio.gestion_de_stock.model.Category;
import com.sadio.gestion_de_stock.model.dto.CategoryDto;
import com.sadio.gestion_de_stock.repository.CategoryRepository;
import com.sadio.gestion_de_stock.serivice.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;


    @Override
    public Category saveCategory(CategoryDto categoryDto) {

        Category category = CategoryDto.toEntity(categoryDto);

        Optional<Category> optionalCategory = categoryRepository.findByName(category.getName());

        if(optionalCategory.isPresent())
            throw new ResourceAlreadyExistException("cette category existe déjà");

        return categoryRepository.save(category);

    }

    @Override
    public List<CategoryDto> findAll() {

        return categoryRepository.findAll()
                .stream()
                .map(CategoryDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public Category deleteById(Long categoryId) {

        Optional<Category> categoryDto = categoryRepository.findById(categoryId);
        if(categoryDto.isEmpty())
            throw new ResourceNotFoundException("Not Found");

        categoryRepository.deleteById(categoryId);

        return categoryDto.get();
    }


}
