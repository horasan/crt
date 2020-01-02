package com.devo.crt.product.restful.product.v1;

import com.devo.crt.product.service.product.Category;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class WSCategory {

	private Long id;
	private String name;
	private Integer uiOrder;
	
	public WSCategory(Category category) {
		this.setId(category.getId());
		this.setName(category.getName());
		this.setUiOrder(category.getUiOrder());
	}
	
	public Category toCategory() {
		Category c = new Category();
		c.setId(null);
		c.setName(name);
		c.setUiOrder(uiOrder);
		return c;
	}
}
