package com.surajanbhule.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="cart")
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cart_id;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name="cart_products",joinColumns = @JoinColumn(name="cart_id"),inverseJoinColumns = @JoinColumn(name="product_id"))
	private List<Product> cart_products_list;
	private double total_amount;
	
	public Cart() {
		// TODO Auto-generated constructor stub
	}

	public Cart(long cart_id, List<Product> cart_products_list, double total_amount) {
		super();
		this.cart_id = cart_id;
		this.cart_products_list = cart_products_list;
		this.total_amount = total_amount;
	}

	public long getCart_id() {
		return cart_id;
	}

	public void setCart_id(long cart_id) {
		this.cart_id = cart_id;
	}

	public List<Product> getCart_products_list() {
		return cart_products_list;
	}

	public void setCart_products_list(List<Product> cart_products_list) {
		this.cart_products_list = cart_products_list;
	}

	public double getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(double total_amount) {
		this.total_amount = total_amount;
	}
	
	
	
	
}
