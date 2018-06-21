package com.bytemark.bytewheels.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bytemark.bytewheels.entities.Cars;
import com.bytemark.bytewheels.repository.CarsRepository;

@Component
public class ByteWheelsUtil {

	CarsRepository carsRepository;
	
	@Autowired
	public ByteWheelsUtil(CarsRepository carsRepository){
		this.carsRepository=carsRepository;
	}
	
	public ArrayList<Cars> cachedCarsList;

	@PostConstruct
	public void init(){
		cachedCarsList = new ArrayList<>(carsRepository.findAll());
	}
	
	public static Timestamp toTimeStamp(String date){
		SimpleDateFormat dateFormat = new SimpleDateFormat(
	            "dd-MM-yyyy hh:mm:ss");

	    java.util.Date parsedTimeStamp = null;
		try {
			parsedTimeStamp = dateFormat.parse(date);
		} catch (ParseException e) {
			throw new IllegalArgumentException("Unparsable date: "+date);
		}

	    Timestamp timestamp = new Timestamp(parsedTimeStamp.getTime());
	    return timestamp;
	}
}
