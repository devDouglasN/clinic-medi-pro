package medi.pro.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import medi.pro.api.services.DBServices;

@Configuration
@Profile("dev")
public class DevConfig {

	@Autowired
	private DBServices system;

	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String value;

	@Bean
	public boolean dbService() {

		if (value.equals("create")) {
			this.system.dbService();
		}

		return false;
	}
}
