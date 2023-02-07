package com.example.homebanking.repository;

import com.example.homebanking.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ITransactionRepository extends JpaRepository<Transaction,Long> {
}
