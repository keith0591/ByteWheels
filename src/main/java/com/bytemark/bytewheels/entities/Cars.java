package com.bytemark.bytewheels.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="cars")
public class Cars implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;

	@Column(name="car_name",nullable=false,insertable=false)
	private String carName;
	
	@ManyToOne
	@JoinColumn(name="car_type")
	private Category carCategory;
	
	@Column(name="availability",nullable=false,insertable=false)
	private Integer availability;

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public Category getCarCategory() {
		return carCategory;
	}

	public void setCarCategory(Category carCategory) {
		this.carCategory = carCategory;
	}

	public Integer getAvailability() {
		return availability;
	}

	public void setAvailability(Integer availability) {
		this.availability = availability;
	}

	public Long getId() {
		return id;
	}

	@Override
	public boolean equals(Object obj) {
		Cars car = (Cars)obj;
		if(car.getId().equals(this.id))
			return true;
		else
			return false;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.id);
	}
	
	
	
}
