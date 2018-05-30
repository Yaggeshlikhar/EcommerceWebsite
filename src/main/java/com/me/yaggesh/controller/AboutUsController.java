package com.me.yaggesh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/aboutUs.htm")
public class AboutUsController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String initializeForm()
	{
		return "aboutUs";
	}

}
