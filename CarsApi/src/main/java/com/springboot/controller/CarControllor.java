package com.springboot.controller;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.dtos.CarDTO;
import com.springboot.exception.CarNotFoundException;
import com.springboot.model.Car;
import com.springboot.service.CarService;

@Validated 
@RestController
public class CarControllor {

	@Autowired
	private CarService carService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	 
	@GetMapping("/search")
	public ResponseEntity<List<CarDTO>> getAvaliableCars()  {
		return ResponseEntity.ok(carService.getAvaliableCars().stream().map(this::convertToDto).collect(Collectors.toList()));
	}
	
	
	@PutMapping("/rent/{carid}")
	public ResponseEntity<CarDTO> rent (@RequestBody @Valid  CarDTO carDto,@PathVariable Integer carid) throws CarNotFoundException  {
		Car car= convertToEntity(carDto);
		Car rentedCar=carService.rent(carid,car);
		return ResponseEntity.ok(convertToDto(rentedCar));
	}
	
	
	@PutMapping("/release/{carid}")
	public ResponseEntity<CarDTO> release (@PathVariable Integer carid) throws CarNotFoundException {
		Car car=carService.release(carid);
		return ResponseEntity.ok(convertToDto(car));
	}
	
	@GetMapping("/search/{carid}")
	public ResponseEntity<CarDTO> getCarById(@PathVariable Integer carid) throws CarNotFoundException  {
		Car car=carService.getCarById(carid);
		return ResponseEntity.ok(convertToDto(car));
	}
	

	
	private CarDTO convertToDto(Car car) {
		CarDTO carDto=modelMapper.map(car, CarDTO.class);
		return carDto;
	}
	
	
	private Car convertToEntity(CarDTO carDto) {
		Car car=modelMapper.map(carDto, Car.class);
		return car;
	}
	
	
}
