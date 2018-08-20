package com.nts.pjt5_6.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nts.pjt5_6.dao.ImageMapper;
import com.nts.pjt5_6.dto.ProductImages;
import com.nts.pjt5_6.service.ImageService;

@Service
public class ImageServiceImpl implements ImageService{
	
	@Autowired
	ImageMapper imageMapper;
	
	@Override
	public List<ProductImages> getProductImagesInfoByIdAndType(int productId, String type) {
		return imageMapper.selectProductImagesInfoByIdAndType(productId, type);
	}
	
	@Override
	public ProductImages getProductImagesInfoByProductImageId(int prodImageId) {
		return imageMapper.selectProductImagesInfoByProductImageId(prodImageId);
	}
}
