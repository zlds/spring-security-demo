package com.example.spring.security.demo.config;


import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * @author: hanchaowei
 * @date 2023/12/27
 * @description:
 */
@Configuration
public class LoggingFilter implements Filter {

	private final Logger logger = Logger.getLogger(LoggingFilter.class.getName());

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
		// 从ServletRequest中获取请求的URL
		String url = httpServletRequest.getRequestURL().toString();
		logger.info("拦截器获取到的URL: " + url);
		String cookie = httpServletRequest.getHeader("Cookie");
		logger.info("成功对请求进行了认证： " +  cookie);

		// 将请求继续在过滤器链上进行传递
		filterChain.doFilter(servletRequest, servletResponse);
	}
}
