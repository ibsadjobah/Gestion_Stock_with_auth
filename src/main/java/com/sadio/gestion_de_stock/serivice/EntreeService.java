package com.sadio.gestion_de_stock.serivice;

import com.sadio.gestion_de_stock.model.Entree;
import com.sadio.gestion_de_stock.model.dto.EntreeDto;

import java.util.List;

public interface EntreeService {

    Entree save(EntreeDto entreeDto);

    List<EntreeDto> findAll();

    Entree delete(Long entreeId);
}
