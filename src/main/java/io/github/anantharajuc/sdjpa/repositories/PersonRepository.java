package io.github.anantharajuc.sdjpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.anantharajuc.sdjpa.model.Person;

/**
 * Repository class for <code>Person</code> domain object. 
 * 
 * @author <a href="mailto:arcswdev@gmail.com">Anantha Raju C</a>
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long>
{

}
