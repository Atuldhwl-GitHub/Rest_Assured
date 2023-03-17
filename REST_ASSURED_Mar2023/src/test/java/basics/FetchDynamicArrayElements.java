package basics;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class FetchDynamicArrayElements {
	
	@Test
	public void getUsers()
	{
		RestAssured.baseURI = "https://reqres.in/";
		
		Response completeresponse = given()
		
									.when()
		
									.get("/api/users?page=2")
		
									.then()
		
									.extract()
		
									.response();
								
								
		JsonPath jasonpath = completeresponse.jsonPath();
		
		
		int countofelemnts = jasonpath.getInt("data.size()");
		
		
		System.out.println(countofelemnts);
		
		for(int i=0; i<countofelemnts; i++)
		{
			String emailvaule = jasonpath.getString("data["+i+"].email");
			
			System.out.println(emailvaule);
		}
		
	}

}
