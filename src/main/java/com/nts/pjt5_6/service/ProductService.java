package com.nts.pjt5_6.service;

import java.util.List;

import com.nts.pjt5_6.dto.Product;

public interface ProductService {
	public static final Integer LIMIT = 4;

	public List<Product> getProducts(int categoryId,int start);
	public int getTotalCount(int categoryId);
	public Product getProductById(int productId);

}
