package com.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/demo")
public class QuickController {

	@RequestMapping(path="/quick",method=RequestMethod.GET)
	@ResponseBody
	public String quick() {
		return "Hello world";
	}
	
}
