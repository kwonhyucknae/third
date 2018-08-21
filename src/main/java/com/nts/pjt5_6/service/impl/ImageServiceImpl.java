package com.nts.pjt5_6.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nts.pjt5_6.dao.ProductImageMapper;
import com.nts.pjt5_6.dto.ProductImages;
import com.nts.pjt5_6.service.ImageService;

@Service
public class ImageServiceImpl implements ImageService{
	
	@Autowired
	ProductImageMapper imageMapper;
	
	@Override
	public List<ProductImages> getProductImagesInfoByIdAndType(int productId, String type) {
		return imageMapper.selectProductImagesInfoByIdAndType(productId, type);
	}
	
	@Override
	public ProductImages getProductImagesInfoByProductImageId(int prodImageId) {
		return imageMapper.selectProductImagesInfoByProductImageId(prodImageId);
	}
}
