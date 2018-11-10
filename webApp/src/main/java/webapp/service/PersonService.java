package webapp.service;

import java.net.URI;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import webapp.controller.entity.Person;

@Service
public class PersonService {

	public Person getPerson(String userId) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			URI uri = new URI("http://localhost:8081/api/persons/" + userId);
			Person person = restTemplate.getForObject(uri, Person.class);
			return person;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
