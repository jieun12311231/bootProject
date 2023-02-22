package com.micol.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmpMapperClient {
	@Autowired EmpMapper empMapper;

	@Test
	public void 페이징() {
		EmpSearchVO vo = new EmpSearchVO();
		vo.setFirst(10);
		vo.setLast(20);
		List<EmpVO> list = empMapper.getEmpList(vo);
		System.out.println(list.get(0));  //실행 여부만 나오면 됨
		//테이스 할때 ~인지 물어보는 명령어 제대로 되었으면 ture
		assertNotNull(list);
	}
	
	@Test
	public void 부서검색() {
		EmpSearchVO vo = new EmpSearchVO();
		vo.setFirst(1);
		vo.setLast(10);
		vo.setDepartmentId("50");
		empMapper.getEmpList(vo);
		List<EmpVO> list = empMapper.getEmpList(vo);
		System.out.println(list.get(0));
		//assertNotNull(list.get(0));  //true/false반환
		assertEquals(list.get(0).getDepartmentId(),"50");
	}
	
	@Test
	public void 직무검색() {
		EmpSearchVO vo = new EmpSearchVO();
		vo.setFirst(1);
		vo.setLast(5);
		vo.setDepartmentId("");
		vo.setJobId("IT_PROG");
		empMapper.getEmpList(vo);
		List<EmpVO> list = empMapper.getEmpList(vo);
		System.out.println(list.get(0));
		//assertNotNull(list.get(0));
		assertEquals(list.get(0).getJobId(),"IT_PROG");
	}
	
}
