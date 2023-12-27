package com.example.spring.security.demo.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

/**
 * @author: hanchaowei
 * @date 2023/12/27
 * @description:
 */
@Configuration
public class WebConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// 设置过滤器执行顺序
		http.addFilterBefore(
				new RequestValidationFilter(),
				BasicAuthenticationFilter.class
				)
				.addFilterAfter(
						new LoggingFilter(),
						BasicAuthenticationFilter.class
				)
				.authorizeRequests().anyRequest().permitAll();
	}
}
