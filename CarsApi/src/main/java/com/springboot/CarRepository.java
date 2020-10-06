package com.springboot;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface CarRepository extends CrudRepository<Car,Integer> {
	public List <Car> findByisRented(boolean isRented);
}
