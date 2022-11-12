package fi.haagahelia.course.Camerastore.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Status {
	/*
	 * This is a entity class that the admin can select
	 * the status of the product with
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long statusId;
	private String name;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "status")
	private List<Product> products;
	
	public Status() {}
	
	public Status(String name) {
		super();
		this.name = name;
	}

	public Long getStatusId() {
		return statusId;
	}

	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Status [statusId=" + statusId + ", name=" + name + "]";
	}
	
}
