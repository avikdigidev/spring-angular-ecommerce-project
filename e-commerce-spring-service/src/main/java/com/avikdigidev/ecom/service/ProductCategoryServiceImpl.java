package com.avikdigidev.ecom.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avikdigidev.ecom.domain.ProductCategoryDTO;
import com.avikdigidev.ecom.entity.ProductCategory;
import com.avikdigidev.ecom.exception.NoDataFoundException;
import com.avikdigidev.ecom.repository.ProductCategoryRepository;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

	@Autowired
	ProductCategoryRepository productCategoryRepository;

	@Override
	public List<ProductCategory> getProductCategories() {
		List<ProductCategory> lpc = productCategoryRepository.findAll();
		return lpc;
	}

	@Override
	public ProductCategoryDTO getProductCategoryById(Long id) {
		Optional<ProductCategory> productCategory = productCategoryRepository.findById(id);
		ProductCategoryDTO productCategoryDTO = new ProductCategoryDTO();
		if (productCategory.isPresent()) {
			BeanUtils.copyProperties(productCategory.get(), productCategoryDTO);
//			productCategoryDTO.setId((productCategory.get().getId()));
//			productCategoryDTO.setCategoryName(productCategory.get().getCategoryName());
			return productCategoryDTO;
		} else {
			return null;
		}
	}

	@Override
	public String updateProductCategory(ProductCategoryDTO productCategoryDTO) throws NoDataFoundException {
		Long id = productCategoryDTO.getId();
		Optional<ProductCategory> productCategory = productCategoryRepository.findById(id);
		if (!productCategory.isPresent()) {
			throw new NoDataFoundException(String.format("Product Category id [] not found", id));
		}
//		productCategory.get().setId(productCategoryDTO.getId());
//		productCategory.get().setCategoryName(productCategoryDTO.getCategoryName());
		BeanUtils.copyProperties(productCategoryDTO, productCategory.get());
		productCategoryRepository.save(productCategory.get());
		return "Updated";

	}

	@Override
	public ProductCategoryDTO createProductCategory(ProductCategoryDTO productCategoryDTO) {
		ProductCategory productCategory = new ProductCategory();
		BeanUtils.copyProperties(productCategoryDTO, productCategory);
		productCategoryRepository.save(productCategory);
		return productCategoryDTO;
	}

	@Override
	public String deleteProductCategory(Long id) {
		productCategoryRepository.deleteById(id);
		return "Deleted";
	}

}
