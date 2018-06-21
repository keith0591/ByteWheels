package com.bytemark.bytewheels.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bytemark.bytewheels.dto.BookingDto;
import com.bytemark.bytewheels.dto.RentalsDto;
import com.bytemark.bytewheels.entities.Cars;
import com.bytemark.bytewheels.entities.Rentals;
import com.bytemark.bytewheels.service.CarService;
import com.bytemark.bytewheels.util.ByteWheelsUtil;

@RestController
@RequestMapping("/api")
public class CarResource {
	
	
	private CarService service;
	
	@Autowired
	public CarResource(CarService service) {
		super();
		this.service = service;
	}

	@GetMapping("/")
	public ResponseEntity<?> getAvailableCars(@RequestParam(value="fromDate",required=true) String fromDate,@RequestParam(value="toDate",required=true)String toDate){
		List<Cars> availableCars = service
				.getAllAvailableCars(ByteWheelsUtil.toTimeStamp(fromDate), ByteWheelsUtil.toTimeStamp(toDate));
		return new ResponseEntity<>(availableCars,HttpStatus.OK);
	}
	
	@PostMapping("/book")
	public ResponseEntity<?> bookRentals(@Valid @RequestBody RentalsDto dto, BindingResult br ){
		if(br.hasErrors()){
			List<String> errorList = br.getFieldErrors().stream()
					.map(x->x.getDefaultMessage()).collect(Collectors.toList());
			return new ResponseEntity<>(errorList,HttpStatus.BAD_REQUEST);
		}
		Rentals retVal = service.bookRentals(dto);
		BookingDto bdto = new BookingDto();//Move this in to service
		bdto.setBookingId(retVal.getId());
		bdto.setCarName(retVal.getCar().getCarName());
		bdto.setEmailId(retVal.getEmailId());
		bdto.setTotalCharge(retVal.getTotalCost());
		return new ResponseEntity<>(bdto,HttpStatus.CREATED);
	}

}
