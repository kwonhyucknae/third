package com.nts.pjt5_6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nts.pjt5_6.dto.Product;
import com.nts.pjt5_6.service.ProductService;


@Controller
public class ReservationController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping(path = "/main")
	public String mainConvert() {
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
	
	@GetMapping(path = "/myreservation")
	public String myReservationConvert() {
		return "myreservation";
	}
	
	@GetMapping(path = "/reviewWrite")
	public String reviewWriteFormConvert(@RequestParam(name = "productId" , required = true) int productId,
			@RequestParam(name = "reservInfoId" , required = true) int reservInfoId, ModelMap model) {
		Product productById = productService.getProductById(productId);
		model.addAttribute("productId",productId);
		model.addAttribute("reservInfoId",reservInfoId);
		model.addAttribute("description",productById.getDescription());
		return "reviewWrite";
	}
}
