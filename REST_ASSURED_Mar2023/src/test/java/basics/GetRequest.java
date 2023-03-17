package basics;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;


public class GetRequest {
	
	@Test
	public void getUsers()
	{
		RestAssured.baseURI = "https://reqres.in/";
		
	Response completeresponse = given()
		
								.when()
		
								.get("api/users?page=2")
			
								.then()
		
								.extract()
		
								.response();
	
	String stringresponse = completeresponse.asPrettyString();
	
	System.out.println(stringresponse);
	
	int stscode = completeresponse.getStatusCode();
	
	System.out.println("status code is "+stscode);
	
	long resptime = completeresponse.getTime();
	
	System.out.println(resptime);
	}
	

}


