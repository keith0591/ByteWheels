package com.bytemark.bytewheels.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bytemark.bytewheels.entities.Rentals;

public interface RentalsRepository extends JpaRepository<Rentals, Long> {

	
	@Query("select c from Rentals c where (c.fromDate =:fromDate and c.toDate =:toDate) or "
			+ "(c.fromDate>=:fromDate and c.toDate>=:toDate) or (c.fromDate<:fromDate and c.toDate>:fromDate and c.toDate<:toDate) or(c.fromDate>=:fromDate and c.toDate<=:toDate)")
	public List<Rentals> findNotAvailableCars(@Param("fromDate")Timestamp fromDate,@Param("toDate")Timestamp toDate);
}
