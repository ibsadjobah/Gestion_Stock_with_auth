package com.sadio.gestion_de_stock.handler;

import com.sadio.gestion_de_stock.httpResponse.HttpResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class AppExceptionHandler {


    @ExceptionHandler(ResourceAlreadyExistException.class)
    public ResponseEntity<HttpResponse> alreadyExistHandler(ResourceAlreadyExistException exception){

        HttpResponse httpResponse = HttpResponse.builder()
                .code(HttpStatus.CONFLICT.value())
                .localDateTime(LocalDateTime.now())
                .message(exception.getMessage())
                .build();
        return ResponseEntity.badRequest().body(httpResponse);

    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<HttpResponse> notFoundException(ResourceNotFoundException exception){

        HttpResponse httResponse = HttpResponse.builder()
                .code(HttpStatus.NOT_FOUND.value())
                .localDateTime(LocalDateTime.now())
                .message(exception.getMessage())
                .build();

        return ResponseEntity.badRequest().body(httResponse);
    }

    @ExceptionHandler(ResourceImpossibleException.class)
    public ResponseEntity<HttpResponse> impossibleAction(ResourceImpossibleException exception){

        HttpResponse httpResponse = HttpResponse.builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .localDateTime(LocalDateTime.now())
                .message(exception.getMessage())
                .build();

        return ResponseEntity.badRequest().body(httpResponse);
    }
}
