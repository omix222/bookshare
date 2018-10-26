package webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import webapp.controller.entity.Book;
import webapp.controller.entity.StockForm;
import webapp.service.BookService;
import webapp.service.StockService;

@Controller
public class BookController {
	
	@Autowired
	BookService bookService;
	@Autowired
	StockService stockService;
	
	@Autowired
	StockService rentalStatusService;
	
	@RequestMapping("/stocklist")
	public String getStocks(Model model) {
		List<StockForm> resultList = null;
		resultList = stockService.getStocks();
		model.addAttribute("booklist", resultList);
		return "stocklist";
	}
	@RequestMapping("/booklist")
	public String getBooks(Model model) {
		List<Book> resultList = null;
		resultList = bookService.getBooks();
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
		Book book = new Book(id,title,author,tags,publisher,"");
		bookService.postBook(book);
		return "redirect:booklist";
	}
	@GetMapping(path = "/bookrental/{id}")
	public String rentalBook(@PathVariable String id) {
		stockService.changeStatus(id);
		return "redirect:/stocklist";
	}
	
}
