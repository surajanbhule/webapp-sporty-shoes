package com.surajanbhule.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long product_id;
	private String product_name;
	private String product_description;
	private String category_name;
	private Double product_price;
	private int product_stock;
	private byte[] image1;
	private byte[] image2;
	private byte[] image3;
	private byte[] image4;
	
	public Product() {}

	

	public Product(long product_id, String product_name, String product_description, String category_name,
			Double product_price, int product_stock, byte[] image1, byte[] image2, byte[] image3, byte[] image4) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_description = product_description;
		this.category_name = category_name;
		this.product_price = product_price;
		this.product_stock = product_stock;
		this.image1 = image1;
		this.image2 = image2;
		this.image3 = image3;
		this.image4 = image4;
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

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public Double getProduct_price() {
		return product_price;
	}

	public void setProduct_price(Double product_price) {
		this.product_price = product_price;
	}

	public int getProduct_stock() {
		return product_stock;
	}

	public void setProduct_stock(int product_stock) {
		this.product_stock = product_stock;
	}



	public byte[] getImage1() {
		return image1;
	}



	public void setImage1(byte[] image1) {
		this.image1 = image1;
	}



	public byte[] getImage2() {
		return image2;
	}



	public void setImage2(byte[] image2) {
		this.image2 = image2;
	}



	public byte[] getImage3() {
		return image3;
	}



	public void setImage3(byte[] image3) {
		this.image3 = image3;
	}



	public byte[] getImage4() {
		return image4;
	}



	public void setImage4(byte[] image4) {
		this.image4 = image4;
	}
	
	
}
