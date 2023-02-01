package com.example.homebanking.service;

import com.example.homebanking.models.Client;
import com.example.homebanking.repository.IClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    private IClientRepository clientRepository;

    public List<Client> getClients(){
        return clientRepository.findAll();
    }

}
