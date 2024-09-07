package com.sadio.gestion_de_stock.serivice;

import com.sadio.gestion_de_stock.model.Avis;
import com.sadio.gestion_de_stock.repository.AvisRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AvisService {

    private  final AvisRepository avisRepository;

    public void creer(Avis avis){
        this.avisRepository.save(avis);
    }
}
