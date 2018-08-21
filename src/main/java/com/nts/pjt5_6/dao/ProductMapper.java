package com.nts.pjt5_6.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.nts.pjt5_6.dto.Product;

@Mapper
public interface ProductMapper {
	
	public List<Product> selectProductsPaging(@Param("start")int start, @Param("limit")int limit, @Param("categoryId")int categoryId);
	public Product selectProductByProductId(@Param("productId")int productId);
	public Product selectProductByDisplayId(int dpInfoId);
}
