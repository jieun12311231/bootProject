package com.micol.demo;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
public class ObjectMapperClient {

	@Test
	public void write() throws JsonProcessingException {
		ObjectMapper ob = new ObjectMapper();
		EmpVO vo = new EmpVO();
		vo.setEmployeeId("100");
		vo.setFirstName("짱구");
		vo.setHireDate(new Date());
		String str =ob.writeValueAsString(vo);  // 자바 보를 스트링으로 바꿔줌  
		System.out.println(str);
	}
	
	@Test
	public void read() throws JsonMappingException, JsonProcessingException {
		String json= "{\"employeeId\":\"100\",\"firstName\":\"짱구\",\"lastName\":null,\"salary\":null,\"hireDate\":\"2023/02/22\",\"departmentId\":null}";
		ObjectMapper ob = new ObjectMapper();
		EmpVO vo = ob.readValue(json,EmpVO.class);  //json형식을 String 으로 바꿔줌
		System.out.println("read Test => "+vo.getFirstName());
	}
	
}
