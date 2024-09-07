package com.sadio.gestion_de_stock.model.dto;

import com.sadio.gestion_de_stock.model.Entree;
import com.sadio.gestion_de_stock.model.Produit;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EntreeDto {


    private Long id;

    private String name;

    private Long quantite;

    private Long produitId;

    public static EntreeDto fromEntity(Entree entree){

        return EntreeDto.builder()
                .id(entree.getId())
                .name(entree.getName())
                .quantite(entree.getQuantite())
                .produitId(entree.getProduit().getId())
                .build();
    }

    public static Entree toEntity(EntreeDto entreeDto){

        return Entree.builder()
                .id(entreeDto.getId())
                .name(entreeDto.getName())
                .quantite(entreeDto.getQuantite())
                .produit(
                        Produit.builder()
                                .id(entreeDto.getProduitId())
                                .build()
                )
                .build();
    }


}
