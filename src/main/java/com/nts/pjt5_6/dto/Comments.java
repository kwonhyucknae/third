package com.nts.pjt5_6.dto;

import java.util.List;

public class Comments {
	private int id;
	private int productId;
	private int reservationInfoId;
	private int score;
	private String comment;
	private String reservationEmail;
	private String reservationDate;
	private String createDate;
	private String modifyDate;
	private List<ReservationUserCommentImages> userCommentImages;
	
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
	public String getReservationEmail() {
		return reservationEmail;
	}
	public void setReservationEmail(String reservationName) {
		this.reservationEmail = reservationName;
	}
	public String getReservationDate() {
		return reservationDate;
	}
	public void setReservationDate(String reservationDate) {
		this.reservationDate = reservationDate;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}
	public List<ReservationUserCommentImages> getUserCommentImages() {
		return userCommentImages;
	}
	public void setUserCommentImages(List<ReservationUserCommentImages> userCommentImages) {
		this.userCommentImages = userCommentImages;
	}
	
	@Override
	public String toString() {
		return "Comments [id=" + id + ", productId=" + productId + ", reservationInfoId=" + reservationInfoId
				+ ", score=" + score + ", comment=" + comment + ", reservationName=" + reservationEmail
				+ ", reservationDate=" + reservationDate + ", createDate=" + createDate + ", modifyDate=" + modifyDate
				+ ", userCommentImages=" + userCommentImages + "]";
	}
	
}
