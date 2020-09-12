package com.avikdigidev.ecom.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ProductDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private long id;
	private Long categoryId;
	// private ProductCategory productCategory;
	private String sku;
	private String name;
	private String description;
	private double unitPrice;
	private String imageUrl;
	private boolean active;
	private long unitsInStock;

	public String categoryName;

}
