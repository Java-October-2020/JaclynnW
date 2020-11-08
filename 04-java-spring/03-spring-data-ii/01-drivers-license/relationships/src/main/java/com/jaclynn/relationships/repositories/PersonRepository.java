package com.jaclynn.relationships.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jaclynn.relationships.models.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
	List<Person> findAll();
	@Query(value="SELECT * FROM persons LEFT OUTER JOIN licenses ON persons.id = licenses.person_id WHERE licenses.id IS NULL", nativeQuery=true)
	List<Person> findByLicenseIdIsNull();

}
