package io.github.anantharajuc.sdjpa;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.anantharajuc.sdjpa.model.Person;
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
		
		log.info("personRepository.count() : "+ personRepository.count());		
		
		Person person;
		
		person = personRepository.getPersonByName("John Doe");
		
		log.info("John Doe person.getId() : "+ person.getId());	
		
		log.info("personRepository.existsByUsername(\"johndoe\") : "+ personRepository.existsByUsername("johndoe"));	
		
		Optional<Person> optionalPerson;
		
		optionalPerson = personRepository.findByUsernameOrEmailPrimary("johndoe", "johndoe@t-online.de");
		
		log.info("optionalPerson.isPresent() : "+ optionalPerson.isPresent());	
	}
}
