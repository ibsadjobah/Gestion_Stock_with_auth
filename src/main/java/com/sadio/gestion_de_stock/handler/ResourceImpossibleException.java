package com.sadio.gestion_de_stock.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ResourceImpossibleException extends RuntimeException{

    public ResourceImpossibleException (String message){super(message);}
}
