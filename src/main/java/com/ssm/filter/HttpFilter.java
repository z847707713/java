package com.ssm.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class HttpFilter implements Filter{

   FilterConfig filterConfig;
	
	public FilterConfig getFilterConfig() {
		return filterConfig;
	}
	
	public void destroy() {
		
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		doFilter(request,response,chain);
	}
	
	public abstract void doFilter(HttpServletRequest request,HttpServletResponse response, FilterChain chain);

	public void init(FilterConfig config) throws ServletException {
		this.filterConfig = config;
		init();
	}
    
	public void init() {
		
	}

}
