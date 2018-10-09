package demo.entity;

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
	private Long ownerUserId;
	private Long lentalUserId;
	private String status;
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
	public Long getOwnerUserId() {
		return ownerUserId;
	}
	public void setOwnerUserId(Long ownerUserId) {
		this.ownerUserId = ownerUserId;
	}
	public Long getLentalUserId() {
		return lentalUserId;
	}
	public void setLentalUserId(Long lentalUserId) {
		this.lentalUserId = lentalUserId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	

}