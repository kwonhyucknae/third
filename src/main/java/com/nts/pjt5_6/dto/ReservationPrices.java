package com.nts.pjt5_6.dto;

public class ReservationPrices {
	private int id;
	private int reservationInfoId;
	private int productPriceId;
	private int count;
	
	public ReservationPrices() {
	}
	
	public ReservationPrices(int id,int reservationInfoId,int productPriceId,int count) {
		this.id = id;
		this.reservationInfoId = reservationInfoId;
		this.productPriceId = productPriceId;
		this.count = count;
	}
	
	public int getId() {
		return id;
	}
	public int getReservationInfoId() {
		return reservationInfoId;
	}
	public int getProductPriceId() {
		return productPriceId;
	}
	public int getCount() {
		return count;
	}
	
	@Override
	public String toString() {
		return "ReservationPrices [id=" + id + ", reservationInfoId=" + reservationInfoId + ", productPriceId="
				+ productPriceId + ", count=" + count + "]";
	}
	
	public static class Builder {
		private int id;
		private int reservationInfoId;
		private int productPriceId;
		private int count;

		public Builder setId(int id) {
			this.id = id;
			return this;
		}
		
		public Builder setReservationInfoId(int reservationInfoId) {
			this.reservationInfoId = reservationInfoId;
			return this;
		}
		
		public Builder setProductPriceId(int productPriceId) {
			this.productPriceId = productPriceId;
			return this;
		}
		
		public Builder setCount(int count) {
			this.count = count;
			return this;
		}
		
		public ReservationPrices build() {
			return new ReservationPrices(id,reservationInfoId,productPriceId,count);
		}
	}
	
}
