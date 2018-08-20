package com.nts.pjt5_6.service;

import java.util.List;

import com.nts.pjt5_6.dto.Comments;
import com.nts.pjt5_6.dto.DisplayInfoImages;
import com.nts.pjt5_6.dto.Product;
import com.nts.pjt5_6.dto.ProductImages;
import com.nts.pjt5_6.dto.ProductPrices;
import com.nts.pjt5_6.dto.ReservationUserCommentImages;

public interface DisplayInfoService {

	public Product getProductById(int dpInfoId);
	public List<ProductImages> getProductImagesInfo(int dpInfoId);
	public List<DisplayInfoImages> getDisplayImagesInfo(int dpInfoId);
	public List<ReservationUserCommentImages> getCommentImagesByCommentID(int commentID);
	public List<Comments> getComments(int dpInfoId);
	public double getAvgScore(int dpInfoId);
	public List<ProductPrices> getProductPrices(int dpInfoId);
}
