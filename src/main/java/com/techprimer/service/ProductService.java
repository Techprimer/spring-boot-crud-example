package com.techprimer.service;

import com.techprimer.entity.Product;

public interface ProductService {

	public Product addProduct(Product product);

	public Product getProduct(Long productId);

	public Product updateProduct(Product product);

	public void deleteProduct(Long id);
}
