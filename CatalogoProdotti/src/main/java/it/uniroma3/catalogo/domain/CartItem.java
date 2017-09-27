package it.uniroma3.catalogo.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class CartItem implements Serializable{

	private static final long serialVersionUID = -4546941350577482213L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	
	@OneToOne
	private Product product;
	
	@ManyToOne
	private Cart cart;
	
	private int quantity;
	private BigDecimal totalPrice;

	public CartItem() {
	}

	public String getId() {
		return id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getTotalPrice() {
		this.updateTotalPrice();
		return totalPrice;
	}

	public void updateTotalPrice() {
		totalPrice = this.product.getUnitPrice().multiply(new BigDecimal(this.quantity));
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}





}
