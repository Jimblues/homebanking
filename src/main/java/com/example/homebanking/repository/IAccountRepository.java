package com.example.homebanking.repository;

import com.example.homebanking.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccountRepository extends JpaRepository<Account,Integer> {
}
