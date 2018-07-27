package com.nts.pjt3.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nts.pjt3.dto.Category;
import com.nts.pjt3.service.CategorieService;

@RestController
@RequestMapping(path="/categories")
public class CategorieApiController {
	@Autowired
	CategorieService categorieService;
	
	@GetMapping
	public Map<String,Object> list(){
		List<Category> list = categorieService.getCategorie();	
		int count = categorieService.getCount();
		Map<String,Object> map = new LinkedHashMap<>();
		map.put("items", list);
		map.put("size", count);
		return map;
	}
}
