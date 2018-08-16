package com.nts.pjt5_6.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nts.pjt5_6.dao.ReservationMapper;
import com.nts.pjt5_6.dto.ReservationInfo;
import com.nts.pjt5_6.dto.ReservationInfoByEmail;
import com.nts.pjt5_6.dto.ReservationPrices;
import com.nts.pjt5_6.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService{
	
	@Autowired
	ReservationMapper reservationMapper;
	
	@Override
	@Transactional(readOnly=false)
	public ReservationInfo insertReservationInfo(ReservationInfo reservInfoData) {
		
		int insertCount = reservationMapper.insertReservationInfo(reservInfoData);
		
		List<ReservationPrices> reservationPrices = new ArrayList<>();
		
		for(int i=0;i<reservInfoData.getPrices().size();i++) {
			
			ReservationPrices tempPrices = new ReservationPrices.Builder()
					.setCount(reservInfoData.getPrices().get(i).getCount())
					.setProductPriceId(reservInfoData.getPrices().get(i).getProductPriceId())
					.setReservationInfoId(reservInfoData.getId())
					.build();
			
			reservationPrices.add(tempPrices);
		}
		
		
		reservationMapper.insertReservationInfoPrice(reservationPrices);
		ReservationInfo returnReservInfo = reservationMapper.selectReservationInfo(reservInfoData.getId());
		returnReservInfo.setPrices(reservationMapper.selectReservationPrices(reservInfoData.getId()));
		
		System.out.println(returnReservInfo);
		
		return returnReservInfo;
	}
	
	@Override
	public List<ReservationInfoByEmail> selectReservationInfoByEmail(String emailAddr) {
		return reservationMapper.selectReservationInfoByEmail(emailAddr);
	}
	
	@Override
	public int insertReservationInfoPrice(List<ReservationPrices> reservationPrices) {
		int insertCount = reservationMapper.insertReservationInfoPrice(reservationPrices);
		return insertCount;
	}
}
