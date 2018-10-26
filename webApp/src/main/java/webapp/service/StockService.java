package webapp.service;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import webapp.controller.entity.Book;
import webapp.controller.entity.Stock;
import webapp.controller.entity.StockForm;
import webapp.repository.StockRepository;

@Service
public class StockService {
	
	@Value("http://localhost:8080/api/books")
	public URI webRestApiProviderUrl;
	
	@Autowired
	StockRepository rentalStatusRepository;
	
	@Autowired
	StockRepository repository;
	
	public Stock getStock(String bookId) {
		return repository.findById(bookId).get();
	}
	
	public List<StockForm> getStocks(){
			RestTemplate restTemplate = new RestTemplate();
			Book[] book = restTemplate.getForObject(webRestApiProviderUrl, Book[].class);
			List<Book> books = Arrays.asList(book);
			
			List<Stock> stocks = rentalStatusRepository.findAll(new Sort(Direction.ASC,"id"));

			List<StockForm> resultList = new ArrayList<StockForm>();
					
			for (Stock st : stocks) {
				StockForm stockForm = new StockForm();
				for (Book bo : books) {
					if (st.getTargetId().equals(bo.getId())) {
						stockForm.setId(st.getId());
						stockForm.setLentalUserId(st.getLentalUserId());
						stockForm.setPlace(st.getPlace());
						stockForm.setStatus(st.getStatus());
						stockForm.setTags(bo.getTags());
						stockForm.setAuthor(bo.getAuthor());
						stockForm.setPublisher(bo.getPublisher());
						
						stockForm.setTargetName(bo.getTitle());
						
						resultList.add(stockForm);
					}
				}
			}
			return resultList;
	}
	
	public Stock addStock(Stock stock) {
		repository.save(stock);
		return repository.findById(stock.getId()).get();
	}
	
	public void changeStatus(String id) {
		Stock stock = repository.findById(id).get();
		
		if (stock.getStatus().equals("free")) {
			stock.setStatus("rentaled");
		}else {
			stock.setStatus("free");			
		}
		repository.save(stock);
	}
}
