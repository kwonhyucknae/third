package com.nts.pjt5_6.controller.api;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nts.pjt5_6.service.PromotionService;

@RestController
@RequestMapping(path = "/promotions")
public class PromotionApiController {
	@Autowired
	private PromotionService promotionService;
	
	@GetMapping
	public Map<String,Object> promotionList(){
		
		Map<String,Object> promotionApiData =new LinkedHashMap<>();
		promotionApiData.put("items",promotionService.getAllPromotionItemsInfo());
		promotionApiData.put("size", promotionService.getTotalPromotionCount());
		
		return promotionApiData;
	}
}
