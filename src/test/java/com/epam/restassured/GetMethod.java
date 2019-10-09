package com.epam.restassured;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetMethod {

	private static final int SUCCESS_CODE = 200;

	@Test
	public void GetWeatherDetails() {
		
		String cityName = "Pune";
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given().log().all();
		Response response = httpRequest.get("/" + cityName);
		JsonPath jsonPath = response.jsonPath();
		assertEquals(SUCCESS_CODE, response.getStatusCode());
		assertEquals(cityName, jsonPath.get("City"));

	}

}