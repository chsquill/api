package com.api.api.model;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface LocationAuditRepository extends MongoRepository<AuditDocument, String> {

	// { 'location' : { '$near' : [point.x, point.y], '$maxDistance' : distance}}
	// List<Person> findByLocationNear(Point location, Distance distance);
}
