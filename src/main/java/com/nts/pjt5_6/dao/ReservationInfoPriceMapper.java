package com.nts.pjt5_6.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nts.pjt5_6.dto.ReservationPrices;

@Mapper
public interface ReservationInfoPriceMapper {
	public int insertReservationInfoPrice(List<ReservationPrices> reservationPrices);
	public List<ReservationPrices> selectReservationPrices(int reservationInfoId);
}
