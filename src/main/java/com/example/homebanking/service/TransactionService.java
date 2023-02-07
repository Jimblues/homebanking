package com.example.homebanking.service;

import com.example.homebanking.models.Transaction;
import com.example.homebanking.models.TransactionType;
import com.example.homebanking.repository.ITransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    @Autowired
    private ITransactionRepository transactionRepository;

    public Transaction getTransactionById(long id){
        return transactionRepository.findById(id).get();
    }
    public Transaction saveTransaction(Transaction transaction){
        return transactionRepository.save(transaction);
    }
}
