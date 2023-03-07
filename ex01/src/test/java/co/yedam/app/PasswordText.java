package co.yedam.app;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordText {
	@Test
	public void test() {
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder(10);  //암호화에 걸리는 시간 숫자가 클수록 오래걸리고 보안에 좋음 
		String result = bcrypt.encode("1111");  //매번 암호화할때마다 값이 달라짐
		boolean bo =  bcrypt.matches("1111", result);
		System.out.println(result);
		System.out.println(bo);
	}
}
