package com.springboot.dto;

import java.sql.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;


public class CarDTO {

	@Min(value=1,message="id number can't be smaller than 1")
	private Integer id;
	
	
	private String model;

	
	@NotNull(message="First name can't be null")
    @Size(min = 3, max = 15, message="First name can't be null")
	private String customerFName;
	
	@NotNull(message="Last name can't be null")
    @Size(min = 3, max = 15)
	private String customerLName;
	
	@NotNull(message = "Phone number is required")
    @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$",
             message="Mobile number is invalid")
	private String customerPhone;
	
	private String customerAddress;
	
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Please provide a pickupDate.")
	private Date pickupDate;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Please provide a returnDate.")
	private Date returnDate;
	

	public CarDTO() {
	}

	public CarDTO(Integer id, String customerFName, String customerLName, String customerPhone, String customerAddress,
			Date pickupDate, Date returnDate) {
		super();
		this.id = id;
		this.customerFName = customerFName;
		this.customerLName = customerLName;
		this.customerPhone = customerPhone;
		this.customerAddress = customerAddress;
		this.pickupDate = pickupDate;
		this.returnDate = returnDate;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

}
