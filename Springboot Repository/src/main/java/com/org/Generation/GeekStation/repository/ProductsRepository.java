package com.org.Generation.GeekStation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.Generation.GeekStation.model.ProductsEntity;

public interface ProductsRepository extends JpaRepository<ProductsEntity, Long> {
	

}
