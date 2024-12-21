package com.org.Generation.GeekStation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.Generation.GeekStation.model.ProductsEntity;
import com.org.Generation.GeekStation.repository.ProductsRepository;



@Service
public class ProductsService {

	private final ProductsRepository productsRepository;
	
	@Autowired
	public ProductsService(ProductsRepository productsRepository ) {
		this.productsRepository = productsRepository;
	}
	
	//metodo para obtener a todos los Products
	public List<ProductsEntity> getAll(){
		return this.productsRepository.findAll();
	}
	
	//metodo para crear un nuevo product
	public ProductsEntity createProduct(ProductsEntity newProducts) {
		return this.productsRepository.save(newProducts);
	}

}
