package com.springboot.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.springboot.model.Car;


public interface CarRepository extends CrudRepository<Car,Integer> {
	public List <Car> findByisRented(boolean isRented);
}
