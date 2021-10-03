package com.example.task1.service;

import com.example.task1.entity.Client;
import com.example.task1.peliod.ApiResponce;
import com.example.task1.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;


    public ApiResponce add(Client client) {
        Client c = new Client();
        c.setName(client.getName());
        c.setPhineNummber(client.getPhineNummber());
        clientRepository.save(client);
        return new ApiResponce(true , c);

    }

    public ApiResponce edit(Integer id, Client client) {
        Optional<Client> byId = clientRepository.findById(id);

        if (!byId.isPresent()) return new ApiResponce(false , null);
        Client c = byId.get();
        c.setName(client.getName());
        c.setPhineNummber(client.getPhineNummber());
        clientRepository.save(client);
        return new ApiResponce(true , c);
    }


    public List<Client> clients(){
        List<Client> clientRepositoryAll = clientRepository.findAll();
        return clientRepositoryAll;
    }
}
