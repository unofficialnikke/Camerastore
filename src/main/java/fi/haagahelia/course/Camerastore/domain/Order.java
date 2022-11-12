package fi.haagahelia.course.Camerastore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="orderTable")
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String lastName;
	private String address;
	private String postNumber;
	private String town;
	
	public Order() {}

	public Order(String firstName, String lastName, String address, String postNumber, String town) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.postNumber = postNumber;
		this.town = town;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostNumber() {
		return postNumber;
	}

	public void setPostNumber(String postNumber) {
		this.postNumber = postNumber;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
				+ ", postNumber=" + postNumber + ", town=" + town + "]";
	}
	
}
