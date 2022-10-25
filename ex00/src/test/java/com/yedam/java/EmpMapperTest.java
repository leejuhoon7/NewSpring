package com.yedam.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.java.emp.mapper.EmpMapper;
import com.yedam.java.emp.service.EmpVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/*-context.xml")
public class EmpMapperTest {
	@Autowired
	EmpMapper mapper;

	@After
	public void testDivid() {
		System.out.println("--------------");
	}

	@Test
	public void returnObjectTest() {
		assertNotNull(mapper);
	}

	@Test
	public void empAllSelectTest() {
		List<EmpVO> empList = mapper.getEmpList();
		for (EmpVO empInfo : empList) {
			System.out.println(empInfo);
		}
	}

	//@Test
	public void empInsertTest() {
		EmpVO empVO = new EmpVO();

		empVO.setFirstName("kil-dong5");
		empVO.setLastName("Hong5");
		empVO.setEmail("abc@naver5.com");
		empVO.setJobId("IT_PROG");
		empVO.setSalary(20000);

		mapper.insertEmp(empVO);
		System.out.println(empVO.getEmployeeId());
		assertNotNull(empVO);
	}

	//@Test
	public void updateEmpSalary() {
		int result = mapper.updateEmpSalary(207);
		assertEquals(result, 1);
	}
	
	//@Test
	public void deleteEmpInfo() {
		int result = mapper.deleteEmpInfo(210);
		assertEquals(result, 1);
	}
	
	//@Test
	public void updateEmpInfo() {
		EmpVO empvo = new EmpVO();
		empvo.setEmployeeId(210);
		empvo.setFirstName("hello4");
		empvo.setLastName("world4");
		empvo.setEmail("hello4@naver.com");
		
		int result = mapper.updateEmpInfo(empvo);
		assertEquals(result, 1);
		
	}
	@Test
	public void empSelectOne() {
		List<EmpVO> empList = new ArrayList<EmpVO>();
		EmpVO empVO = new EmpVO();
		empVO.setFirstName("Steven");
		assertNotNull( mapper.getEmp(empVO));
	}
	
	

//		List<EmpVO> list = new ArrayList<EmpVO>();
//		list = mapper.getEmpList();
//		
//		System.out.println(list);

}
