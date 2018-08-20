package com.nts.pjt5_6.service;

import java.util.List;

import com.nts.pjt5_6.dto.Promotion;

public interface PromotionService {
	public List<Promotion> getAllPromotionItemsInfo();
	public int getTotalPromotionCount();
}
