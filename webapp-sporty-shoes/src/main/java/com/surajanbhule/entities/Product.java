package com.surajanbhule.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long product_id;
	private String product_name;
	private String product_description;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="category_id")
	private Category category;
	private Double product_original_price;
	private int product_stock;
	private Double product_discount;
	private Double product_price;
	private String image1;
	private String image2;
	private String image3;
	private String image4;
	
	public Product() {}

	public Product(long product_id, String product_name, String product_description, Category category,
			 int product_stock, Double product_discount, Double product_price,
			String image1, String image2, String image3, String image4) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_description = product_description;
		this.category = category;
		this.product_stock = product_stock;
		this.product_discount = product_discount;
		this.product_price = product_price;
		this.image1 = image1;
		this.image2 = image2;
		this.image3 = image3;
		this.image4 = image4;
		this.product_original_price = product_price*( product_discount/100);
	}

	public long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(long product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_description() {
		return product_description;
	}

	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	

	public int getProduct_stock() {
		return product_stock;
	}

	public void setProduct_stock(int product_stock) {
		this.product_stock = product_stock;
	}

	public Double getProduct_discount() {
		return product_discount;
	}

	public void setProduct_discount(Double product_discount) {
		this.product_discount = product_discount;
	}

	public Double getProduct_price() {
		return product_price;
	}

	public void setProduct_price(Double product_price) {
		this.product_price = product_price;
	}

	public String getImage1() {
		return image1;
	}

	public void setImage1(String image1) {
		this.image1 = image1;
	}

	public String getImage2() {
		return image2;
	}

	public void setImage2(String image2) {
		this.image2 = image2;
	}

	public String getImage3() {
		return image3; 
	}

	public void setImage3(String image3) {
		this.image3 = image3;
	}

	public String getImage4() {
		return image4;
	}

	public void setImage4(String image4) {
		this.image4 = image4;
	}

	public Double getProduct_original_price() {
		return product_original_price;
	}

	public void setProduct_original_price(Double product_original_price) {
		this.product_original_price = product_original_price;
	}

	
	

	
	
	
}
