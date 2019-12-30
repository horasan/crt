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
import com.devo.crt.product.service.product.ProductService;

@RestController
@RequestMapping("/productapi/v1/")
@CrossOrigin
public class ProductApiImpl implements ProductApi {

	@Autowired
	private ProductService productService;
	
	@Override
	public ResponseEntity<List<WSCategory>> getAllCategories() {
		
		List<WSCategory> result = productService.getAllProducts()
				.stream()
				.map(WSCategory::new)
				.collect(Collectors.toList());
		
		return new ResponseEntity<List<WSCategory>>(result, HttpStatus.OK);
		
	}

}
