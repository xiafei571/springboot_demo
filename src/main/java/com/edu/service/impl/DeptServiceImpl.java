package com.edu.service.impl;

import java.util.List;

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
	public List<DeptInfo> getDeptList() {
		return deptMapper.getDeptList();
	}

	@Override
	public Integer getDeptCount() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeptInfo getDeptById(Integer deptno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer addDept(DeptInfo dept) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer updateDept(DeptInfo dept) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteDept(Integer deptno) {
		// TODO Auto-generated method stub
		return null;
	}

}
