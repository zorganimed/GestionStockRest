package com.sid.ams;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sid.ams.entities.Provider;
import com.sid.ams.repositories.ProviderRepository;

@SpringBootApplication
public class GestionDeStockRestApplication implements CommandLineRunner{

	@Autowired
	private ProviderRepository providerRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(GestionDeStockRestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Provider p = new Provider("DELL", "USA", "dell@gmail.com");
		Provider p1 = new Provider("HP", "Korea", "hp@gmail.com");
		Provider p2 = new Provider("Lenovo", "Chine", "lenovo@gmail.com");
		providerRepository.save(p);
		providerRepository.save(p1);
		providerRepository.save(p2);
		
	}
	
	

}
