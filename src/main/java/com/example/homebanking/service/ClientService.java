package com.example.homebanking.service;

import com.example.homebanking.models.Client;
import com.example.homebanking.repository.IClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private IClientRepository clientRepository;

    public List<Client> getClients(){
        return clientRepository.findAll();
    }
    public Client saveClient(Client c){
        return clientRepository.save(c);
    }
    public Client getClientById(long id){
        return clientRepository.findById(id).orElse(null);
    }

}
