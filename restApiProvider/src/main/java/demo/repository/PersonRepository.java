package demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import demo.entity.Person;

//@RepositoryRestResource(collectionResourceRel = "people", path = "people")
//public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {
//
//	List<Person> findByLastName(@Param("name") String name);
//
//}

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
	
}