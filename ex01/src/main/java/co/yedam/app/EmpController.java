package co.yedam.app;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
@RestController
//@Controller //자동으로 빈으로 만들어서 컨테이너에 등록
//component-scan => 어노테이션 다 뒤져서 객체(빈)를 생성해서 스프링 컨테이너에 등록을 함 
//component: 빈만 등록
//Controller :  pojo : 아무것도 상속 없이 클래스를 만들수 있음/서블릿에서 호출할 수 있도록 command화 시킴 ★★ 
public class EmpController {

	@RequestMapping("emp")
	//EmpVO vo : command객체 /파라미터 이름과 vo에 이름이와 동일해야함 , 
	//보가 여러개들어가도 상관없지만 보안에 있는 필드이름과 같으면 됨
	//커맨드 객체는 자동으로 model에 들어감 
	//request.setAttribute() / model 굳이 안해도된
	//jsp페이지에서 vo이름을 첫글자만 소문자로 해서 불러오면 불려짐 
	
//	public String emp(@ModelAttribute("emp") EmpVO vo,@ModelAttribute("page") int page) {  //필요한게 있으면 () 안에 걍 다 적으면 됨
//		System.out.println(vo);
//		System.out.println(page);
//		return "emp";
//	}
	
//	public void emp(@ModelAttribute("emp") EmpVO vo,@ModelAttribute("page") int page) {  //필요한게 있으면 () 안에 걍 다 적으면 됨
//		System.out.println(vo);
//		System.out.println(page);
//	}
	
	//@RestController
	public ModelAndView emp(@ModelAttribute("emp") EmpVO vo,@ModelAttribute("page") int page) {  //필요한게 있으면 () 안에 걍 다 적으면 됨
		System.out.println(vo);
		System.out.println(page);
		ModelAndView mv = new ModelAndView("emp");
//		mv.setViewName("emp");
		mv.addObject("result", "success");
		return mv;
	}
	
}
