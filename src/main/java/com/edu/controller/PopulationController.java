package com.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edu.service.PopulationService;

@Controller
@RequestMapping("/pop")
public class PopulationController {

	@Autowired
	private PopulationService populationService;

	@RequestMapping("/info/{id}")
	@ResponseBody
	public String getInfoById(@PathVariable Integer id) {
		// 访问 http://localhost:8080/pop/info/1
		return populationService.getInfoById(id).toString();
	}
}
