package com.micol.demo;

import java.util.Collections;
import java.util.Map;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@CrossOrigin
public class EmpController {
	@Autowired EmpMapper empMapper;
	
	//Logger logger = LoggerFactory.getLogger(EmpController.class);  //로그 찍기
	
//	@ResponseBody
//	public List<EmpVO> empList(){
//		return empMapper.getEmpList();
//	}
	
//페이징 검색
	@GetMapping("/empList")  //커맨드 객체  => 자동으로 모델에 저장이 됨  =>> 따로 모델에 저장addattribute하지 않아도됨
	//public String empList(Model model, EmpVO vo,EmpSearchVO svo,Paging paging){  //Paging paging => 페이지라는 파라미터만 보내면 자동으로 페이징에 들어옴 -> 
		public String empList(Model model,@ModelAttribute("esvo")EmpSearchVO svo,Paging paging ){  //Paging paging => 페이지라는 파라미터만 보내면 자동으로 페이징에 들어옴 -> 
		paging.setPageUnit(10);  //한페이지에 출력할 레코드 건수
		//paging.setPageSize(3); //하단에 출력되는 페이지 목록 번호
		svo.setFirst(paging.getFirst());
		svo.setLast(paging.getLast());
		paging.setTotalRecord(empMapper.getcountTotal(svo));
//		model.addAttribute("empList",empMapper.getEmpList(vo,svo));
		model.addAttribute("empList",empMapper.getEmpList(svo));  
		model.addAttribute("jobList",empMapper.getJobList());  //
		//logger.debug("!!!!empList 실행!!!!");
		log.debug("!!!!empList 실행!!!!");
		return "empList";
	}
	
	@GetMapping("/emp/{id}")  //단건조회  url에 같이 넘겨줌 => 안에 있는 파라미터만 받아오고싶으면 
	@ResponseBody  //java vo객체를 json구조의 String 으로 변환 시켜줌 
	//	@GetMapping("/emp/{id}/{name}")  //단건조회  url에 같이 넘겨줌 => 안에 있는 파라미터만 받아오고싶으면 
//	public EmpVO getEmp(@PathVariable String id,@PathVariable String name) {
		public EmpVO getEmp(@PathVariable String id) {
		return empMapper.getEmp(id);
	}
	
	@DeleteMapping("/emp/{id}")  //삭제
	@ResponseBody
	public Map<String,Object> deleteEmp(@PathVariable String id) {
		empMapper.deleteEmp(id);
		return Collections.singletonMap("result", "success");
	}
	
	@PostMapping("/emp")  //등록
	@ResponseBody
	public EmpVO insertEmp(EmpVO vo) {
		empMapper.insertEmp(vo);
		return vo;
	}
	
//	@PutMapping("/emp")  //수정
//	@ResponseBody
//	public EmpVO updateEmp(EmpVO vo) {
//		empMapper.updateEmp(vo);
//		return vo;
//	}
	@PutMapping("/emp")  //수정 부메랑으로 Json으로 보낼때
	@ResponseBody
	public EmpVO updateEmp(@RequestBody EmpVO vo) {  //json으로 보내면 컨트롤러에서는 @RequestBody꼭 넣어줘야함 
		empMapper.updateEmp(vo);
		return vo;
	}
	
	
	
}
