package com.devo.crt.product.service.product;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;

@Controller
public class ProductServiceImpl implements ProductService {

	@Override
	public List<Category> getAllProducts() {

		return Arrays.asList(getCategory(1), getCategory(2), getCategory(3));
		
	}

	private Category getCategory(int index) {
		Category c = new Category();
		c.setId(Long.valueOf(index));
		c.setName("name_" + index);
		c.setUiOrder(index);
		return c;
	}
}
