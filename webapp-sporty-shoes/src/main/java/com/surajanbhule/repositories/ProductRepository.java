package com.surajanbhule.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.surajanbhule.entities.Category;
import com.surajanbhule.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{
	
	public List<Product> findProductsByCategory(Category category);
}
