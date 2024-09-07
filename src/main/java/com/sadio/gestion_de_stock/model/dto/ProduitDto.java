package com.sadio.gestion_de_stock.model.dto;

import com.sadio.gestion_de_stock.model.Category;
import com.sadio.gestion_de_stock.model.Produit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProduitDto {

    private Long id;

    private String name;

    private Long quantite;

    private Long categoryId;

    public static ProduitDto fromEntity(Produit produit){

        return ProduitDto.builder()
                .id(produit.getId())
                .name(produit.getName())
                .quantite(produit.getQuantite())
                .categoryId(produit.getCategory().getId())
                .build();
    }

    public static Produit toEntity(ProduitDto produitDto){

        return Produit.builder()
                .id(produitDto.getId())
                .name(produitDto.getName())
                .quantite(produitDto.getQuantite())
                .category(
                       Category.builder()
                               .id(produitDto.getCategoryId())
                               .build()
                )
                .build();
    }
}
