package com.devo.crt.product.respository.category;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.devo.crt.product.restful.product.v1.WSCategory;
import com.devo.crt.product.service.product.Category;

public interface CategoryRepository {
	public List<Category> getAllCategories();
	
	public Category saveCategory(Category c);

	public Category getCategory(Long categoryId);

	public Category updateCategory(Long categoryId, Category category);
	
}
