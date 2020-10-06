package com.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;




@RestController
public class CarControllor {

	@Autowired
	private CarService carService;
	
	
	@GetMapping("/search")
	public List<Car> getAvaliableCars() {
		return carService.getAvaliableCars();
	}
	
	@PutMapping("/rent/{carid}")
	public String rent (@RequestBody Car car,@PathVariable Integer carid) {
		return carService.rent(carid,car);
	}
	
	@PutMapping("/release/{carid}")
	public String release(@PathVariable Integer carid) {
		return carService.release(carid);
	}
	
	
	@GetMapping("/search/{carid}")
	public Car getCarById(@PathVariable Integer carid) {
		return carService.getCarById(carid);
	}
	
	@PostMapping(value="/add")
	public void addTopic(@RequestBody Car car) {
		carService.addCar(car);
	}

	
}
