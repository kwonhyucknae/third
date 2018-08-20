package com.nts.pjt5_6.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nts.pjt5_6.dto.Comments;
import com.nts.pjt5_6.dto.DisplayInfoImages;
import com.nts.pjt5_6.dto.Product;
import com.nts.pjt5_6.dto.ProductImages;
import com.nts.pjt5_6.dto.ProductPrices;
import com.nts.pjt5_6.dto.ReservationUserCommentImages;

@Mapper
public interface DisplayInfoMapper {
	public Product selectProductById(int dpInfoId);
	public List<ProductImages> selectProductImagesInfo(int dpInfoId);
	public List<DisplayInfoImages> selectDisplayImagesInfo(int dpInfoId);
	public List<ReservationUserCommentImages> selectCommentImagesByCommentId(int commentID);
	public List<Comments> selectCommentsByDisplayId(int dpInfoId);
	public double selectAvgScore(int dpInfoId);
	public List<ProductPrices> selectProductPrices(int dpInfoId);
}
