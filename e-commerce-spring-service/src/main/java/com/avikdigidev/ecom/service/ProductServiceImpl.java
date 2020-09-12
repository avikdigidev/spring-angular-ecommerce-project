package com.avikdigidev.ecom.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avikdigidev.ecom.domain.ProductDTO;
import com.avikdigidev.ecom.entity.Product;
import com.avikdigidev.ecom.entity.ProductCategory;
import com.avikdigidev.ecom.exception.NoDataFoundException;
import com.avikdigidev.ecom.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public List<Product> getProducts() {
		List<Product> lp = productRepository.findAll();
		return lp;
	}

	@Override
	public ProductDTO getProductById(Long id) {
		Optional<Product> product = productRepository.findById(id);
		ProductDTO productDTO = new ProductDTO();
		if (product.isPresent()) {
			BeanUtils.copyProperties(product.get(), productDTO);
			productDTO.setCategoryId(product.get().getCategory().getId());
			productDTO.setCategoryName(product.get().getCategory().getCategoryName());
			return productDTO;
		} else {
			return null;
		}
	}

	@Override
	public String updateProduct(ProductDTO productDTO) throws NoDataFoundException {
		Long id = productDTO.getId();
		Optional<Product> product = productRepository.findById(id);
		ProductCategory productCategory = new ProductCategory();
		if (!product.isPresent()) {
			throw new NoDataFoundException(String.format("Product id [] not found", id));
		}
		productCategory.setId(productDTO.getCategoryId());
		productCategory.setCategoryName(productDTO.getCategoryName());
		BeanUtils.copyProperties(productDTO, product.get());
		product.get().setCategory(productCategory);
		productRepository.save(product.get());
		return "Updated";

	}

	@Override
	public ProductDTO createProduct(ProductDTO productDTO) {
		Product product = new Product();
		ProductCategory productCategory = new ProductCategory();
		productCategory.setId(productDTO.getCategoryId());
		productCategory.setCategoryName(productDTO.getCategoryName());
		BeanUtils.copyProperties(productDTO, product);
		product.setCategory(productCategory);
		productRepository.save(product);
		return productDTO;
	}

	@Override
	public String deleteProduct(Long id) {
		productRepository.deleteById(id);
		return "Deleted";
	}

}
