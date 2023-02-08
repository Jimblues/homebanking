package com.example.homebanking.service;

import com.example.homebanking.dto.AccountDTO;
import com.example.homebanking.models.Account;
import com.example.homebanking.repository.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    private IAccountRepository accountRepository;
    public Account saveAccount(Account acc){
        return accountRepository.save(acc);
    }
    public List<Account> getAccounts(){
        return accountRepository.findAll();
    }
    public AccountDTO getAccountById(long id){
        return accountRepository.findById(id).map(account->new AccountDTO(account)).orElse(null);
    }

}
