package medi.pro.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import jakarta.annotation.PostConstruct;
import medi.pro.api.services.DBServices;

@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired
	private DBServices dbServices;

	@PostConstruct
	public void testLibrary() {
		
	this.dbServices.dbService();
	}
}
