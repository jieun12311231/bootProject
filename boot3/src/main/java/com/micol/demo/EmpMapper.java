package com.micol.demo;

import java.util.List;
import java.util.Map;


public interface EmpMapper {
	//List<EmpVO> getEmpList(EmpVO vo,EmpSearchVO svo);
	List<EmpVO> getEmpList(EmpSearchVO svo);
	
	//검색 페이징 조회
	int getcountTotal(EmpSearchVO svo);
	//vo대신에 map을 적어줌
	List<Map> getJobList();
	
	//rest연습 mapper는 mapper.xml보고 적으면 됨 
	EmpVO getEmp(String id);  //사원 검색
	int insertEmp(EmpVO vo); // 사원 등록
	int updateEmp(EmpVO vo);//사원 수정
	int deleteEmp(String id);//사원 삭제
	
	
}
