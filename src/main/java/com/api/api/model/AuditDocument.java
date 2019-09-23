package com.api.api.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "AuditDocument")
public class AuditDocument {

	String traceId;

	String httpMethod;

	Integer httpStatus;

	String path;

	String data;

	public AuditDocument(String traceId, String httpMethod, Integer httpStatus, String path, String data) {
		this.traceId = traceId;
		this.httpMethod = httpMethod;
		this.httpStatus = httpStatus;
		this.path = path;
		this.data = data;
	}

	public String getTraceId() {
		return traceId;
	}

	public void setTraceId(String traceId) {
		this.traceId = traceId;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Integer getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(Integer httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getHttpMethod() {
		return httpMethod;
	}

	public void setHttpMethod(String httpMethod) {
		this.httpMethod = httpMethod;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
