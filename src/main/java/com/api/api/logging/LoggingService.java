package com.api.api.logging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.api.model.AuditDocument;
import com.api.api.model.LocationAuditRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Transactional
public class LoggingService {

	@Autowired
	private LocationAuditRepository repo;

	@Async
	public void logRequest(String traceId, String type, String path) {
		try {
			System.out.println("### " + traceId + " : " + type + " : " + path);
			repo.save(new AuditDocument(traceId, type, null, path, null));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Async
	public void logRequest(String traceId, String type, String path, Object object) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			System.out.println("### " + traceId + " : " + type + " : " + objectMapper.writeValueAsString(object));
			repo.save(new AuditDocument(traceId, type, null, path, objectMapper.writeValueAsString(object)));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Async
	public void logResponse(String traceId, Integer status, Object object) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			if (object != null) {
				System.out.println("### " + traceId + " : " + status + " : " + objectMapper.writeValueAsString(object));
				repo.save(new AuditDocument(traceId, null, status, null, objectMapper.writeValueAsString(object)));
			} else {
				System.out.println("### " + traceId + " : " + status);
				repo.save(new AuditDocument(traceId, null, status, null, null));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
