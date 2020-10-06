package com.springboot;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CarService {
	
	@Autowired
	private CarRepository carRepository;
	
	public List<Car> getAvaliableCars(){
		List <Car> cars = new ArrayList<>();
		carRepository.findByisRented(false).forEach(cars::add);
		return cars;
	}
	
	public String rent(Integer id, Car car){
		
		Optional<Car> rentedCar= carRepository.findById(id);

		if (!rentedCar.isPresent())
			return "Car not found";
		
		
		rentedCar.get().setIsRented(true);
		rentedCar.get().setCustomerFName(car.getCustomerFName());
		rentedCar.get().setCustomerLName(car.getCustomerLName());
		rentedCar.get().setCustomerPhone(car.getCustomerPhone());
		rentedCar.get().setPickupDate(car.getPickupDate());
		rentedCar.get().setReturnDate(car.getReturnDate());
		rentedCar.get().setCustomeraddress(car.getCustomeraddress());
		carRepository.save(rentedCar.get());
		return "Sucess";
	}
	
	public String release(Integer id){
		Optional<Car> car= carRepository.findById(id);
		
		if (!car.isPresent())
			return "Car not found";
		
		
		car.get().setIsRented(false);
		car.get().setCustomerFName(null);
		car.get().setCustomerLName(null);
		car.get().setCustomerPhone(null);
		car.get().setPickupDate(null);
		car.get().setReturnDate(null);
		car.get().setCustomeraddress(null);
		carRepository.save(car.get());

		return "Sucess";
	}

	
	public Car getCarById(Integer carid) {
		// TODO Auto-generated method stub
		return carRepository.findById(carid).get();
	}
	
	public void addCar(Car car) {
		car.setIsRented(false);
		carRepository.save(car);
	}
	
	
}
