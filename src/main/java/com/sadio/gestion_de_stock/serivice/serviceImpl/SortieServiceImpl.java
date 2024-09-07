package com.sadio.gestion_de_stock.serivice.serviceImpl;

import com.sadio.gestion_de_stock.handler.ResourceAlreadyExistException;
import com.sadio.gestion_de_stock.handler.ResourceNotFoundException;
import com.sadio.gestion_de_stock.model.Sortie;
import com.sadio.gestion_de_stock.model.dto.SortieDto;
import com.sadio.gestion_de_stock.repository.SortieRepository;
import com.sadio.gestion_de_stock.serivice.ProduitService;
import com.sadio.gestion_de_stock.serivice.SortieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SortieServiceImpl implements SortieService {

    private final SortieRepository sortieRepository;
    private final ProduitService produitService;
    @Override
    public Sortie save(SortieDto sortieDto) {

        Sortie sortie = SortieDto.toEntity(sortieDto);

        sortieRepository.save(sortie);
        
        Long produitId = sortie.getProduit().getId();
        Long quantiteSortie = sortie.getQuantite();
        
        produitService.updateStockQuantitySortie( produitId, quantiteSortie);

        return sortie;
        
    }

    @Override
    public List<SortieDto> findAll() {

        return sortieRepository.findAll()
                .stream()
                .map(SortieDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public Sortie deleteById(Long sortieId) {

        Optional<Sortie> sortie = sortieRepository.findById(sortieId);
        if (sortie.isEmpty())
            throw new ResourceNotFoundException("SORTIE NOT FOUND");

        sortieRepository.deleteById(sortieId);
        return sortie.get();
    }
}
