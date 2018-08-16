package com.nts.pjt5_6.controller.api;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nts.pjt5_6.service.DisplayInfoService;
import com.nts.pjt5_6.service.ProductService;

@RestController
@RequestMapping(path = "/products")
public class ProductApiController {
	@Autowired
	private ProductService productService;
	@Autowired
	private DisplayInfoService displayInfoService;
	
	@GetMapping
	public Map<String, Object> productsList(
			@RequestParam(name = "categoryId", required = false, defaultValue = "0") int categoryId,
			@RequestParam(name = "start", required = false, defaultValue = "0") int start) {

		Map<String, Object> productApiData = new LinkedHashMap<>();
		productApiData.put("totalCount", productService.getTotalCount(categoryId));
		productApiData.put("productsCount", ProductService.LIMIT);
		productApiData.put("products", productService.getProducts(categoryId, start));

		return productApiData;
	}

	@GetMapping("/{id}")
	public Map<String, Object> displayInfo(@PathVariable(name = "id") int dpInfoId) {

		Map<String, Object> displayApiData = new LinkedHashMap<>();
		displayApiData.put("product", displayInfoService.getProductById(dpInfoId));
		displayApiData.put("productImages", displayInfoService.getProductImagesInfo(dpInfoId));
		displayApiData.put("diplayInfoImages", displayInfoService.getDisplayImagesInfo(dpInfoId));
		displayApiData.put("comments", displayInfoService.getComments(dpInfoId));
		displayApiData.put("avgScore", displayInfoService.getAvgScore(dpInfoId));
		displayApiData.put("productPrices", displayInfoService.getProductPrices(dpInfoId));

		return displayApiData;
	}
}
