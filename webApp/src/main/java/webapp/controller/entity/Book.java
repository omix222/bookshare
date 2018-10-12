package webapp.controller.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 本に関するエンティティ.
 *
 */
@Entity	
public class Book {

	@Id
	private String id;

	private String title;
	private String author;
	private String tags;
	private String publisher;
	private String status;
	
	public Book() {
		super();
	}
	public Book(String id, String title, String author, String tags, String publisher, String status) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.tags = tags;
		this.publisher = publisher;
		this.status = status;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	

}