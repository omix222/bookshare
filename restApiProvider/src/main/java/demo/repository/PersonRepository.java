package demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import demo.entity.Person;

//@RepositoryRestResource(collectionResourceRel = "people", path = "people")
@Repository
public interface PersonRepository extends JpaRepository<Person, String> {
	
}