package com.org.Generation.GeekStation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.Generation.GeekStation.model.ProductsEntity;
import com.org.Generation.GeekStation.service.ProductsService;

@RestController
@RequestMapping("/api/v1")

public class ProductsController {
	
	private final ProductsService productsService;
	
	@Autowired
	public ProductsController(ProductsService productsService) {
		this.productsService = productsService;
	}
	
	@GetMapping("/productos")
	public List<ProductsEntity> getProductos(){
		return this.productsService.getAll();
	}
	
	@PostMapping("/new-product")
	public ProductsEntity createProduct(@RequestBody ProductsEntity newProducts) {
		return this.productsService.createProduct(newProducts);
	}
	
	

}
