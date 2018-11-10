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
	
	@Value("http://localhost:8081/api/books")
	public URI webRestApiProviderUrl;
	
	@Autowired
	StockRepository rentalStatusRepository;
	
	public Stock getStock(String bookId) {
		return rentalStatusRepository.findById(bookId).get();
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
						stockForm.setLentalUserName(st.getLentalUserName());
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
	
	public Stock addStock(Book book) {
		Stock stock = new Stock();
		long bookCount = rentalStatusRepository.count();
		stock.setId(String.valueOf(bookCount +1));
		stock.setLentalUserName("");
		stock.setPlace("");
		stock.setTargetId(book.getId());
		stock.setStatus("free");
		rentalStatusRepository.save(stock);
		return rentalStatusRepository.findById(stock.getId()).get();
	}
	
	public void changeStatus(String id,String lentalUserName) {
		Stock stock = rentalStatusRepository.findById(id).get();
		
		//他の人に借りられている状態なら何もしない
		if (stock.getStatus().equals("rentaled")&&!(stock.getLentalUserName().equals(lentalUserName))) {
			return;
		}
		
		if (stock.getStatus().equals("free")) {
			stock.setLentalUserName(lentalUserName);
			stock.setStatus("rentaled");
		} else {
			stock.setLentalUserName("");
			stock.setStatus("free");			
		}
		rentalStatusRepository.save(stock);
	}
}
