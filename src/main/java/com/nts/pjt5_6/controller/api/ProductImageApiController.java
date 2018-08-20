package com.nts.pjt5_6.controller.api;

import java.util.LinkedHashMap;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nts.pjt5_6.service.ImageService;

@RestController
@RequestMapping(path = "/api/productImages")
public class ProductImageApiController {

	@Autowired
	private ImageService imageService;

	@GetMapping("/{id}")
	public Map<String, Object> productImageInfo(@PathVariable(name = "id") int productId,
			@RequestParam(name = "type", required = false, defaultValue = "all") String type) {
		
		Map<String, Object> productImagesApiData = new LinkedHashMap<>();
		productImagesApiData.put("items", imageService.getProductImagesInfoByIdAndType(productId, type));
		productImagesApiData.put("size", imageService.getProductImagesInfoByIdAndType(productId, type).size());
		return productImagesApiData;
	}
}
