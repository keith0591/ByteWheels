package com.bytemark.bytewheels.service;

import java.sql.Timestamp;
import java.util.List;

import com.bytemark.bytewheels.dto.RentalsDto;
import com.bytemark.bytewheels.entities.Cars;
import com.bytemark.bytewheels.entities.Rentals;

public interface CarService {
	
	List<Cars> getAllAvailableCars(Timestamp fromDate,Timestamp toDate);
	
	Rentals bookRentals(RentalsDto dto);

}
