package com.bytemark.bytewheels.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bytemark.bytewheels.entities.Cars;

public interface CarsRepository extends JpaRepository<Cars, Long> {
	
	

}
