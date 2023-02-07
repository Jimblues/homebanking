package com.example.homebanking;
import com.example.homebanking.models.Account;
import com.example.homebanking.models.Client;
import com.example.homebanking.models.Transaction;
import com.example.homebanking.models.TransactionType;
import com.example.homebanking.service.AccountService;
import com.example.homebanking.service.ClientService;
import com.example.homebanking.service.TransactionService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;

@SpringBootApplication
public class HomebankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomebankingApplication.class, args);
	}
	@Bean
	public CommandLineRunner initData(ClientService clientService, AccountService accountService, TransactionService transactionService) {
		return (args) -> {
			Client client1 = new Client("Melba","Morel","melba@mindhub.com");
			Client client2 = new Client("Facundo","Lopez","facundo@mindhub.com");

			Account account1 = new Account("VIN001", LocalDateTime.now(),5000,client1);
			Account account2 = new Account("VIN002",LocalDateTime.now().plusDays(1),7000,client1);
			Account account3 = new Account("VIN003",LocalDateTime.now(),6000,client2);

			Transaction transaction1 = new Transaction(TransactionType.DEBITO,500,"",LocalDateTime.now(),account1);
			Transaction transaction2 = new Transaction(TransactionType.DEBITO, 600, "",LocalDateTime.now(),account1);
			Transaction transaction3 = new Transaction(TransactionType.CREDITO,900,"",LocalDateTime.now(),account2);
			Transaction transaction4 = new Transaction(TransactionType.DEBITO,800,"",LocalDateTime.now(),account3);


			clientService.saveClient(client1);
			clientService.saveClient(client2);
			accountService.saveAccount(account1);
			accountService.saveAccount(account2);
			accountService.saveAccount(account3);
			transactionService.saveTransaction(transaction1);
			transactionService.saveTransaction(transaction2);
			transactionService.saveTransaction(transaction3);
			transactionService.saveTransaction(transaction4);
		};
	}

}
