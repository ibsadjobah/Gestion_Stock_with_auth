package com.sadio.gestion_de_stock.controller;

import com.sadio.gestion_de_stock.httpResponse.HttpResponse;
import com.sadio.gestion_de_stock.model.dto.AuthenticationDto;
import com.sadio.gestion_de_stock.model.dto.UserDto;
import com.sadio.gestion_de_stock.serivice.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
//@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
@RequestMapping("api/v1/user/")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;

    //@PostMapping(path = "inscription")
    @PostMapping( "inscription")
    public ResponseEntity<HttpResponse> createUser(@RequestBody UserDto userDto){
        log.info("INSCRIPTION");
        UserDto user = UserDto.fromEntity(userService.save(userDto));

        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .code(HttpStatus.OK.value())
                        .localDateTime(LocalDateTime.now())
                        .message("Inscription d'un utilisateur")
                        .data(Map.of("data",user))
                        .build()
        );

    }

    //@PostMapping(path ="/auth")
    @PostMapping("connexion")
    //
    public Map<String, String> authUser(@RequestBody AuthenticationDto authenticationDto){

       final Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationDto.username(), authenticationDto.password())
        );

            log.info("resultat" + authenticate.isAuthenticated());
        return null;

    }

    //@GetMapping(path = "api/v1/user")
    @GetMapping( "list")
    public ResponseEntity<HttpResponse> findAll(){

        List<UserDto> userDto = userService.findAll();

        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .code(HttpStatus.OK.value())
                        .localDateTime(LocalDateTime.now())
                        .message("Ajout d'un user")
                        .data(Map.of("data",userDto))
                        .build()
        );

    }
}
