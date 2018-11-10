package webapp.service;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import webapp.controller.entity.Book;

@Service
public class BookService {

	@Value("http://localhost:8081/api/books")
	public URI webRestApiProviderUrl;
	
	public List<Book>getBooks() {
		RestTemplate restTemplate = new RestTemplate();
		Book[] book = restTemplate.getForObject(webRestApiProviderUrl, Book[].class);
		List<Book> books = Arrays.asList(book);
		return books;
	}

	public Book postBook(Book book) {
		RestTemplate restTemplate = new RestTemplate();
		Book resultBook =restTemplate.postForObject(webRestApiProviderUrl, book, Book.class);
		if (resultBook == null ) {
			throw new RuntimeException("resultBook is null!!!");
		}
		return resultBook;
	}
}
