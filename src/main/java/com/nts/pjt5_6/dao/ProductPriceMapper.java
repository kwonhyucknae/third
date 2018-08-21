package com.nts.pjt5_6.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nts.pjt5_6.dto.ProductPrices;

@Mapper
public interface ProductPriceMapper {
	public List<ProductPrices> selectProductPrices(int dpInfoId);
}
