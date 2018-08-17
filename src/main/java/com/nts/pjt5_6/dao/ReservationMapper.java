package com.nts.pjt5_6.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nts.pjt5_6.dto.ReservationInfo;
import com.nts.pjt5_6.dto.ReservationInfoByEmail;
import com.nts.pjt5_6.dto.ReservationPrices;

@Mapper
public interface ReservationMapper {
	public int insertReservationInfo(ReservationInfo reservationInfo);
	public int insertReservationInfoPrice(List<ReservationPrices> reservationPrices);
	public ReservationInfo selectReservationInfo(int reservationInfoId);
	public List<ReservationPrices> selectReservationPrices(int reservationInfoId);
	public List<ReservationInfoByEmail> selectReservationInfoByEmail(String emailAddr);
	public int updateReservationCancel(int reservInfoId);
}
