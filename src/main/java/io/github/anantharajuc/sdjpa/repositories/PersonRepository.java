package io.github.anantharajuc.sdjpa.repositories;

import java.util.Optional;

import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import io.github.anantharajuc.sdjpa.model.Person;

/**
 * Repository class for <code>Person</code> domain object. 
 * 
 * @author <a href="mailto:arcswdev@gmail.com">Anantha Raju C</a>
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long>
{
	/*
	 * Retrieve a {@link Person} from the data store by name.
	 * @param name the name to search for
	 * @return The {@link Person} if found
	 */
	@Query(value = "SELECT * FROM person WHERE name = :name",nativeQuery = true) 
	@Transactional(readOnly=true)
	Person getPersonByName(@Param("name") String name);
	
	/*
     * Retrieve a {@link Person} from the data store by username or email.
     * @param username the username to search for or
     * @param email the email to search for
     * @return the {@link Person} if found
     */
	@Transactional(readOnly = true)
	Optional<Person> findByUsernameOrEmailPrimary(String username, String email);
	
	@Transactional(readOnly = true)
	Boolean existsByUsername(@NotBlank String username);
}
