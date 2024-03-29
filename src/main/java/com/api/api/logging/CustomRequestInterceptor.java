package com.api.api.logging;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.DispatcherType;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class CustomRequestInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private LoggingService loggingService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		if (DispatcherType.REQUEST.name().equals(request.getDispatcherType().name())
				&& request.getMethod().equals(HttpMethod.GET.name())) {
			String queryString = request.getQueryString();
			if (queryString != null) {
				loggingService.logRequest(HttpRequestTraceUtil.getTraceId(request), request.getMethod(),
						request.getRequestURI() + "?" + queryString);
			} else {
				loggingService.logRequest(HttpRequestTraceUtil.getTraceId(request), request.getMethod(),
						request.getRequestURI());
			}
		}
		return true;
	}
}