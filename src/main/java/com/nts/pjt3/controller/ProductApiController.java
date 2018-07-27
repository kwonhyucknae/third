package com.nts.pjt3.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nts.pjt3.dto.Product;
import com.nts.pjt3.service.ProductService;

@RestController
@RequestMapping(path = "/products")
public class ProductApiController {
	@Autowired
	ProductService productService;

	@GetMapping
	public Map<String, Object> productsList(
			@RequestParam(name = "categoryId", required = false, defaultValue = "-1") int categoryId,
			@RequestParam(name = "start", required = false, defaultValue = "0") int start) {

		List<Product> products = productService.getProducts(categoryId,start);
		int totalCount = productService.getTotalCount();

		Map<String, Object> map = new HashMap<>();
		map.put("totalCount", totalCount);
		map.put("productsCount", ProductService.LIMIT);
		map.put("products", products);

		return map;
	}
	
//	@GetMapping("/{id}")
//	public Map<String,Object> productInfo(@PathVariable(name="id") int id){
//		
//	}
}
