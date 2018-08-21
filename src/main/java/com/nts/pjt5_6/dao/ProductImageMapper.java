package com.nts.pjt5_6.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.nts.pjt5_6.dto.ProductImages;

@Mapper
public interface ProductImageMapper {
	public List<ProductImages> selectProductImagesInfoByIdAndType(@Param("productId")int productId, @Param("type")String type);
	public ProductImages selectProductImagesInfoByProductImageId(@Param("prodImageId")int prodImageId);
	public List<ProductImages> selectProductImagesInfoByDispId(int dpInfoId);
}
