package io.github.anantharajuc.sdjpa;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.anantharajuc.sdjpa.repositories.PersonRepository;
import lombok.extern.log4j.Log4j2;

@SpringBootApplication
@Log4j2
public class SpringDataJpaApplication implements CommandLineRunner
{
	@Autowired
	PersonRepository personRepository;
	
	public static void main(String[] args) 
	{
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception 
	{
		log.info("Application started at {}", LocalDateTime.now());	
	}
}
