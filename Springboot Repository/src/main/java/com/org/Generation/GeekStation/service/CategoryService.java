package com.org.Generation.GeekStation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.Generation.GeekStation.model.CategoryEntity;
import com.org.Generation.GeekStation.repository.CategoryRepository;

@Service
public class CategoryService {
	
	private final CategoryRepository categoryRepository;
	
	@Autowired
	public CategoryService (CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	

	//metodo para obtener a todas las categorias
	public List<CategoryEntity> getAll(){
		return this.categoryRepository.findAll();
	}
	
	//metodo para crear una nueva categoria
	public CategoryEntity createCategory(CategoryEntity newCategory) {
		return this.categoryRepository.save(newCategory);
	}
	

}
