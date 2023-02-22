package com.micol.demo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)  //null값이 들어간 필드를 받아오지않도록 
public class EmpVO {
	String email;
	String phoneNumber;

//	@JsonIgnore // jobId을 출력하고 싶지않을때
	String jobId;
//	@JsonProperty(value = "empId")
	String employeeId;
	String firstName;
	String lastName;
	String salary;
	@JsonFormat(pattern = "yyyy/MM/dd")
	Date hireDate;
	String departmentId;

	// 검색에 사용 되는 보 //-> 상속 받으면 안적어 줘도 됨
//	Integer first;
//	Integer last;
//	String keyword;
}
