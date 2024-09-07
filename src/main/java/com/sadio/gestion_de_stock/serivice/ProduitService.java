package com.sadio.gestion_de_stock.serivice;

import com.sadio.gestion_de_stock.model.Produit;
import com.sadio.gestion_de_stock.model.dto.ProduitDto;

import java.util.List;

public interface ProduitService {


   // Long Save(ProduitDto produitDto);

    Produit save(ProduitDto produitDto);

    void updateStockQuantity(Long produitId, Long quantiteEntree);

    List<ProduitDto> findAll();

    void updateStockQuantitySortie(Long produitId, Long quantiteSortie);

    Produit deletebyId(Long produitId);
}
