package webapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import webapp.controller.entity.Book;

@Controller
public class BookController {
	@RequestMapping("/books")
	public String getEmployeelist(Model model) {
		List<Book> resultList = null;
		//TODO API呼び出しの形に以下ロジックを差し替える
		resultList= new ArrayList<Book>();
		resultList.add(new Book("id001","はじめてのSpringBoot","槇 俊明","Java,Spring","工学社"));
		//ここまで
		model.addAttribute("booklist", resultList);
		return "booklist";
	}
}
