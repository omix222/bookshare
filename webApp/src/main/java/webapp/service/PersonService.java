package webapp.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import webapp.controller.entity.Person;

@Service
public class PersonService {

	@Value("http://localhost:8080/api/persons")
	public URI webRestApiProviderUrl;

	public Person getPerson(String userId) {
		try {
			RestTemplate restTemplate = new RestTemplate();
//			URI uri = new URI(webRestApiProviderUrl.getPath() + userId);
			URI uri = new URI("http://localhost:8080/api/persons/" + userId);
			Person person = restTemplate.getForObject(uri, Person.class);
			System.out.println(person.getId());
			return person;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
//	public void postBook(Book book) {
//		RestTemplate restTemplate = new RestTemplate();
//		Book resultBook =restTemplate.postForObject(webRestApiProviderUrl, book, Book.class);
//		if (resultBook == null ) {
//			throw new RuntimeException("resultBook is null!!!");
//		}
//	}
}
