package com.nts.pjt3.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nts.pjt3.dto.Comments;
import com.nts.pjt3.dto.DisplayInfoImages;
import com.nts.pjt3.dto.Product;
import com.nts.pjt3.dto.ProductImages;
import com.nts.pjt3.dto.ProductPrices;
import com.nts.pjt3.service.ProductService;

@RestController
@RequestMapping(path = "/products")
public class ProductApiController {
	@Autowired
	ProductService productService;

	@GetMapping
	public Map<String, Object> productsList(
			@RequestParam(name = "categoryId", required = false, defaultValue = "0") int categoryId,
			@RequestParam(name = "start", required = false, defaultValue = "0") int start) {

		List<Product> products = productService.getProducts(categoryId,start);
		int totalCount = productService.getTotalCount(categoryId);

		Map<String, Object> map = new LinkedHashMap<>();
		map.put("totalCount", totalCount);
		map.put("productsCount", ProductService.LIMIT);
		map.put("products", products);

		return map;
	}
	
	@GetMapping("/{id}")
	public Map<String,Object> productInfo(@PathVariable(name="id") int dpInfoId){
		
		Product product = productService.getProductById(dpInfoId);
		List<ProductImages> productImagesInfo = productService.getProductImagesInfo(dpInfoId);
		List<DisplayInfoImages> displayImagesInfo = productService.getDisplayImagesInfo(dpInfoId);
		List<Comments> commentsById = productService.getComments(dpInfoId);
		long avgScore = productService.getAvgScore(dpInfoId);
		List<ProductPrices> productPrices = productService.getProductPrices(dpInfoId);
		
		Map<String,Object> map = new LinkedHashMap<>();
		map.put("product", product);
		map.put("productImages", productImagesInfo);
		map.put("diplayInfoImages", displayImagesInfo);
		map.put("comments", commentsById);
		map.put("avgScore", avgScore);
		map.put("productPrices", productPrices);
		
		return map;
	}
}
