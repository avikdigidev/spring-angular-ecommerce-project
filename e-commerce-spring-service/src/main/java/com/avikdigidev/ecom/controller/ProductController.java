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

import com.avikdigidev.ecom.domain.ProductDTO;
import com.avikdigidev.ecom.entity.Product;
import com.avikdigidev.ecom.exception.NoDataFoundException;
import com.avikdigidev.ecom.service.ProductService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("api-productInfo")
public class ProductController {
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ProductService productService;

//	@Autowired
//	private EcommUtils ecommUtils;

	@GetMapping("/products")
	public List<Product> getProducts() {
		List<Product> productList = productService.getProducts();
		return productList;

	}

	@GetMapping("/product/{id}")
	public ProductDTO getProductById(@PathVariable(value = "id") Long id) {
		return productService.getProductById(id);

	}

	@PutMapping("/product")
	public String updateProduct(@Valid @RequestBody ProductDTO productDTO) throws NoDataFoundException {
		return productService.updateProduct(productDTO);
	}

	@PostMapping("/product")
	public ProductDTO createProduct(@Valid @RequestBody ProductDTO productDTO) {
		return productService.createProduct(productDTO);
	}

	@DeleteMapping("/product/{id}")
	public String deleteProduct(@PathVariable(value = "id") Long id) {
//		logger.info(ecommUtils.currentClassAndMethod());
		return productService.deleteProduct(id);
	}

}
