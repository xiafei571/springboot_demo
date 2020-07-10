package com.edu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.edu.domain.DeptInfo;

@Mapper
public interface DeptMapper {


	@Select("select deptno, dname, loc from dept")
	@ResultMap("deptResultMap")
	List<DeptInfo> getDeptList();

	@Select("select count(*) from dept")
	Integer getDeptCount();

	@Select("select * from dept where deptno = #{id}")
	DeptInfo getDeptById(@Param("id") Integer deptno);

	Integer addDept(DeptInfo dept);

	Integer updateDept(DeptInfo dept);

	@Delete("delete from dept where deptno = #{deptno}")
	Integer deleteDept(Integer deptno);

	@Select("select deptno, dname, loc from dept limit #{cursor}, #{offset}")
	@ResultMap("deptResultMap")
	List<DeptInfo> getDeptPage(@Param("cursor") Integer cursor, @Param("offset") Integer offset);


}
