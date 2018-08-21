package com.nts.pjt5_6.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nts.pjt5_6.dao.ReservationUserCommentMapper;
import com.nts.pjt5_6.dao.DisplayInfoImageMapper;
import com.nts.pjt5_6.dao.DisplayInfoMapper;
import com.nts.pjt5_6.dao.ProductImageMapper;
import com.nts.pjt5_6.dao.ProductMapper;
import com.nts.pjt5_6.dao.ProductPriceMapper;
import com.nts.pjt5_6.dao.ReservationUserCommentImageMapper;
import com.nts.pjt5_6.dto.Comments;
import com.nts.pjt5_6.dto.DisplayInfoImages;
import com.nts.pjt5_6.dto.Product;
import com.nts.pjt5_6.dto.ProductImages;
import com.nts.pjt5_6.dto.ProductPrices;
import com.nts.pjt5_6.dto.ReservationUserCommentImages;
import com.nts.pjt5_6.service.DisplayInfoService;

@Service
public class DisplayInfoServiceImpl implements DisplayInfoService{
	@Autowired
	ProductMapper prodMapper;
	@Autowired
	ProductImageMapper prodImgMapper;
	@Autowired
	DisplayInfoMapper displayInfoMapper;
	@Autowired
	DisplayInfoImageMapper dispInfoImgMapper;
	@Autowired
	ReservationUserCommentImageMapper reservCommentImg;
	@Autowired
	ReservationUserCommentMapper commentMapper;
	@Autowired
	ProductPriceMapper prodPriceMapper;
	
	@Override
	public Product getProductById(int dpInfoId) {
		return prodMapper.selectProductByDisplayId(dpInfoId);
	}
	
	@Override
	public List<ProductImages> getProductImagesInfo(int dpInfoId) {
		return prodImgMapper.selectProductImagesInfoByDispId(dpInfoId);
	}
	
	@Override
	public List<DisplayInfoImages> getDisplayImagesInfo(int dpInfoId) {
		return dispInfoImgMapper.selectDisplayImagesInfo(dpInfoId);
	}

	@Override
	public List<ReservationUserCommentImages> getCommentImagesByCommentID(int commentID) {
		return reservCommentImg.selectCommentImagesByCommentId(commentID);
	}

	@Override
	public List<Comments> getComments(int dpInfoId) {
		List<Comments> temporaryList = commentMapper.selectCommentsByDisplayId(dpInfoId);
		for (int i = 0; i < temporaryList.size(); i++) {
			List<ReservationUserCommentImages> commentImagesByCommentId = getCommentImagesByCommentID(
					temporaryList.get(i).getId());
			temporaryList.get(i).setUserCommentImages(commentImagesByCommentId);
		}
		return temporaryList;
	}

	@Override
	public double getAvgScore(int dpInfoId) {
		return displayInfoMapper.selectAvgScore(dpInfoId);
	}

	@Override
	public List<ProductPrices> getProductPrices(int dpInfoId) {
		return prodPriceMapper.selectProductPrices(dpInfoId);
	}
}
