package co.yedam.app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// TODO Auto-generated method stub
		request.getSession().setAttribute("id", authentication.getPrincipal());  //getPrincipal : id
		request.getSession().setAttribute("name", authentication.getName());  //getPrincipal : id
		String path = request.getContextPath();
		response.sendRedirect(path + "/top.jsp");
	}

}
