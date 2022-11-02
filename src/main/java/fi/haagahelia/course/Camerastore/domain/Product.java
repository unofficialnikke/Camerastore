package fi.haagahelia.course.Camerastore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String brand;
	private String model;
	private String price;
	private String productNumber;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "conditionid")
	private Condition condition;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "statusid")
	private Status status;
	
	public Product() {}
	

	public Product(String brand, String model, String price, String productNumber, Condition condition, Status status) {
		super();
		this.brand = brand;
		this.model = model;
		this.price = price;
		this.productNumber = productNumber;
		this.condition = condition;
		this.status = status;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
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
		return "Product [id=" + id + ", brand=" + brand + ", model=" + model + ", price=" + price + ", productNumber="
				+ productNumber + ", condition=" + this.getCondition() + ", status=" + this.getStatus() + "]";
	} 
	else {
		return "Product [id=" + id + ", brand=" + brand + ", model=" + model + ", price=" + price + ", productNumber="
				+ productNumber + "]";
	}
	}
}
