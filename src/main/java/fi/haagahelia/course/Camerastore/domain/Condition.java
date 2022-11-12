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
public class Condition {
	/*
	 * This is a entity class that the admin can select the condition
	 * of the product with
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long conditionId;
	private String name;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "condition")
	private List<Product> products;
	
	public Condition() {}

	public Condition(String name) {
		super();
		this.name = name;

	}

	public Long getConditionId() {
		return conditionId;
	}

	public void setConditionId(Long conditionId) {
		this.conditionId = conditionId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	@Override
	public String toString() {
		return "Condition [conditionId=" + conditionId + ", name=" + name + "]";
	}

	
}
