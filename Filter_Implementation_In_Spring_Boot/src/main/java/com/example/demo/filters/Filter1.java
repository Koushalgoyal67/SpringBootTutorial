package com.example.demo.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class Filter1 implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		
		System.out.println("I am in Filter 1 before doFilter "+req.getRequestURL());
		
		chain.doFilter(request, response);
		
		
		System.out.println("I am in Filter 1 after do Filter ");
		
	}
	
	 public void init(FilterConfig filterConfig) {}

	 public void destroy() {}

}
