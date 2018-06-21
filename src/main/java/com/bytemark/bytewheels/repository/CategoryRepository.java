package com.bytemark.bytewheels.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bytemark.bytewheels.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
