package com.nts.pjt5_6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ReservationController {
	
	
	@GetMapping(path = "/main")
	public String mainConvert(ModelMap model) {
		return "main";
	}
	
	@GetMapping(path = "/detail")
	public String detailConvert(@RequestParam(name = "id" , required = true) int dpInfoId ,ModelMap model) {
		model.addAttribute("displayProductInfoId",dpInfoId);
		return "detail";
	}
	
	@GetMapping(path = "/review")
	public String reviewConvert(@RequestParam(name = "id" , required = true) int dpInfoId ,ModelMap model) {
		model.addAttribute("displayProductInfoId",dpInfoId);
		return "review";
	}
	
	@GetMapping(path = "/reserve")
	public String reserveConvert(@RequestParam(name = "id" , required = true) int dpInfoId ,ModelMap model) {
		model.addAttribute("displayProductInfoId",dpInfoId);
		return "reserve";
	}
}
