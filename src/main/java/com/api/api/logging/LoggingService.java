package com.api.api.logging;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class LoggingService {

	// @Async
	public void logRequest(String traceId, String type, String path) {
		try {
			System.out.println("### " + traceId + " : " + type + " : " + path);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// @Async
	public void logRequest(String traceId, String type, String path, Object object) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			System.out.println("### " + traceId + " : " + type + " : " + objectMapper.writeValueAsString(object));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// @Async
	public void logResponse(HttpServletRequest request, HttpServletResponse response, Object object) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			String traceId = HttpRequestTraceUtil.getTraceId(request);
			System.out.println("### " + traceId + " : " + objectMapper.writeValueAsString(object));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
