package com.api.api.logging;

import java.lang.reflect.Type;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdviceAdapter;

@ControllerAdvice
public class CustomRequestBodyAdviceAdapter extends RequestBodyAdviceAdapter {

	@Autowired
	private LoggingService loggingService;

	@Autowired
	private HttpServletRequest httpServletRequest;

	@Override
	public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType,
			Class<? extends HttpMessageConverter<?>> converterType) {
		String queryString = httpServletRequest.getQueryString();
		if (queryString != null) {
			loggingService.logRequest(HttpRequestTraceUtil.getTraceId(httpServletRequest),
					httpServletRequest.getMethod(), httpServletRequest.getRequestURI() + "?" + queryString);
		} else {
			loggingService.logRequest(HttpRequestTraceUtil.getTraceId(httpServletRequest),
					httpServletRequest.getMethod(), httpServletRequest.getRequestURI(), body);
		}
		return super.afterBodyRead(body, inputMessage, parameter, targetType, converterType);
	}

	@Override
	public boolean supports(MethodParameter methodParameter, Type targetType,
			Class<? extends HttpMessageConverter<?>> converterType) {
		return true;
	}
}