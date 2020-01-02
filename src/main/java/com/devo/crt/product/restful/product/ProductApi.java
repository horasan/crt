package com.devo.crt.product.restful.product;



import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.devo.crt.product.restful.product.v1.WSCategory;

public interface ProductApi {
	
	@GetMapping("/category")
	public ResponseEntity<List<WSCategory>> getAllCategories();

	@GetMapping("/category/{categoryId}")
	public ResponseEntity<WSCategory> getCategory(@PathVariable("categoryId") Long categoryId);
	
	@PostMapping("/category")
	public ResponseEntity<WSCategory> saveCategory(@RequestBody WSCategory wsCategory);
	
	@PutMapping("/category/{categoryId}")
	public ResponseEntity<WSCategory> updateCategory(@PathVariable("categoryId") Long categoryId, @RequestBody WSCategory wsCategory);
	
}
