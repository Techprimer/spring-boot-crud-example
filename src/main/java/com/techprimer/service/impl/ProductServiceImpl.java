package com.techprimer.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.techprimer.entity.Product;
import com.techprimer.service.ProductService;
import com.techprimer.service.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	private ProductRepository productRepository;

	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public Product addProduct(Product product) {
		product = productRepository.save(product);
		return product;
	}

	@Override
	public Product getProduct(Long productId) {
		Optional<Product> product = productRepository.findById(productId);
		return product.get();
	}

	@Override
	public Product updateProduct(Product productInfo) {
		Optional<Product> product = productRepository.findById(productInfo.getId());
		if (product.isPresent()) {
			Product dbProduct = product.get();
			dbProduct.setName(productInfo.getName());
			dbProduct.setDescription(productInfo.getDescription());
			productRepository.save(dbProduct);
			return dbProduct;
		} else {
			return null;
		}

	}

	@Override
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);

	}

}
