package com.ronit.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.ronit.enums.ClientType;
import com.ronit.utils.TokenManager;

//@WebFilter({"/company/*"
//	
//})
public class CompanyAuthorizationFilter implements Filter{
	
	@Autowired
	private TokenManager tokenManager;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
	      System.out.println(">>> CompanyAuthorizationFilter " + Thread.currentThread().getName() + "  started");
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
	      String token = httpServletRequest.getHeader("authorization");
			boolean isAuthorized = tokenManager.isTokenExists(token);
		      boolean isAuthorizedForComapny = tokenManager.isAuthorizedFor(token, ClientType.COMPANY);
//		boolean isAuthorized = tokenManager.isTokenExists(httpServletRequest.getHeader("authorization"));
		String x =httpServletRequest.getHeader("authorization");
		System.out.println("value of the header " + x);
		if (isAuthorized && isAuthorizedForComapny) {
			chain.doFilter(request, response);
//			return;
		}else {
			httpServletResponse.sendError(HttpStatus.FORBIDDEN.value());
		}
	}

	

}
