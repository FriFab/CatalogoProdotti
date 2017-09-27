package it.uniroma3.catalogo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String userID;
	
	private String name;
	private String address;
	private String password;
	private long noOfOrdersMade;
	
	@OneToOne
	private Cart cart;
	
	public User() {}
	
	public User(String name, String address, Cart cart) {
		this.name = name;
		this.address = address;
		this.noOfOrdersMade = 0;
		this.cart = new Cart(this);
		
	}
	
	public String getID() {
		return userID;
	}
	public void setID(String userID) {
		this.userID = userID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getNoOfOrdersMade() {
		return noOfOrdersMade;
	}
	public void setNoOfOrdersMade(long noOfOrdersMade) {
		this.noOfOrdersMade = noOfOrdersMade;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
