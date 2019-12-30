package com.devo.crt.product.restful.product;



import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.devo.crt.product.restful.product.v1.WSCategory;

public interface ProductApi {
	
	@GetMapping("/category")
	public ResponseEntity<List<WSCategory>> getAllCategories();

}
