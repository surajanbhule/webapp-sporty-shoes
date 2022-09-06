package com.surajanbhule.entities;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="order")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long order_id;
	private Date order_date;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="user_id")
	private User user;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name="order_product", joinColumns = @JoinColumn(name="order_id"),inverseJoinColumns = @JoinColumn(name="product_id"))
	private List<Product> product_list;
	private Double total_amount;
	private String order_status;
	
	public Order() {}

	public Order(long order_id, Date order_date, User user, List<Product> product_list, Double total_amount,
			String order_status) {
		super();
		this.order_id = order_id;
		this.order_date = order_date;
		this.user = user;
		this.product_list = product_list;
		this.total_amount = total_amount;
		this.order_status = order_status;
	}

	public long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(long order_id) {
		this.order_id = order_id;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Product> getProduct_list() {
		return product_list;
	}

	public void setProduct_list(List<Product> product_list) {
		this.product_list = product_list;
	}

	public Double getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(Double total_amount) {
		this.total_amount = total_amount;
	}

	public String getOrder_status() {
		return order_status;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}
	
	
	
}
