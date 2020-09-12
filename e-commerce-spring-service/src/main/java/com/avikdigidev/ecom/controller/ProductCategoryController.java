package com.avikdigidev.ecom.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avikdigidev.ecom.domain.ProductCategoryDTO;
import com.avikdigidev.ecom.entity.ProductCategory;
import com.avikdigidev.ecom.exception.NoDataFoundException;
import com.avikdigidev.ecom.service.ProductCategoryService;
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("api-productCategoryInfo")
public class ProductCategoryController {
	private static final Logger logger = LoggerFactory.getLogger(ProductCategoryController.class);

	@Autowired
	private ProductCategoryService productCategoryService;

	@GetMapping("/productCategories")
	public List<ProductCategory> getProductCategories() {
		logger.info(currentClassAndMethod());
		List<ProductCategory> productCategoryList = productCategoryService.getProductCategories();
		return productCategoryList;

	}

	@GetMapping("/productCategory/{id}")
	public ProductCategoryDTO getProductCategoryById(@PathVariable(value = "id") Long id) {
		logger.info(currentClassAndMethod());
		return productCategoryService.getProductCategoryById(id);

	}

	@PutMapping("/productCategory")
	public String updateProductCategory(@Valid @RequestBody ProductCategoryDTO productCategoryDTO) throws NoDataFoundException {
		return productCategoryService.updateProductCategory(productCategoryDTO);
	}

	@PostMapping("/productCategory")
	public ProductCategoryDTO createProductCategory(@Valid @RequestBody  ProductCategoryDTO productCategoryDTO) {
		return productCategoryService.createProductCategory(productCategoryDTO);
	}

	@DeleteMapping("/productCategory/{id}")
	public String deleteProductCategory(@PathVariable(value = "id") Long id) {
		return productCategoryService.deleteProductCategory(id);
	}

	public String currentClassAndMethod() {
		// getStackTrace()[1] method return
		// implementing method name at 1st index
		return "Inside class: " + this.getClass().getSimpleName() + " in method name: "
				+ new Throwable().getStackTrace()[1].getMethodName();

	}
}
