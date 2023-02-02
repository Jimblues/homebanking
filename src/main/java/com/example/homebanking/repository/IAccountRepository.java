package com.example.homebanking.repository;

import com.example.homebanking.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource
public interface IAccountRepository extends JpaRepository<Account,Long> {
}
