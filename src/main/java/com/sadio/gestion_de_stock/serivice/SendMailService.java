package com.sadio.gestion_de_stock.serivice;

import com.sadio.gestion_de_stock.model.Validation;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class SendMailService {

    JavaMailSender javaMailSender;

    /*public void sendCode(Validation validation){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("bahibrahimsadio@gmail.com");
        message.setTo(validation.getUser().getEmail());
        message.setSubject("Votre code d'activation");

        String texte = String.format(
                "Bonjour %s, votre code d'activation est %s; A bientot ",
                validation.getUser().getName(),
                validation.getCode()
        );
        message.setText(texte);

        javaMailSender.send(message);
    }*/

}
