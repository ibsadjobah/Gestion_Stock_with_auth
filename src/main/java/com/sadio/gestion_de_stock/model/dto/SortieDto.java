package com.sadio.gestion_de_stock.model.dto;

import com.sadio.gestion_de_stock.model.Produit;
import com.sadio.gestion_de_stock.model.Sortie;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SortieDto {

    private Long id;
    private String name;
    private Long quantite;
    private Long produitId;

    public static SortieDto fromEntity(Sortie sortie){

        return SortieDto.builder()
                .id(sortie.getId())
                .name(sortie.getName())
                .quantite(sortie.getQuantite())
                .produitId(sortie.getProduit().getId())
                .build();
    }

    public static Sortie toEntity(SortieDto dto){

        return Sortie.builder()
                .id(dto.getId())
                .name(dto.getName())
                .quantite(dto.getQuantite())
                .produit(
                        Produit.builder()
                                .id(dto.getProduitId())
                                .build()
                )
                .build();
    }

}
