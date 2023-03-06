package com.micol.demo;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Bean // 빈 설정하는 것
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((requests) -> requests // 람다식
				.antMatchers("/", "/home").permitAll() // 아무나 접근이 가능한 페이지
				.anyRequest().authenticated()) // 나머지 페이지는 인증이 있어야한다
				.formLogin((form) -> form.loginPage("/login").permitAll()).logout((logout) -> logout.permitAll());

		return http.build();
	}

	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user = User.withDefaultPasswordEncoder()
				.username("user")
				.password("abcd")
				.roles("USER")
				.build();
		UserDetails admin = User.withDefaultPasswordEncoder() // 암호화 되었다는 의미
				.username("admin")
				.password("abcd")
				.roles("USER")
				.build();
				System.out.println(user.getPassword());
		return new InMemoryUserDetailsManager(user, admin);
	}

	public void configure(WebSecurity web) throws Exception {
		web.ignoring().requestMatchers(PathRequest.toStaticResources()
				.atCommonLocations());
	}
}
