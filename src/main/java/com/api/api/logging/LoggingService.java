package com.api.api.logging;

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
	public void logResponse(String traceId, Integer status, Object object) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			if (object != null) {
				System.out.println("### " + traceId + " : " + status + " : " + objectMapper.writeValueAsString(object));
			} else {
				System.out.println("### " + traceId + " : " + status);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
