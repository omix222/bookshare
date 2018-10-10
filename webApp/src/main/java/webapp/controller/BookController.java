package webapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import webapp.controller.entity.Book;
import webapp.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@RequestMapping("/booklist")
	public String getEmployeelist(Model model) {
		List<Book> resultList = null;
		resultList = bookService.getBook();
		model.addAttribute("booklist", resultList);
		return "booklist";
	}
	@GetMapping("/bookinput")
	public String getRegistView(Model model) {
		return "bookregist";
	}
	@PostMapping("/bookinput")
	public String postBook(@RequestParam("id") String id,
			@RequestParam("title") String title, 
			@RequestParam("author") String author,
			@RequestParam("tags") String tags,
			@RequestParam("publisher") String publisher,
			Model model) {
		Book book = new Book(id,title,author,tags,publisher);
		bookService.postBook(book);
		return "redirect:booklist";
	}
}
