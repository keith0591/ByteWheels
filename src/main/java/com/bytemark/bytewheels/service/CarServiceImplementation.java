package com.bytemark.bytewheels.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bytemark.bytewheels.dto.RentalsDto;
import com.bytemark.bytewheels.entities.Cars;
import com.bytemark.bytewheels.entities.Rentals;
import com.bytemark.bytewheels.repository.CarsRepository;
import com.bytemark.bytewheels.repository.CategoryRepository;
import com.bytemark.bytewheels.repository.RentalsRepository;
import com.bytemark.bytewheels.util.ByteWheelsUtil;

@Component
public class CarServiceImplementation implements CarService {

	private RentalsRepository repo;
	
	private CarsRepository carRepo;
	
	private CategoryRepository catRepo;
	
    @Autowired	
	public CarServiceImplementation(RentalsRepository repo,CarsRepository carRepo,CategoryRepository catRepo) {
		super();
		this.repo = repo;
		this.carRepo=carRepo;
		this.catRepo=catRepo;
	}



	@Override
	public List<Cars> getAllAvailableCars(Timestamp fromDate,Timestamp toDate) {
		System.out.println(fromDate.toString()+" "+toDate);
		if(fromDate.after(toDate)|| fromDate.equals(toDate)){
			throw new IllegalArgumentException("From Date Cannot be greater or equal to To Date");
		}
		Map<Cars,Long> map = repo.findNotAvailableCars(fromDate, toDate).stream()
				.collect(Collectors.groupingBy(Rentals::getCar,Collectors.counting()));
		System.out.println(map);
		
		List<Cars> allCars = new ArrayList<>();
		allCars =carRepo.findAll();
		for(Cars c : allCars){
			if(map.containsKey(c)){
				Long count = map.get(c);
				c.setAvailability(c.getAvailability()-count.intValue());
			}
		}
        return allCars;	
	}
    
	@Override
	public Rentals bookRentals(RentalsDto dto) {
		Rentals entity = new Rentals();
		entity.setBookedCount(1);
		Cars car = carRepo.getOne(dto.getCarId());
		entity.setCar(car);
		entity.setEmailId(dto.getEmail());
		Timestamp fromParsedDate = ByteWheelsUtil.toTimeStamp(dto.getFromDate());
		Timestamp toParsedDate = ByteWheelsUtil.toTimeStamp(dto.getToDate());
		entity.setFromDate(fromParsedDate);
		entity.setToDate(toParsedDate);
		long diff = toParsedDate.getTime() - fromParsedDate.getTime();
		entity.setTotalCost(((Long)TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS)).doubleValue()
				*(car.getCarCategory().getCost()));
		Rentals retValue = repo.save(entity);
		return retValue;
	}

}
