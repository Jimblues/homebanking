package com.example.homebanking.controller;

import com.example.homebanking.dto.AccountDTO;
import com.example.homebanking.models.Account;
import com.example.homebanking.repository.IAccountRepository;
import com.example.homebanking.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/api")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @RequestMapping("/accounts")
    public List<AccountDTO> getAccounts(){
        return accountService.getAccounts().stream().map(client -> new AccountDTO(client)).collect(toList());
    }
    @RequestMapping("/accounts/{id}")
    public AccountDTO getAccount(@PathVariable long id){
        return new AccountDTO(accountService.getAccountById(id));
    }

}
