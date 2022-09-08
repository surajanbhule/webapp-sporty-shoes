package com.surajanbhule.repositories;

import org.springframework.data.repository.CrudRepository;

import com.surajanbhule.entities.Category;

public interface CategoryRepository extends CrudRepository<Category, Long>{
	
	
}
