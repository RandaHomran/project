package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Car;
import com.springboot.service.CarService;




@RestController
public class CarControllor {

	@Autowired
	private CarService carService;
	
	@GetMapping("/search")
	public ResponseEntity<List<Car>> getAvaliableCars() {
		return ResponseEntity.ok(carService.getAvaliableCars());
	}
	
	@PutMapping("/rent/{carid}")
	public ResponseEntity<Car> rent (@RequestBody Car car,@PathVariable Integer carid) {
		Car rentedCar=carService.rent(carid,car);
		if(rentedCar==null) {
		    return ResponseEntity.notFound().build();
		}
		else {
			return ResponseEntity.ok(rentedCar);
		}
	}
	
	@PutMapping("/release/{carid}")
	public ResponseEntity<Car> release(@PathVariable Integer carid) {
		Car car=carService.release(carid);
		if(car==null) {
		    return ResponseEntity.notFound().build();
		}
		else {
			return ResponseEntity.ok(car);
		}
	}
	
	@GetMapping("/search/{carid}")
	public ResponseEntity<Car> getCarById(@PathVariable Integer carid) {
		Car car=carService.getCarById(carid);
		if(car==null) {
		    return ResponseEntity.notFound().build();
		}
		else {
			return ResponseEntity.ok(car);
		}
	}
	
	@PostMapping(value="/add")
	public ResponseEntity<Car> addTopic(@RequestBody Car car) {
		return ResponseEntity.ok(carService.addCar(car));
	}

	
}
