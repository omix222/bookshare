package demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.entity.Person;
import demo.repository.PersonRepository;
@Service
public class PersonService {
	
	@Autowired
	PersonRepository repository;
	
	public Person getPerson(String id) {
		return repository.getOne(id);
	}
	
	public List<Person> getPersons(){
		return repository.findAll();
	}
	
	public Person addPerson(Person person) {
		repository.save(person);
		return repository.getOne(person.getId());
	}
	
	public Person updatePerson(Person person) {
		repository.save(person);
		return repository.getOne(person.getId());
	}
	public void deletePerson(String id) {
		repository.deleteById(id);
	}
}
