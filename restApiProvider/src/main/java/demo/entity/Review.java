package demo.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 本に関するレビュー情報に関するエンティティ.
 *
 */
@Entity	
public class Review {

	@Id
	private String id;

	private String bookId;
	private Long reviewerId;
	private String comment;
	private Date reviewDate;
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
	public Long getReviewerId() {
		return reviewerId;
	}
	public void setReviewerId(Long reviewerId) {
		this.reviewerId = reviewerId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}
	

}