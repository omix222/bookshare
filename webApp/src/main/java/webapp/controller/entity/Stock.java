package webapp.controller.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
/**
 * 管理対象に関するエンティティ.
 *
 */
@Entity	
public class Stock {

	@Id
	private String id;
	private String targetId;
	private String place;
	private String lentalUserName;
	private String status;
	public  Stock() {
		super();
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getTargetId() {
		return targetId;
	}

	public void setTargetId(String targetId) {
		this.targetId = targetId;
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