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

import demo.entity.Review;
import demo.service.BookReviewService;
@RestController
@CrossOrigin
@RequestMapping("api/reviews")
public class BookReviewRestControler {
	@Autowired
	BookReviewService service;
	
	public BookReviewRestControler() {
		super();
	}

	@GetMapping
	List<Review> getReviews() {
		return service.getReviews();
	}

	@PostMapping
	Review postReview(@RequestBody Review newReview) {
		return service.addReview(newReview);
	}
	
	@DeleteMapping
	public void deleteReview(@PathVariable String id) {
		service.deleteReview(id);
	}
}
