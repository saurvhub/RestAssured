package com.epam.restassured;

import org.json.simple.JSONObject;
import org.junit.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PostMethod {

	@Test
	public void RegistrationSuccessful() {
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		JSONObject requestParams = new JSONObject();
		requestParams.put("FirstName", "Virender");
		requestParams.put("LastName", "Singh");
		requestParams.put("UserName", "simrpleuser001");
		requestParams.put("Password", "password1");
		requestParams.put("Email", "sometruser@gmail.com");
		RestAssured.given().accept(ContentType.JSON).body(requestParams.toJSONString())
				.post("/register").then().statusCode(201);
	}
}