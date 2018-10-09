package demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.entity.Review;
import demo.repository.ReviewRepository;
@Service
public class BookReviewService {
	
	@Autowired
	ReviewRepository repository;
	
	
	public List<Review> getReviews(){
		return repository.findAll();
	}
	
	public Review addReview(Review review) {
		repository.save(review);
		return repository.getOne(review.getId());
	}
	
	public Review updateReview(Review review) {
		repository.save(review);
		return repository.getOne(review.getId());
	}
	public void deleteReview(String id) {
		repository.deleteById(id);
	}
}
