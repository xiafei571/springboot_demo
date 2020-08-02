package com.edu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.domain.DeptInfo;
import com.edu.mapper.DeptMapper;
import com.edu.service.DeptService;

@Service
public class DeptServiceImpl implements DeptService {
	
	@Autowired
	private DeptMapper deptMapper;

	@Override
	public DeptInfo getDeptById(Integer deptno) {
		return deptMapper.getDeptById(deptno);
	}

}
