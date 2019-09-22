package com.api.api;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

	@GetMapping("/thing")
	public Thing getThingPath(@PathParam("name") String name) {

		Thing thingOne = new Thing();
		thingOne.setName(name);
		thingOne.setAddress("34 Riley Road");
		thingOne.setCity("Northborough");
		thingOne.setState("MA");
		thingOne.setZip("01532");

		return thingOne;
	}

	@GetMapping("/thing/{name}")
	public Thing getThing(@PathVariable("name") String name) {

		Thing thingOne = new Thing();
		thingOne.setName(name);
		thingOne.setAddress("34 Riley Road");
		thingOne.setCity("Northborough");
		thingOne.setState("MA");
		thingOne.setZip("01532");

		return thingOne;
	}

	@PostMapping(value = "/thing/add")
	public Thing getThing(@RequestBody ThingTwo two) {

		Thing thingOne = new Thing();
		thingOne.setUuid("1234567890");
		thingOne.setName("Test");
		thingOne.setAddress("34 Riley Road");
		thingOne.setCity("Northborough");
		thingOne.setState("MA");
		thingOne.setZip("01532");

		return thingOne;
	}
}
