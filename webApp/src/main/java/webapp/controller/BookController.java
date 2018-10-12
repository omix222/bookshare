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
import webapp.controller.entity.RentalStatus;
import webapp.service.BookService;
import webapp.service.RentalStatusService;

@Controller
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@Autowired
	RentalStatusService rentalStatusService;
	
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
		Book book = new Book(id,title,author,tags,publisher,"");
		bookService.postBook(book);
		return "redirect:booklist";
	}
	@GetMapping(path = "/bookrental/{id}")
	public String rentalBook(@PathVariable String id) {
		
		return "redirect:booklist";
	}
	@GetMapping(path = "/bookini")
	public String initialData() {
		RentalStatus status1 = new RentalStatus("1", "book001", "1", "rentaled");
		RentalStatus status2 = new RentalStatus("2", "book002", "1", "rentaled");
		RentalStatus status3 = new RentalStatus("3", "book003", "2", "free");
		RentalStatus status5 = new RentalStatus("5", "book005", "2", "free");
		
		rentalStatusService.addRentalStatus(status1);
		rentalStatusService.addRentalStatus(status2);
		rentalStatusService.addRentalStatus(status3);
		rentalStatusService.addRentalStatus(status5);
		return "redirect:booklist";
	}
	
}
