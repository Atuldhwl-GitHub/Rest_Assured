package basics;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Get_SingleUser {
	
	@Test
	public void getSingleUser()
	{
		RestAssured.baseURI = "https://reqres.in/";
		
		Response response = given()
		
							.log().all()
		
							.when()
		
							.get("/api/users?page=2")
		
							.then()
		
							.log().all()
		
							.extract()
		
							.response();
		
		String stringresponse = response.asPrettyString();
	// fetch the value from JSON response 
		
		JsonPath jp = response.jsonPath();
		
		String emailvalue = jp.getString("data.email");
		
		System.out.println(emailvalue);
		
		
//		WAP to fetch all the value of firstname for all index positions
		
		for(int i=0; i<6; i++)
		{
			String firstname = jp.getString("data["+i+"].first_name");
			
			System.out.println(firstname);
		}

		
		
}

}
