package com.nts.pjt5_6.service;

import java.util.List;

import com.nts.pjt5_6.dto.ReservationInfo;
import com.nts.pjt5_6.dto.ReservationInfoByEmail;
import com.nts.pjt5_6.dto.ReservationPrices;

public interface ReservationService {
	public ReservationInfo insertReservationInfo(ReservationInfo reservInfoData);
	public List<ReservationInfoByEmail> selectReservationInfoByEmail(String emailAddr);
	public int insertReservationInfoPrice(List<ReservationPrices> reservationPrices);
}
