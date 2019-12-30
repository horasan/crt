package com.devo.crt.product.restful.product.v1;

import com.devo.crt.product.service.product.Category;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WSCategory {

	private Long id;
	private String name;
	private Integer uiOrder;
	
	public WSCategory(Category category) {
		this.setId(category.getId());
		this.setName(category.getName());
		this.setUiOrder(category.getUiOrder());
	}
}
