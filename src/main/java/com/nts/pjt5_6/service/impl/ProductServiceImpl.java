package com.nts.pjt5_6.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nts.pjt5_6.dao.ProductMapper;
import com.nts.pjt5_6.dto.Product;
import com.nts.pjt5_6.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductMapper productMapper;

	@Override
	public List<Product> getProducts(int categoryId, int start) {
		return productMapper.selectProductsPaging(start, ProductService.LIMIT, categoryId);
	}

	@Override
	public int getTotalCount(int categoryId) {
		return productMapper.selectCountDisplayInfo(categoryId);
	}
	
	@Override
	public Product getProductById(int productId) {
		return productMapper.selectProductByProductId(productId);
	}
	
}
