package com.nts.pjt3.dto;

public class ProductPrices {

	private int id;
	private int productId;
	private String priceTypeName;
	private int price;
	private int discountRate;
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
	public String getPriceTypeName() {
		return priceTypeName;
	}
	public void setPriceTypeName(String priceTypeName) {
		this.priceTypeName = priceTypeName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getDiscountRate() {
		return discountRate;
	}
	public void setDiscountRate(int discountRate) {
		this.discountRate = discountRate;
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
		return "ProductPrices [id=" + id + ", productId=" + productId + ", priceTypeName=" + priceTypeName + ", price="
				+ price + ", discountRate=" + discountRate + ", createDate=" + createDate + ", modifyDate=" + modifyDate
				+ "]";
	}
	
	
}
