package com.example.homebanking;
import com.example.homebanking.models.Client;
import com.example.homebanking.service.ClientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HomebankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomebankingApplication.class, args);
	}
	@Bean
	public CommandLineRunner initData(ClientService repository) {
		return (args) -> {
			repository.saveClient(new Client("Melba","Morel","melba@mindhub.com"));
		};
	}

}
