package com.nts.pjt5_6.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nts.pjt5_6.dto.Promotion;

@Mapper
public interface PromotionMapper {
	public List<Promotion> selectAllPromotionItems();
	public int selectCountTotalPromotionItem();
}
