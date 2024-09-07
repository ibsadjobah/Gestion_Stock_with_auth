package com.sadio.gestion_de_stock.serivice;

import com.sadio.gestion_de_stock.handler.ResourceNotFoundException;
import com.sadio.gestion_de_stock.model.Client;
import com.sadio.gestion_de_stock.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public Client save(Client client) {

        Client client1 = clientRepository.save(client);

        return client1;
    }

    public List<Client> findAll(){

       List<Client> client = clientRepository.findAll();

        return client;
    }

    public Client show(Long clientId){

        Optional<Client> client = clientRepository.findById(clientId);
        if (client.isEmpty())
            throw new ResourceNotFoundException("this client doesnt exist");

        return client.get();
    }

    public Client deleteById(Long clientId){

        Optional<Client> client  = clientRepository.findById(clientId);
        if (client.isEmpty())
            throw new ResourceNotFoundException("Impossible de supprimé ce client car il n'exist pas");

        return client.get();
    }
}
