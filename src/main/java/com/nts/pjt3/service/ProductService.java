package com.nts.pjt3.service;

import java.util.List;

import com.nts.pjt3.dto.Comments;
import com.nts.pjt3.dto.DisplayInfoImages;
import com.nts.pjt3.dto.Product;
import com.nts.pjt3.dto.ProductImages;
import com.nts.pjt3.dto.ProductPrices;
import com.nts.pjt3.dto.ReservationUserCommentImages;

public interface ProductService {
	public static final Integer LIMIT = 4;

	public List<Product> getProducts(Integer categoryId,Integer start);
	public int getTotalCount(int categoryId);
	public Product getProductById(int dpInfoId);
	public List<ProductImages> getProductImagesInfo(int dpInfoId);
	public List<DisplayInfoImages> getDisplayImagesInfo(int dpInfoId);
	public List<ReservationUserCommentImages> getCommentImagesByCommentID(int commentID);
	public List<Comments> getComments(int dpInfoId);
	public long getAvgScore(int dpInfoId);
	public List<ProductPrices> getProductPrices(int dpInfoId);
	
	
}
