package com.surajanbhule.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long category_id;
	private String category_name;
	private String category_short_desc;
	
	public Category() {
		// TODO Auto-generated constructor stub
	}

	public Category(long category_id, String category_name, String category_short_desc) {
		super();
		this.category_id = category_id;
		this.category_name = category_name;
		this.category_short_desc = category_short_desc;
	}

	public long getCategory_id() {
		return category_id;
	}

	public void setCategory_id(long category_id) {
		this.category_id = category_id;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public String getCategory_short_desc() {
		return category_short_desc;
	}

	public void setCategory_short_desc(String category_short_desc) {
		this.category_short_desc = category_short_desc;
	}
	
	
}
