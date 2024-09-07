package com.sadio.gestion_de_stock.model.dto;

import com.sadio.gestion_de_stock.model.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDto {

    private Long id;
    private String name;

    public static Category toEntity(CategoryDto category){

        return Category.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }

    public static CategoryDto fromEntity(Category category){

        return CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }
}
