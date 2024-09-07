package com.sadio.gestion_de_stock.controller;

import com.sadio.gestion_de_stock.model.Avis;
import com.sadio.gestion_de_stock.serivice.AvisService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/avis")
public class AvisController {

    private final AvisService avisService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void creer(@RequestBody Avis avis){

        this.avisService.creer(avis);
    }
}
