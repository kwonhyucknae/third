package com.nts.pjt5_6.service;

import java.util.List;

import com.nts.pjt5_6.dto.ProductImages;

public interface ImageService {
	public List<ProductImages> getProductImagesInfoByIdAndType(int dpInfoId, String type);
	public ProductImages getProductImagesInfoByProductImageId(int productImageId);
}
