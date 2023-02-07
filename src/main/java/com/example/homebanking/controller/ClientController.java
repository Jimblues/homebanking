package com.example.homebanking.controller;

import com.example.homebanking.dto.ClientDTO;
import com.example.homebanking.models.Account;
import com.example.homebanking.models.Client;
import com.example.homebanking.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/api")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/clients")
    public ResponseEntity<List<ClientDTO>> getClients(){
        return new ResponseEntity<List<ClientDTO>>((List<ClientDTO>) clientService.getClients().stream().map(client -> new ClientDTO(client)).collect(toList()), HttpStatus.OK);
    }
    @GetMapping("/clients/{id}")
    public ResponseEntity<ClientDTO> getClient(@PathVariable long id){
        return new ResponseEntity<ClientDTO>(new ClientDTO(clientService.getClientById(id)), HttpStatus.OK);
    }
    @GetMapping("/clientsAcc/{id}")
    public ResponseEntity<Set<Account>> lstAccounts(@PathVariable long id){
        Client c = clientService.getClientById(id);
        System.out.println(c.getAccounts());
        return new ResponseEntity<Set<Account>>(c.getAccounts(),HttpStatus.OK);
    }
    @PostMapping("/addClient")
    public ResponseEntity<?> saveClient(@RequestBody Client c){
        return new ResponseEntity<>(clientService.saveClient(c),HttpStatus.OK);
    }
}
