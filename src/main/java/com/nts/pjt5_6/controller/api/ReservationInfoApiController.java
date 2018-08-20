package com.nts.pjt5_6.controller.api;



import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nts.pjt5_6.dto.ReservationInfo;
import com.nts.pjt5_6.service.ReservationService;

@RestController
@RequestMapping(path = "/api/reservationInfos")
public class ReservationInfoApiController {
	
	@Autowired
	ReservationService reservationService;
	
	@PostMapping
	public ReservationInfo addReservationInfo(@RequestBody ReservationInfo reservationInfo) {
		ReservationInfo retReservationInfo = reservationService.insertReservationInfo(reservationInfo);
		return retReservationInfo;
	}
	
	@GetMapping
	public Map<String,Object> getReservationInfoByEmail(
			@RequestParam(name = "reservationEmail", required = true) String email){
		
		Map<String,Object> reservationData = new LinkedHashMap<>();
		reservationData.put("items", reservationService.selectReservationInfoByEmail(email));
		reservationData.put("size", reservationService.selectReservationInfoByEmail(email).size());
		return reservationData;
	}
	
	@PutMapping("/{reservInfoId}")
	public void updateReservationCancel(@PathVariable(name = "reservInfoId") int reservInfoId) {
		reservationService.updateReservationCancel(reservInfoId);
	}
}
