package com.edu.service;

import java.util.List;

import com.edu.domain.DeptInfo;

public interface DeptService {

	List<DeptInfo> getDeptList();

	Integer getDeptCount();

	DeptInfo getDeptById(Integer deptno);

	Integer addDept(DeptInfo dept);

	Integer updateDept(DeptInfo dept);

	Integer deleteDept(Integer deptno);

}
