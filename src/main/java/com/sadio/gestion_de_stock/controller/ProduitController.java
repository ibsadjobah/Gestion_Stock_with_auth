package com.sadio.gestion_de_stock.controller;

import com.sadio.gestion_de_stock.httpResponse.HttpResponse;
import com.sadio.gestion_de_stock.model.Produit;
import com.sadio.gestion_de_stock.model.dto.ProduitDto;
import com.sadio.gestion_de_stock.serivice.ProduitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/produits")
@RequiredArgsConstructor
public class ProduitController {

    private final ProduitService produitService;

    @PostMapping
    public ResponseEntity<HttpResponse> create(@RequestBody ProduitDto produitDto){

      ProduitDto dto = ProduitDto.fromEntity(produitService.save(produitDto));
    //   return ResponseEntity.ok(produitService.Save(produitDto));


        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .code(HttpStatus.OK.value())
                        .localDateTime(LocalDateTime.now())
                        .message("Ajout de produits")
                        .data(Map.of("produits", dto))
                        .build()
        );

    }

    @GetMapping
    public ResponseEntity<HttpResponse> findAll(){

        List<ProduitDto> dtos = produitService.findAll();

        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .code(HttpStatus.OK.value())
                        .localDateTime(LocalDateTime.now())
                        .message("Ajout de produits")
                        .data(Map.of("produits", dtos))
                        .build()
        );
    }

    @DeleteMapping("/{produitId}")
    public ResponseEntity<HttpResponse> delete(@PathVariable("produitId") Long produitId){

         Produit produit = produitService.deletebyId(produitId);

         return ResponseEntity.ok().body(
                 HttpResponse.builder()
                         .code(HttpStatus.OK.value())
                         .localDateTime(LocalDateTime.now())
                         .message("suppression d'un produit")
                         .data(Map.of("Produit", produit))
                         .build()
         );
    }


}
