package com.nts.pjt5_6.dto;

import org.springframework.web.multipart.MultipartFile;

public class CommentWrite {
	private int id;
	private int productId;
	private int reservationInfoId;
	private int score;
	private String comment;
	private MultipartFile commentImageFile;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getReservationInfoId() {
		return reservationInfoId;
	}
	public void setReservationInfoId(int reservationInfoId) {
		this.reservationInfoId = reservationInfoId;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public MultipartFile getCommentImageFile() {
		return commentImageFile;
	}
	public void setCommentImageFile(MultipartFile commentImageFile) {
		this.commentImageFile = commentImageFile;
	}
	@Override
	public String toString() {
		return "CommentWrite [id=" + id + ", productId=" + productId + ", reservationInfoId=" + reservationInfoId
				+ ", score=" + score + ", comment=" + comment + ", commentImageFile=" + commentImageFile + "]";
	}
	
}
