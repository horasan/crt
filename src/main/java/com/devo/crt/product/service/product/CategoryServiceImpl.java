package com.devo.crt.product.service.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.devo.crt.product.respository.category.CategoryRepository;
import com.devo.crt.product.restful.product.v1.WSCategory;
import com.devo.crt.restful.exception.ObjectNotFound;

@Controller
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<Category> getAllCategories() {

		return categoryRepository.getAllCategories();

	}

	@Override
	public Category saveCategory(Category c) {

		return categoryRepository.saveCategory(c);

	}

	@Override
	public Category getCategory(Long categoryId) {
		Category cat = categoryRepository.getCategory(categoryId);
		if (Objects.isNull(cat)) {
			throw new ObjectNotFound(categoryId);
		} else {
			return cat;
		}
	}

	@Override
	public Category updateCategory(Long categoryId, Category category) {

		if (Objects.isNull(categoryRepository.getCategory(categoryId))) {
			throw new ObjectNotFound(categoryId);
		}

		return categoryRepository.updateCategory(categoryId, category);
	}
}
