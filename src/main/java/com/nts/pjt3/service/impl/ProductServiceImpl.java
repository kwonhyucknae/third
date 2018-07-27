package com.nts.pjt3.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nts.pjt3.dao.ProductDao;
import com.nts.pjt3.dto.Product;
import com.nts.pjt3.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	ProductDao productDao;
	
	
	@Override
	@Transactional
	public List<Product> getProducts(Integer categoryId, Integer start) {
		
		List<Product> productsList;
		
		if(categoryId == -1) {
			productsList = productDao.selectAllProducts(start, ProductService.LIMIT);
		}else {
			productsList = productDao.selectCategoryProducts(start, ProductService.LIMIT, categoryId); 
		}
		return productsList;
	}

	@Override
	@Transactional
	public int getTotalCount() {
		int totalCount = productDao.selectTotalCount();
		return totalCount;
	}

	
}
