package com.nts.pjt5_6.dto;

public class ReservationInfoByEmail {
	private int id;
	private int productId;
	private String productDescription;
	private String productContent;
	private String reservationName;
	private String reservationTel;
	private String reservationEmail;
	private int sumPrice;
	private String reservationDate;
	private String createDate;
	private String modifyDate;
	
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
	
	@Override
	public String toString() {
		return "ReservationInfoByEmail [id=" + id + ", productId=" + productId + ", productDescription="
				+ productDescription + ", productContent=" + productContent + ", reservationName=" + reservationName
				+ ", reservationTel=" + reservationTel + ", reservationEmail=" + reservationEmail + ", sumPrice="
				+ sumPrice + ", reservationDate=" + reservationDate + ", createDate=" + createDate + ", modifyDate="
				+ modifyDate + "]";
	}
	
	
	
}
