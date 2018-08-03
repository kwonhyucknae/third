package com.nts.pjt3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path= "/errorPages")
public class ErrorPageConvertController {
	
	@GetMapping(path="/404")
	public String pageError404(ModelMap model) {
		model.addAttribute("errorCode","404");
		model.addAttribute("msg","요청한 페이지가 존재하지 않습니다.");
		return "error";
	}
	
	@GetMapping(path="/500")
	public String pageError500(ModelMap model) {
		model.addAttribute("errorCode","500");
		model.addAttribute("msg","서버에 오류가 발생했습니다.");
		return "error";
	}
}
