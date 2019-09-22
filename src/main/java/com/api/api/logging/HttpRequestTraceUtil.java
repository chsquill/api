package com.api.api.logging;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

public class HttpRequestTraceUtil {

	public static String getTraceId(HttpServletRequest request) {
		if (request.getAttribute("LOC_TRACE_ID") == null) {
			request.setAttribute("LOC_TRACE_ID", UUID.randomUUID());
		}
		return request.getAttribute("LOC_TRACE_ID").toString();
	}
}
