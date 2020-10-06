package com.springboot;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;



@Entity 
public class Car {
	//Car Info
	@Id
	@Column(name="CAR_ID")
	private Integer Id;
	@Column(name="CAR_MAKE")
	private String Make;
	@Column(name="CAR_MODEL")
	private String Model;
	@Column(name="CAR_PRICE")
	private Double Price;
	@Column(name="CAR_COLOR")
	private String Color;
	
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
	private String customeraddress;
	@Column(name="PICKUP_DATE")
	private Date pickupDate;
	@Column(name="RETURN_DATE")
	private Date returnDate;
	
	
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getMake() {
		return Make;
	}
	public void setMake(String make) {
		Make = make;
	}
	public String getModel() {
		return Model;
	}
	public void setModel(String model) {
		Model = model;
	}
	public Double getPrice() {
		return Price;
	}
	public void setPrice(Double price) {
		Price = price;
	}
	public String getColor() {
		return Color;
	}
	public void setColor(String color) {
		Color = color;
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
	public String getCustomeraddress() {
		return customeraddress;
	}
	public void setCustomeraddress(String customeraddress) {
		this.customeraddress = customeraddress;
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


	
}
