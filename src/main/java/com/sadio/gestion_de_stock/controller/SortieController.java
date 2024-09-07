package com.sadio.gestion_de_stock.controller;

import com.sadio.gestion_de_stock.httpResponse.HttpResponse;
import com.sadio.gestion_de_stock.model.Sortie;
import com.sadio.gestion_de_stock.model.dto.SortieDto;
import com.sadio.gestion_de_stock.serivice.SortieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/sorties")
@RequiredArgsConstructor
public class SortieController {

    private final SortieService sortieService;

    @PostMapping
    public ResponseEntity<HttpResponse> create(@RequestBody SortieDto sortieDto){

        SortieDto dto = SortieDto.fromEntity(sortieService.save(sortieDto));

        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .code(HttpStatus.OK.value())
                        .message("Ajout des Sorties")
                        .localDateTime(LocalDateTime.now())
                        .data(Map.of("Sortie", dto))
                        .build()
        );
    }

    @GetMapping
    public ResponseEntity<HttpResponse> findAll(){

        List<SortieDto> sortieDtos = sortieService.findAll();

        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .code(HttpStatus.OK.value())
                        .message("La liste des sorties")
                        .localDateTime(LocalDateTime.now())
                        .data(Map.of("Les sorties", sortieDtos))
                        .build()
        );
    }

    @DeleteMapping("/{sortieId}")
    public ResponseEntity<HttpResponse> delete(@PathVariable("sortieId") Long sortieId){

        Sortie sortie = sortieService.deleteById(sortieId);

        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .code(HttpStatus.OK.value())
                        .message("Suppression d'une sortie")
                        .data(Map.of("La sortie", sortie))
                        .build()
        );
    }


}
