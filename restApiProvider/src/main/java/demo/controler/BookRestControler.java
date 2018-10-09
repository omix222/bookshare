package demo.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.entity.Book;
import demo.service.BookService;
@RestController
@CrossOrigin
@RequestMapping("api/books")
public class BookRestControler {
	@Autowired
	BookService bookService;
	
	public BookRestControler() {
		super();
	}

	@GetMapping
	public List<Book> getBooks() {
		return bookService.getBooks();
	}

	@GetMapping(path = "{id}")
	public Book getBook(@PathVariable String id) {
		return bookService.getBook(id);
	}
	
	@PostMapping
	public Book postBook(@RequestBody Book book) {
		return bookService.addBook(book);
	}
	
	@DeleteMapping
	public void deleteBook(@PathVariable String id) {
		bookService.deleteBook(id);
	}
}
