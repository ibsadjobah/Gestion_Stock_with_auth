package com.sadio.gestion_de_stock.serivice;

import com.sadio.gestion_de_stock.model.Sortie;
import com.sadio.gestion_de_stock.model.dto.SortieDto;

import java.util.List;

public interface SortieService {
    Sortie save(SortieDto sortieDto);

    List<SortieDto> findAll();

    Sortie deleteById(Long sortieId);
}
