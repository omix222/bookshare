package demo.entity;

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
	
	

}