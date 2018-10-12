package webapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webapp.controller.entity.RentalStatus;
import webapp.repository.RentalStatusRepository;

@Service
public class RentalStatusService {
	
	@Autowired
	RentalStatusRepository repository;
	
	public RentalStatus getRentalStatus(String bookId) {
		return repository.findById(bookId).get();
	}
	
	public List<RentalStatus> getRentalStatus(){
		return repository.findAll();
	}
	
	public RentalStatus addRentalStatus(RentalStatus rentalStatus) {
		repository.save(rentalStatus);
		return repository.findById(rentalStatus.getId()).get();
	}
}
