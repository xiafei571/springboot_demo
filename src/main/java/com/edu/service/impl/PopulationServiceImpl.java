package com.edu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.domain.Population;
import com.edu.repository.PopulationDAO;
import com.edu.service.PopulationService;

@Service
public class PopulationServiceImpl implements PopulationService {

	@Autowired
	private PopulationDAO populationDAO;
	
	@Override
	public Population getInfoById(Integer id) {
		return populationDAO.getOne(id);
	}

}
