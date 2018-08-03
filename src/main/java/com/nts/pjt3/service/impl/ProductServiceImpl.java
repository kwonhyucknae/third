package com.nts.pjt3.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nts.pjt3.dao.ProductDao;
import com.nts.pjt3.dto.Comments;
import com.nts.pjt3.dto.DisplayInfoImages;
import com.nts.pjt3.dto.Product;
import com.nts.pjt3.dto.ProductImages;
import com.nts.pjt3.dto.ProductPrices;
import com.nts.pjt3.dto.ReservationUserCommentImages;
import com.nts.pjt3.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	private static final int ALL_ITEMS = 0;
	@Autowired
	ProductDao productDao;

	@Override
	public List<Product> getProducts(Integer categoryId, Integer start) {

		if (categoryId == ALL_ITEMS) {
			return productDao.selectProductsPaging(start, ProductService.LIMIT);
		} else {
			return productDao.selectProductsByCategory(start, ProductService.LIMIT, categoryId);
		}
	}
	@Override
	public int getTotalCount(int categoryId) {
		if (categoryId == ALL_ITEMS) {
			return productDao.selectCountAllDisplayInfo();
		} else {
			return productDao.selectCountDisplayInfoByCategory(categoryId);
		}
	}

	@Override
	public Product getProductById(int dpInfoId) {
		return productDao.selectProductById(dpInfoId);
	}

	@Override
	public List<ProductImages> getProductImagesInfo(int dpInfoId) {
		return productDao.selectProductImagesInfo(dpInfoId);
	}

	@Override
	public List<DisplayInfoImages> getDisplayImagesInfo(int dpInfoId) {
		return productDao.selectDisplayImagesInfo(dpInfoId);
	}

	@Override
	public List<ReservationUserCommentImages> getCommentImagesByCommentID(int commentID) {
		return productDao.selectCommentImagesByCommentId(commentID); 
	}
	
	@Override
	public List<Comments> getComments(int dpInfoId) {
		List<Comments> temporaryList = productDao.selectComments(dpInfoId);
		for(int i=0;i<temporaryList.size();i++) {
			List<ReservationUserCommentImages> commentImagesByCommentId = getCommentImagesByCommentID(temporaryList.get(i).getId());
			temporaryList.get(i).setUserCommentImages(commentImagesByCommentId);
		}
		return temporaryList;
	}
	
	@Override
	public long getAvgScore(int dpInfoId) {
		return productDao.selectAvgScore(dpInfoId);
	}
	
	
	@Override
	public List<ProductPrices> getProductPrices(int dpInfoId) {
		return productDao.selectProductPrices(dpInfoId);
	}
}
