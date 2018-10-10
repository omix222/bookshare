package demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.entity.Book;
import demo.repository.BookRepository;
@Service
public class BookService {
	
	@Autowired
	BookRepository repository;
	
	public Book getBook(String id) {
		return repository.findById(id).get();
	}
	
	public List<Book> getBooks(){
		return repository.findAll();
	}
	
	public Book addBook(Book book) {
		repository.save(book);
		return repository.findById(book.getId()).get();
	}
	
	public Book updateBook(Book book) {
		repository.save(book);
		return repository.findById(book.getId()).get();
	}
	public void deleteBook(String id) {
		repository.deleteById(id);
	}
}
