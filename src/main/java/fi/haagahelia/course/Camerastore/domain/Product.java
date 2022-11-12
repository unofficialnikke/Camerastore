package fi.haagahelia.course.Camerastore.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product {
	
	/*
	 * This is the Product entity class that saves the product details
	 * to the ProductRepository with.
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	private String price;
	private String productNumber;
	private String category;
	@Column(length = 2000)
	private String description;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "conditionid")
	private Condition condition;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "statusid")
	private Status status;
	
	public Product() {}
	
	public Product(String name, String price, String productNumber, String description, 
					String category, Condition condition, Status status) {
		super();
		this.name = name;
		this.price = price;
		this.productNumber = productNumber;
		this.category = category;
		this.description = description;
		this.condition = condition;
		this.status = status;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getProductNumber() {
		return productNumber;
	}
	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	public Condition getCondition() {
		return condition;
	}

	public void setCondition(Condition condition) {
		this.condition = condition;
	}
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
	if (this.condition != null || this.status != null) {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", productNumber="
				+ productNumber + ", description="+ description +  ", category=" + category +
				", condition=" + this.getCondition() + ", status=" + this.getStatus() + "]";
	} 
	else {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", productNumber="
				+ productNumber + ", description=" + description +  ", category=" + category + "]";
	}
	}
}
