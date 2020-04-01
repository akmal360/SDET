package com.RestAssured.SDET;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class T002_POST_Request {

	@Test
	void postWeatherDetails() {
		// specified the url
		 RestAssured.baseURI="http://restapi.demoqa.com/customer";

		// request object
		 //Specify base URI
		  RestAssured.baseURI="http://restapi.demoqa.com/customer";
		  
		  //Request object
		  RequestSpecification httpRequest=RestAssured.given();
		  
		   
		  //Request paylaod sending along with post request
		  JSONObject requestParams=new JSONObject();
		  
		  requestParams.put("FirstName","JohnXYZqqw");
		  requestParams.put("LastName","XYZJohnqqw");
		  requestParams.put("UserName","JohnXYZqqw");
		  requestParams.put("Password","JohnXYZxyxqqw");
		  requestParams.put("Email","JohnXYZqqw@gmail.com");
		  
		  httpRequest.header("Content-Type","application/json");
		  
		  httpRequest.body(requestParams.toJSONString()); // attach above data to the request
		  
		  //Response object
		  Response response=httpRequest.request(Method.POST,"/register");
		    
		  
		  //print response in console window
		  
		  String responseBody=response.getBody().asString();
		  System.out.println("Response Body is:" +responseBody);
		  
		  //status code validation
		  int statusCode=response.getStatusCode();
		  System.out.println("Status code is: "+statusCode);
		  Assert.assertEquals(statusCode, 201);
		  
		  //success code validation
		  String successCode=response.jsonPath().get("SuccessCode");
		  Assert.assertEquals(successCode, "OPERATION_SUCCESS");
		  
		 }
		 

}
