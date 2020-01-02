package com.devo.crt.product.service.product;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.devo.crt.product.restful.product.v1.WSCategory;

public interface CategoryService {

	public List<Category> getAllCategories();
	
	public Category saveCategory(Category c);

	public Category getCategory(Long categoryId);

	public Category updateCategory(Long categoryId, Category category);
	
}
