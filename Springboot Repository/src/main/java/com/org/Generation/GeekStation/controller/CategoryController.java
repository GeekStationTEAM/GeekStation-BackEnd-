package com.org.Generation.GeekStation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.Generation.GeekStation.model.CategoryEntity;
import com.org.Generation.GeekStation.service.CategoryService;


@RestController
@RequestMapping("/api/v1")

public class CategoryController {
	
private final CategoryService categoryService;
	
	@Autowired
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@GetMapping("/category")
	public List<CategoryEntity> getCategory(){
		return this.categoryService.getAll();
	}
	
	@PostMapping("/new-category")
	public CategoryEntity createCategory(@RequestBody CategoryEntity newCategory) {
		return this.categoryService.createCategory(newCategory);
	}

}
