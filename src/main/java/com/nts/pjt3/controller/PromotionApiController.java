package com.nts.pjt3.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nts.pjt3.dto.Promotion;
import com.nts.pjt3.service.PromotionService;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/promotions")
public class PromotionApiController {
	@Autowired
	PromotionService promotionService;
	
	@GetMapping
	public Map<String,Object> promotionList(){
		
		List<Promotion> promotionItems = promotionService.getAllPromotionItemsInfo();
		int promotionItemSize = promotionService.getTotalPromotionCount();
		
		Map<String,Object> map =new LinkedHashMap<>();
		map.put("items",promotionItems);
		map.put("size",promotionItemSize);
		
		return map;
	}
}
