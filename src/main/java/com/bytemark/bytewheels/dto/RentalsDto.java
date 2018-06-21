package com.bytemark.bytewheels.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class RentalsDto implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotBlank(message="Invalid fromDate")
	private String fromDate;
	
	@NotBlank(message="Invalid toDate")
	private String toDate;
	
	@Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$",message="Invalid Email")
	private String email;
	
	@NotNull(message="carId cannot be null")
	private Long carId;
	
	private Long carType;
	
	public Long getCarType() {
		return carType;
	}

	public void setCarType(Long carType) {
		this.carType = carType;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getCarId() {
		return carId;
	}

	public void setCarId(Long carId) {
		this.carId = carId;
	}
}
