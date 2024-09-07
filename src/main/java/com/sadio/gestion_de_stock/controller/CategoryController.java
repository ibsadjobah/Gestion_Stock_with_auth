
package com.sadio.gestion_de_stock.controller;

import com.sadio.gestion_de_stock.httpResponse.HttpResponse;
import com.sadio.gestion_de_stock.model.Category;
import com.sadio.gestion_de_stock.model.dto.CategoryDto;
import com.sadio.gestion_de_stock.serivice.CategoryService;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<HttpResponse> create(@RequestBody CategoryDto categoryDto){

        CategoryDto dto = CategoryDto.fromEntity(categoryService.saveCategory(categoryDto));

        return ResponseEntity.ok().body(
               HttpResponse.builder()
                       .code(HttpStatus.OK.value())
                       .localDateTime(LocalDateTime.now())
                       .message("Ajout de category")
                       .data(Map.of("Category", dto))
                       .build()
        );

    }

    @GetMapping
    public ResponseEntity<HttpResponse> findAll(){

        List<CategoryDto> categoryDto = categoryService.findAll();

        return ResponseEntity.ok().body(

                HttpResponse.builder()
                        .code(HttpStatus.OK.value())
                        .localDateTime(LocalDateTime.now())
                        .message("La liste des category")
                        .data(Map.of("Liste", categoryDto))
                        .build()
        );

    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<HttpResponse> delete(@PathVariable("categoryId") Long  categoryId){

        Category category = categoryService.deleteById(categoryId);

        return ResponseEntity.ok().body(

                HttpResponse.builder()
                        .code(HttpStatus.OK.value())
                        .localDateTime(LocalDateTime.now())
                        .message("Suppression d'une Category")
                        .data(Map.of("Category", category))
                        .build()
        );

    }

   /* @PutMapping("/{categoryId}")
    public ResponseEntity<HttpResponse> update(@RequestBody @PathVariable("categoryId") Long categoryId){



    }**/

}
