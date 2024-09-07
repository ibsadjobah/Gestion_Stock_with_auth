package com.sadio.gestion_de_stock.serivice;

import com.sadio.gestion_de_stock.model.User;
import com.sadio.gestion_de_stock.model.Validation;
import com.sadio.gestion_de_stock.repository.ValidationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Random;

import static java.time.temporal.ChronoUnit.MINUTES;

@Service
@AllArgsConstructor
public class ValidationService {

    private final ValidationRepository validationRepository;
    private final SendMailService sendMailService;
    /*public void enregistrement(User user){

        Validation validation =new Validation();
        validation.setUser(user);
        Instant creation = Instant.now();
        validation.setCreation(creation);
        Instant expiration = creation.plus(10, MINUTES);
        validation.setExpiration(expiration);

        Random random = new Random();
        int randomInteger = random.nextInt(999999);
        String code = String.format("%06d",randomInteger);

        validation.setCode(code);

        this.validationRepository.save(validation);
        this.sendMailService.sendCode(validation);
    }*/
}
