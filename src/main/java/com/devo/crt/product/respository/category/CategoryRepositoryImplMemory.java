package com.devo.crt.product.respository.category;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.devo.crt.product.restful.product.v1.WSCategory;
import com.devo.crt.product.service.product.Category;

@Repository
public class CategoryRepositoryImplMemory implements CategoryRepository {
	
	private List<Category> categoryList= prepareDefaulCategoryList();
		
	@Override
	public List<Category> getAllCategories() {
		return categoryList;
	}

	@Override
	public Category saveCategory(Category c) {
		c.setId(Long.valueOf(categoryList.size() + 1));
		categoryList.add(c);
		return c;
	}

	@Override
	public Category getCategory(Long categoryId) {
		Optional<Category> cat = categoryList.stream().filter(item -> item.getId().equals(categoryId)).findFirst();
		
		if (cat.isPresent()) {
			return cat.get();
		}
		else {
			return null;
		}
		
	}
	
	private Category getNewCategory(int index) {
		Category c = new Category();
		c.setId(Long.valueOf(index));
		c.setName("name_" + index);
		c.setUiOrder(index);
		return c;
	}
	
	private List<Category> prepareDefaulCategoryList() {
		List<Category> categoryList = new ArrayList<Category>();
		categoryList.add(getNewCategory(1));
		categoryList.add(getNewCategory(2));
		categoryList.add(getNewCategory(3));
		return categoryList;
	}

	@Override
	public Category updateCategory(Long categoryId, Category category) {
		Category cat = getFrimCategoryList(0);
		cat.setName(category.getName());
		cat.setUiOrder(category.getUiOrder());
		return cat;
	}

	private Category getFrimCategoryList(int i) {
		return categoryList.get(0);
	}

}
