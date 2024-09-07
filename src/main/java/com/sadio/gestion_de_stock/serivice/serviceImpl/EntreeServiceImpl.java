package com.sadio.gestion_de_stock.serivice.serviceImpl;

import com.sadio.gestion_de_stock.handler.ResourceAlreadyExistException;
import com.sadio.gestion_de_stock.handler.ResourceNotFoundException;
import com.sadio.gestion_de_stock.model.Entree;
import com.sadio.gestion_de_stock.model.dto.EntreeDto;
import com.sadio.gestion_de_stock.repository.EntreeRepository;
import com.sadio.gestion_de_stock.serivice.EntreeService;
import com.sadio.gestion_de_stock.serivice.ProduitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EntreeServiceImpl implements EntreeService {

    private final EntreeRepository entreeRepository;

    private final ProduitService produitService; 
    @Override
    public Entree save(EntreeDto entreeDto) {

        Entree entree = EntreeDto.toEntity(entreeDto);

        entreeRepository.save(entree);

        Long produitId = entree.getProduit().getId();
        Long quantiteEntree = entree.getQuantite();

        produitService.updateStockQuantity(produitId, quantiteEntree);

        return entree;
    }

    @Override
    public List<EntreeDto> findAll() {

        return entreeRepository.findAll()
                .stream()
                .map(EntreeDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public Entree delete(Long entreeId) {

        Optional<Entree> entree = entreeRepository.findById(entreeId);
        if (entree.isEmpty())
            throw new ResourceNotFoundException("ENTER NOT FOUND");

        entreeRepository.deleteById(entreeId);
        return entree.get();
    }
}
