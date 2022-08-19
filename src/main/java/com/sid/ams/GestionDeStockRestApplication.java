package com.sid.ams;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.sid.ams.entities.Article;
import com.sid.ams.entities.Provider;
import com.sid.ams.repositories.ArticleRepository;
import com.sid.ams.repositories.ProviderRepository;

@SpringBootApplication
public class GestionDeStockRestApplication extends SpringBootServletInitializer implements CommandLineRunner{

	@Autowired
	private ProviderRepository providerRepository;
	@Autowired
	private ArticleRepository articleRepository;
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;

	
	public static void main(String[] args) {
		SpringApplication.run(GestionDeStockRestApplication.class, args);
	}

 
	
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Provider p = new Provider("DELL", "USA", "dell@gmail.com");
		Provider p1 = new Provider("HP", "Korea", "hp@gmail.com");
		Provider p2 = new Provider("Lenovo", "Chine", "lenovo@gmail.com");
		providerRepository.save(p);
		providerRepository.save(p1);
		providerRepository.save(p2);
		
		Article a; 
		for (Provider provider : providerRepository.findAll()) {
			a = new Article();
			System.out.println("provider.getName()"+provider.getName());
			if(provider.getName().equals("DELL")) {
			a.setProvider(p);
			a.setLabel("Dell I5");
			a.setPrice(3200);
			articleRepository.save(a);
			}else if(provider.getName().equals("HP")) {
				a.setProvider(p1);
				a.setLabel("HP Pavillon I5");
				a.setPrice(2850);
				articleRepository.save(a);
			}else {
				a.setProvider(p2);
				a.setLabel("Lenovo Idea Pad I7");
				a.setPrice(2650);
				articleRepository.save(a);
			}
		}
		
	}
	
	

}
