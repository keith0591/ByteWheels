package com.bytemark.bytewheels.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class Category implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="category_name",nullable=false,insertable=false)
	private String categoryName;
	
	@Column(name="cost",nullable=false,insertable=false,columnDefinition="Decimal(7,2)")
	private Double cost;
	
	public Long getId() {
		return id;
	}
	public Double getCost() {
		return cost;
	}
	public String getCategoryName() {
		return categoryName;
	}
	
	
}
