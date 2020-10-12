package com.springboot.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;



@Entity 
public class Car {
	//Car Info
	@Id
	@Column(name="CAR_ID")
	private Integer id;
	@Column(name="CAR_MAKE")
	private String make;
	@Column(name="CAR_MODEL")
	private String model;
	//Rented or not
	@Column(name="IS_RENTED")
	private Boolean isRented;
	
	//rented data
	@Column(name="CUSOMER_FNAME")
	private String customerFName;
	@Column(name="CUSOMER_LNAME")
	private String customerLName;
	@Column(name="CUSOMER_PHONE")
	private String customerPhone;
	@Column(name="CUSOMER_ADDRESS")
	private String customerAddress;
	@Column(name="PICKUP_DATE")
	private Date pickupDate;
	@Column(name="RETURN_DATE")
	private Date returnDate;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Boolean getIsRented() {
		return isRented;
	}
	public void setIsRented(Boolean isRented) {
		this.isRented = isRented;
	}
	public String getCustomerFName() {
		return customerFName;
	}
	public void setCustomerFName(String customerFName) {
		this.customerFName = customerFName;
	}
	public String getCustomerLName() {
		return customerLName;
	}
	public void setCustomerLName(String customerLName) {
		this.customerLName = customerLName;
	}
	public String getCustomerPhone() {
		return customerPhone;
	}
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public Date getPickupDate() {
		return pickupDate;
	}
	public void setPickupDate(Date pickupDate) {
		this.pickupDate = pickupDate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	@Column(name="CAR_PRICE")
	private Double price;
	@Column(name="CAR_COLOR")
	private String color;
	

	

	
}
