package com.devo.crt.product.restful.product.v1;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devo.crt.product.restful.product.ProductApi;
import com.devo.crt.product.service.product.Category;
import com.devo.crt.product.service.product.CategoryService;

@RestController
@RequestMapping("/productapi/v1/")
@CrossOrigin
public class ProductApiImpl implements ProductApi {

	@Autowired
	private CategoryService productService;
	
	@Override
	public ResponseEntity<List<WSCategory>> getAllCategories() {
		
		List<WSCategory> result = productService.getAllCategories()
				.stream()
				.map(WSCategory::new)
				.collect(Collectors.toList());
		
		return new ResponseEntity<List<WSCategory>>(result, HttpStatus.OK);
		
	}

	@Override
	public ResponseEntity<WSCategory> saveCategory(WSCategory wsCategory) {
		Category c = productService.saveCategory(wsCategory.toCategory());
		
		return new ResponseEntity<WSCategory>(new WSCategory(c), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<WSCategory> getCategory(Long categoryId) {
		Category category = productService.getCategory(categoryId);
		return new ResponseEntity<WSCategory>(new WSCategory(category), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<WSCategory> updateCategory(Long categoryId, WSCategory wsCategory) {
		
		Category updateCategory = productService.updateCategory(categoryId, wsCategory.toCategory());
		
		return new ResponseEntity<WSCategory>(new WSCategory(updateCategory), HttpStatus.OK);
	}

}
