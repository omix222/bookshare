package webapp.controller.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
/**
 * 管理対象に関するエンティティ.
 *
 */
@Entity	
public class StockForm {

	@Id
	private String id;
	private String targetName;
	private String author;
	private String tags;
	private String publisher;
	private String place;
	private String lentalUserName;
	private String status;
	public  StockForm() {
		super();
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getTargetName() {
		return targetName;
	}

	public void setTargetName(String targetName) {
		this.targetName = targetName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getLentalUserName() {
		return lentalUserName;
	}

	public void setLentalUserName(String lentalUserName) {
		this.lentalUserName = lentalUserName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	

}