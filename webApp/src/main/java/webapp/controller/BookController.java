package webapp.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
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
	public String getStocks(Model model,@AuthenticationPrincipal UserDetails user) {
		model.addAttribute("name", user.getUsername());
		List<StockForm> resultList = null;
		resultList = stockService.getStocks();
		model.addAttribute("booklist", resultList);
		return "stocklist";
	}
	
	@GetMapping("/bookregist")
	public String getRegistView(Model model,@AuthenticationPrincipal UserDetails user) {
		model.addAttribute("name", user.getUsername());
		return "bookregist";
	}
	@PostMapping("/bookregist")
	public String postBook(@RequestParam("title") String title, 
			@RequestParam("author") String author,
			@RequestParam("tags") String tags,
			@RequestParam("publisher") String publisher,
			Model model) {
		Book book = new Book("",title,author,tags,publisher,"");
		book = bookService.postBook(book);
		stockService.addStock(book);
		return "redirect:stocklist";
	}
	@GetMapping(path = "/bookrental/{id}")
	public String rentalBook(@PathVariable String id,@AuthenticationPrincipal UserDetails user) {
		stockService.changeStatus(id,user.getUsername());
		return "redirect:/stocklist";
	}
	
}
