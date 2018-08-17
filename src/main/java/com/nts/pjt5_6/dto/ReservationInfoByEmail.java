package com.nts.pjt5_6.dto;

import java.util.Date;

public class ReservationInfoByEmail {
	private int id;
	private int productId;
	private String productDescription;
	private String productContent;
	private String reservationName;
	private String reservationTel;
	private String reservationEmail;
	private int sumPrice;
	private int cancelFlag;
	private Date reservationDate;
	private Date createDate;
	private Date modifyDate;
	
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
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public String getProductContent() {
		return productContent;
	}
	public void setProductContent(String productContent) {
		this.productContent = productContent;
	}
	public String getReservationName() {
		return reservationName;
	}
	public void setReservationName(String reservationName) {
		this.reservationName = reservationName;
	}
	public String getReservationTel() {
		return reservationTel;
	}
	public void setReservationTel(String reservationTel) {
		this.reservationTel = reservationTel;
	}
	public String getReservationEmail() {
		return reservationEmail;
	}
	public void setReservationEmail(String reservationEmail) {
		this.reservationEmail = reservationEmail;
	}
	public int getSumPrice() {
		return sumPrice;
	}
	public void setSumPrice(int sumPrice) {
		this.sumPrice = sumPrice;
	}
	public int getCancelFlag() {
		return cancelFlag;
	}
	public void setCancelFlag(int cancelFlag) {
		this.cancelFlag = cancelFlag;
	}
	public Date getReservationDate() {
		return reservationDate;
	}
	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	
	@Override
	public String toString() {
		return "ReservationInfoByEmail [id=" + id + ", productId=" + productId + ", productDescription="
				+ productDescription + ", productContent=" + productContent + ", reservationName=" + reservationName
				+ ", reservationTel=" + reservationTel + ", reservationEmail=" + reservationEmail + ", sumPrice="
				+ sumPrice + ", reservationDate=" + reservationDate + ", createDate=" + createDate + ", modifyDate="
				+ modifyDate + "]";
	}
	
	
	
}
