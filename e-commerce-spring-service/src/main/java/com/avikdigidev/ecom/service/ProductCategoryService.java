package com.avikdigidev.ecom.service;

import java.util.List;

import com.avikdigidev.ecom.domain.ProductCategoryDTO;
import com.avikdigidev.ecom.entity.ProductCategory;
import com.avikdigidev.ecom.exception.NoDataFoundException;

public interface ProductCategoryService {

	List<ProductCategory> getProductCategories();

	ProductCategoryDTO getProductCategoryById(Long id);

	String updateProductCategory(ProductCategoryDTO productCategoryDTO) throws NoDataFoundException;

	ProductCategoryDTO createProductCategory(ProductCategoryDTO productCategoryDTO);

	String deleteProductCategory(Long id);

}
