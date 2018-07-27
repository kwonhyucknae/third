package com.nts.pjt3.service;

import java.util.List;

import com.nts.pjt3.dto.Product;

public interface ProductService {
	public static final Integer LIMIT = 4;

	public List<Product> getProducts(Integer categoryId,Integer start);
	public int getTotalCount();
}
