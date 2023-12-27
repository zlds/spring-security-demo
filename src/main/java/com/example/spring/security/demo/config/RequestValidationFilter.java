package com.example.spring.security.demo.config;

import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: hanchaowei
 * @date 2023/12/27
 * @description:
 */
@Configuration
public class RequestValidationFilter implements Filter {
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {

		HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
		HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
		String requestId = httpServletRequest.getHeader("SecurityFlag");
		if (requestId == null || requestId.isBlank()) {
			httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}

		filterChain.doFilter(servletRequest, servletResponse);

	}
}
