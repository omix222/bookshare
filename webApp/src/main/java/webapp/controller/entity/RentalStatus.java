package webapp.controller.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
/**
 * 貸し出し情報に関するエンティティ.
 *
 */
@Entity	
public class RentalStatus {

	@Id
	private String id;
	private String bookId;
	private String lentalUserId;
	private String status;
	public  RentalStatus() {
		super();
	}
	public RentalStatus(String id, String bookId, String lentalUserId, String status) {
		super();
		this.id = id;
		this.bookId = bookId;
		this.lentalUserId = lentalUserId;
		this.status = status;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getLentalUserId() {
		return lentalUserId;
	}
	public void setLentalUserId(String lentalUserId) {
		this.lentalUserId = lentalUserId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	

}