package demo.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.entity.Person;
import demo.service.PersonService;

@RestController
@RequestMapping("api/persons")
public class PersonRestController {

	@Autowired
	PersonService personService;
	
	@GetMapping(path = "/{id}")
	public Person getPerson(@PathVariable String id) {
		return personService.getPerson(id);
	}
	@GetMapping
	public List<Person> getPersons() {
		return personService.getPersons();
	}
}
