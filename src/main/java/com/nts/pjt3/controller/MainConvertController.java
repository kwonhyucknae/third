package com.nts.pjt3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainConvertController {
	
	@GetMapping(path="/main")
	public String mainConvert(ModelMap model) {
		return "main";
	}
}
