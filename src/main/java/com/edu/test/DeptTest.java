package com.edu.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.edu.MySpringBoot;
import com.edu.domain.DeptInfo;
import com.edu.service.DeptService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MySpringBoot.class)
public class DeptTest {

	@Autowired
	private DeptService deptService;

	@Test
	public void getDeptListTest() {
		List<DeptInfo> list = deptService.getDeptList();
		System.out.println(list.size());
	}

}
