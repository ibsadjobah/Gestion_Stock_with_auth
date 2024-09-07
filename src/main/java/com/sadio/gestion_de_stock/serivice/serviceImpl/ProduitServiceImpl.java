package com.sadio.gestion_de_stock.serivice.serviceImpl;

import com.sadio.gestion_de_stock.handler.ResourceAlreadyExistException;
import com.sadio.gestion_de_stock.handler.ResourceImpossibleException;
import com.sadio.gestion_de_stock.handler.ResourceNotFoundException;
import com.sadio.gestion_de_stock.model.Entree;
import com.sadio.gestion_de_stock.model.Produit;
import com.sadio.gestion_de_stock.model.dto.ProduitDto;
import com.sadio.gestion_de_stock.repository.EntreeRepository;
import com.sadio.gestion_de_stock.repository.ProduitRepository;
import com.sadio.gestion_de_stock.repository.SortieRepository;
import com.sadio.gestion_de_stock.serivice.ProduitService;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Data
@Builder
public class ProduitServiceImpl implements ProduitService {

    private final ProduitRepository produitRepository;
    private final EntreeRepository entreeRepository;
    private final SortieRepository sortieRepository;




    @Override
    public Produit save(ProduitDto produitDto) {

        Produit produit = ProduitDto.toEntity(produitDto);

        Optional<Produit> produitOptional = produitRepository.findByName(produit.getName());

        if(produitOptional.isPresent())
            throw new ResourceAlreadyExistException("THIS PRODUCT ALREADY EXIST");


        return produitRepository.save(produit);
    }

    @Override
    public void updateStockQuantity(Long produitId, Long quantiteEntree) {

        Produit produit = produitRepository.findById(produitId)
                .orElseThrow(() -> new RuntimeException("Produit non trouvé"));

        Long quantiteActuelle = produit.getQuantite();
        produit.setQuantite(quantiteActuelle + quantiteEntree);

        produitRepository.save(produit);
    }

    public void updateStockQuantitySortie(Long produitId, Long quantiteSortie) {

        Produit produit = produitRepository.findById(produitId)
                .orElseThrow(() -> new RuntimeException(" ce produit n'existe pas"));

        Long quantiteActuelle = produit.getQuantite();
        if (quantiteSortie > quantiteActuelle){
            throw new ResourceImpossibleException( " impossible d'effectuer cette sortie car la quantité en stock est insuffisante, votre stock est " + " NOM: " + produit.getName() + " STOCK: " + produit.getQuantite());
        }else

        {
            produit.setQuantite(quantiteActuelle - quantiteSortie);

        }

        produitRepository.save(produit);

    }

    @Override
    public Produit deletebyId(Long produitId) {

        Optional<Produit> produit = produitRepository.findById(produitId);

        if (produit.isEmpty())
            throw new ResourceNotFoundException("PRODUCT NOT FOUND");

        produitRepository.deleteById(produitId);
        return produit.get();
    }


    @Override
    public List<ProduitDto> findAll() {

        return produitRepository.findAll()
                .stream()
                .map(ProduitDto::fromEntity)
                .collect(Collectors.toList());


    }


}
