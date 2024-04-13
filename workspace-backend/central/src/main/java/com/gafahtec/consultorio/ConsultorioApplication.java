package com.gafahtec.consultorio;

import com.gafahtec.consultorio.service.impl.AuditorAwareImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class ConsultorioApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsultorioApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder passwordEnconder() {

		return new BCryptPasswordEncoder();
	}


	@Bean("auditorProvider")
	public AuditorAware<String> auditorProvider() {
		return new AuditorAwareImpl();
	}
}
