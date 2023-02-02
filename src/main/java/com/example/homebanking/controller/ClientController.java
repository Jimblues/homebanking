package com.example.homebanking.controller;

import com.example.homebanking.models.Client;
import com.example.homebanking.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/clients")
    public ResponseEntity<List<Client>> getClients(){
        return new ResponseEntity<List<Client>>(clientService.getClients(), HttpStatus.OK);
    }
    @PostMapping("/addClient")
    public ResponseEntity<?> saveClient(@RequestBody Client c){
        return new ResponseEntity<>(clientService.saveClient(c),HttpStatus.OK);
    }
}
