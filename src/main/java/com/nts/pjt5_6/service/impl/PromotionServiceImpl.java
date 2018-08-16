package com.nts.pjt5_6.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nts.pjt5_6.dao.PromotionMapper;
import com.nts.pjt5_6.dto.Promotion;
import com.nts.pjt5_6.service.PromotionService;

@Service
public class PromotionServiceImpl implements PromotionService{
	@Autowired
	PromotionMapper promotionMapper;
	
	@Override
	public List<Promotion> getAllPromotionItemsInfo(){
		return promotionMapper.selectAllPromotionItems();
	}
	
	@Override
	public int getTotalPromotionCount() {
		return promotionMapper.selectCountTotalPromotionItem();
	}
}
