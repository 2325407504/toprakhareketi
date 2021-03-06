package com.aripd.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ExecuteTimeInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = Logger
			.getLogger(ExecuteTimeInterceptor.class);

	// before the actual handler will be executed
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		long startTime = System.currentTimeMillis();
		request.setAttribute("startTime", startTime);

		return true;
	}

	// after the handler is executed
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		long startTime = (Long) request.getAttribute("startTime");

		long endTime = System.currentTimeMillis();

		long executeTime = endTime - startTime;

		// modified the exisitng modelAndView
		// TODO datatables kullanırken ve ajax da haa veriyor ve sayfa yüklenirken sorun çıkabiliyor
		//modelAndView.addObject("executeTime", executeTime);

		// log it
		if (logger.isDebugEnabled()) {
			logger.debug("[" + handler + "] executeTime : " + executeTime
					+ "ms");
		}
		
		System.out.println("executeTime : " + executeTime + "ms");

	}

}
