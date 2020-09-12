//package com.avikdigidev.ecom.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
//config file needed when we are not creating our controller and we have
//to restrict data nad made it read only

//import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
//import org.springframework.http.HttpMethod;
//
//import com.avikdigidev.ecom.entity.Product;
//import com.avikdigidev.ecom.entity.ProductCategory;
//
//@Configuration
//public class DataRestComfig implements RepositoryRestConfigurer {
//	@Override
//	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
//		HttpMethod[] theUnsupportedActions = { HttpMethod.PUT, HttpMethod.DELETE, HttpMethod.POST };
//		// disable put, post and delete and make it read only.
//		config.getExposureConfiguration().forDomainType(Product.class)
//				.withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
//				.withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions));
//
//		config.getExposureConfiguration().forDomainType(ProductCategory.class)
//				.withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
//				.withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions));
//
//	}
//}
