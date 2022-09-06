package com.surajanbhule.repositories;

import org.springframework.data.repository.CrudRepository;

import com.surajanbhule.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{

}
