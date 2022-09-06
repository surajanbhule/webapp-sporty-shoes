package com.surajanbhule.repositories;

import org.springframework.data.repository.CrudRepository;

import com.surajanbhule.entities.Order;

public interface OrderRepository extends CrudRepository<Order, Long>{

}
