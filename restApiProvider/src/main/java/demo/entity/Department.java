package demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 部署情報のエンティティ.
 */
@Entity
public class Department {
	@Id
	private String id;
	
	private String name;

	public Department() {
		super();
	}

	public Department(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
