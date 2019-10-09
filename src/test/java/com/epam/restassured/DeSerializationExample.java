package com.epam.restassured;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import io.restassured.RestAssured;

public class DeSerializationExample {
	@Test
	public void testDeserailization() {
		Phone phone = RestAssured.given().contentType("application/json").when().get("/makeYear/12").as(Phone.class);
		assertEquals("12", phone.getMake());
	}
}

class Phone {

	String make;
	String model;
	int year;

	public Phone() {
	}

	public Phone(String make, String model, int year) {

		this.make = make;
		this.model = model;
		this.year = year;
	}

	public String getMake() {
		return this.make;
	}

	public void setMake(String make) {
		this.make = make;
	}
}