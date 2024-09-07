package com.sadio.gestion_de_stock.controller;

import com.sadio.gestion_de_stock.httpResponse.HttpResponse;
import com.sadio.gestion_de_stock.model.Entree;
import com.sadio.gestion_de_stock.model.dto.EntreeDto;
import com.sadio.gestion_de_stock.serivice.EntreeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/entrees")
@RequiredArgsConstructor
public class EntreeController {

    private final EntreeService entreeService;

    @PostMapping
    public ResponseEntity<HttpResponse> create(@RequestBody EntreeDto entreeDto){

        EntreeDto dto = EntreeDto.fromEntity(entreeService.save(entreeDto));

        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .code(HttpStatus.OK.value())
                        .localDateTime(LocalDateTime.now())
                        .message("Ajout des Entrees")
                        .data(Map.of("Les Entrees", dto))
                        .build()
        );
    }

    @GetMapping
    public ResponseEntity<HttpResponse> findAll(){

        List<EntreeDto> entreeDto = entreeService.findAll();

        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .code(HttpStatus.OK.value())
                        .message("La liste des entrées")
                        .localDateTime(LocalDateTime.now())
                        .data(Map.of("Les entrées", entreeDto))
                        .build()
        );
    }

    @DeleteMapping("/{entreeId}")
    public ResponseEntity<HttpResponse> delete(@PathVariable("entreeId") Long entreeId){

        Entree entree = entreeService.delete(entreeId);

        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .code(HttpStatus.OK.value())
                        .localDateTime(LocalDateTime.now())
                        .message("Suppression d'une entrée")
                        .data(Map.of("L'entrée ", entree ))
                        .build()
        );
    }
}
