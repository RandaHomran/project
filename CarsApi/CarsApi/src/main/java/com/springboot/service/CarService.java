package com.springboot.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.exception.CarNotFoundException;
import com.springboot.model.Car;
import com.springboot.repository.CarRepository;

@Service
public class CarService {
	
	@Autowired
	private CarRepository carRepository;
	
	public List<Car> getAvaliableCars(){
		List <Car> cars = new ArrayList<>();
		carRepository.findByisRented(false).forEach(cars::add);
		return cars;
	}
	
	public Car rent(Integer id, Car car){
		Optional<Car> rentedCar= carRepository.findById(id);
		findCar(rentedCar);
		rentedCar.get().setIsRented(true);
		rentedCar.get().setCustomerFName(car.getCustomerFName());
		rentedCar.get().setCustomerLName(car.getCustomerLName());
		rentedCar.get().setCustomerPhone(car.getCustomerPhone());
		rentedCar.get().setPickupDate(car.getPickupDate());
		rentedCar.get().setReturnDate(car.getReturnDate());
		rentedCar.get().setCustomerAddress(car.getCustomerAddress());
		return carRepository.save(rentedCar.get());
	}
	
	public Car release(Integer id){
		Optional<Car> car= carRepository.findById(id);
		findCar(car);
		car.get().setIsRented(false);
		car.get().setCustomerFName(null);
		car.get().setCustomerLName(null);
		car.get().setCustomerPhone(null);
		car.get().setPickupDate(null);
		car.get().setReturnDate(null);
		car.get().setCustomerAddress(null);
		return carRepository.save(car.get());
	}
	
	public Car getCarById(Integer carid) {
		Optional<Car> car= carRepository.findById(carid);
		findCar(car);
		return carRepository.findById(carid).get();
	}
	
	public void findCar(Optional<Car> car) {
		if(!car.isPresent()) {
			throw new CarNotFoundException();
		}
	}
}
