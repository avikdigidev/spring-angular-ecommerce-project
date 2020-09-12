package com.avikdigidev.ecom.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.avikdigidev.ecom.domain.ProductDTO;
import com.avikdigidev.ecom.entity.Product;
import com.avikdigidev.ecom.exception.NoDataFoundException;
public interface ProductService {

	List<Product> getProducts();

	ProductDTO getProductById(Long id);

	String updateProduct(ProductDTO productDTO) throws NoDataFoundException;

	ProductDTO createProduct(ProductDTO productDTO);

	String deleteProduct(Long id);

}
