package com.nts.pjt5_6.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nts.pjt5_6.dto.ReservationInfo;
import com.nts.pjt5_6.dto.ReservationInfoByEmail;

@Mapper
public interface ReservationInfoMapper {
	public int insertReservationInfo(ReservationInfo reservationInfo);
	public ReservationInfo selectReservationInfo(int reservationInfoId);
	public List<ReservationInfoByEmail> selectReservationInfoByEmail(String emailAddr);
	public int updateReservationCancel(int reservInfoId);
}
