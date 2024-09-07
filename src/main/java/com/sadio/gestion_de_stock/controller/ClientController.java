package com.sadio.gestion_de_stock.controller;

import com.sadio.gestion_de_stock.httpResponse.HttpResponse;
import com.sadio.gestion_de_stock.model.Client;
import com.sadio.gestion_de_stock.serivice.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @PostMapping
    public ResponseEntity<Client> create(@RequestBody Client client){

        Client client1 = clientService.save(client);

        return ResponseEntity.ok().body(client1);

    }

    @GetMapping()
    public ResponseEntity<List<Client>> findAll(){

        List<Client> client = clientService.findAll();

        return ResponseEntity.ok().body(client);
    }

    @GetMapping("{clientId}")
    public ResponseEntity<Client> show(@PathVariable("clientId") Long clientId){

        Client client = clientService.show(clientId);

        return ResponseEntity.ok().body(client);
    }

    @DeleteMapping("{clientId}")
    public ResponseEntity<Client> delete(@PathVariable("clientId") Long clientId){

        Client client  =  clientService.deleteById(clientId);

        return ResponseEntity.ok().body(client);
    }

    /**
    @PutMapping("{clientId}")
    public ResponseEntity<Client> update(@PathVariable("clientId") Long clientId, @RequestBody Client client){

        Client client1 = clientService.findById(clientId);



    }**/
}
