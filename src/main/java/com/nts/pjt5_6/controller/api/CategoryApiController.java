package com.nts.pjt5_6.controller.api;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nts.pjt5_6.service.CategoryService;

@RestController
@RequestMapping(path="/categories")
public class CategoryApiController {
	@Autowired
	private CategoryService categorieService;
	
	@GetMapping
	public Map<String,Object> categoryList(){

		Map<String,Object> categoryApiData = new LinkedHashMap<>();
		categoryApiData.put("items", categorieService.getCategorie());
		categoryApiData.put("size", categorieService.getCategoryCount());
		return categoryApiData;
	}
}
