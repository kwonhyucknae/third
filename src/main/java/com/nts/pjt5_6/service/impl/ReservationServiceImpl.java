package com.nts.pjt5_6.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nts.pjt5_6.dao.ReservationInfoPriceMapper;
import com.nts.pjt5_6.dao.ReservationInfoMapper;
import com.nts.pjt5_6.dto.ReservationInfo;
import com.nts.pjt5_6.dto.ReservationInfoByEmail;
import com.nts.pjt5_6.dto.ReservationPrices;
import com.nts.pjt5_6.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService{
	
	@Autowired
	private ReservationInfoMapper reservationMapper;
	
	@Autowired
	private ReservationInfoPriceMapper reservInfoPriceMapper;
	
	@Override
	@Transactional(readOnly=false)
	public ReservationInfo insertReservationInfo(ReservationInfo reservInfoData) {
		
		reservationMapper.insertReservationInfo(reservInfoData);
		List<ReservationPrices> reservationPrices = new ArrayList<>();
		
		for(ReservationPrices productPrice : reservInfoData.getPrices()) {
			
			ReservationPrices tempPrices = new ReservationPrices.Builder()
					.setCount(productPrice.getCount())
					.setProductPriceId(productPrice.getProductPriceId())
					.setReservationInfoId(reservInfoData.getId())
					.build();
			
			reservationPrices.add(tempPrices);
		}
		
		
		reservInfoPriceMapper.insertReservationInfoPrice(reservationPrices);
		ReservationInfo returnReservInfo = reservationMapper.selectReservationInfo(reservInfoData.getId());
		returnReservInfo.setPrices(reservInfoPriceMapper.selectReservationPrices(reservInfoData.getId()));
		
		return returnReservInfo;
	}
	
	@Override
	public List<ReservationInfoByEmail> selectReservationInfoByEmail(String emailAddr) {
		return reservationMapper.selectReservationInfoByEmail(emailAddr);
	}
	
	@Override
	public int updateReservationCancel(int reservInfoId) {
		return reservationMapper.updateReservationCancel(reservInfoId);
	}
	
	@Override
	public String getLocalDate() {
		Random random = new Random();
		String reservationDate = LocalDate.now().plusDays(random.nextInt(5)).format(DateTimeFormatter.ofPattern("yyyy.M.d"));
		return reservationDate;
	}
}
