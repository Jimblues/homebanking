package com.example.homebanking.repository;

import com.example.homebanking.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface IClientRepository extends JpaRepository<Client,Long> {
}
