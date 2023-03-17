package basics;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class MockJasonResponse {
	
	
	//5. Print no of copies sold by RPA Course
	@Test
	public void getRPAPrice()
	{
		JsonPath jp = new JsonPath("{\r\n"
				+ "\"dashboard\": {\r\n"
				+ "\"purchaseAmount\": 910,\r\n"
				+ "\"website\": \"www.abc.com\"\r\n"
				+ "},\r\n"
				+ "\"courses\": [\r\n"
				+ "{\r\n"
				+ "\"title\": \"Selenium Python\",\r\n"
				+ "\"price\": 50,\r\n"
				+ "\"copies\": 6\r\n"
				+ "},\r\n"
				+ "{\r\n"
				+ "\"title\": \"Cypress\",\r\n"
				+ "\"price\": 40,\r\n"
				+ "\"copies\": 4\r\n"
				+ "},\r\n"
				+ "{\r\n"
				+ "\"title\": \"RPA\",\r\n"
				+ "\"price\": 45,\r\n"
				+ "\"copies\": 10\r\n"
				+ "}\r\n"
				+ "]\r\n"
				+ "}");
		
		int size = jp.getInt("courses.size()");
		
		for(int i=0; i<size; i++)
		{
			String coursetitle= jp.getString("courses["+i+"].title");
			
			if(coursetitle.equals("RPA"))
			{
				int copies = jp.getInt("courses["+i+"].copies");
				System.out.println(copies);
			}
		}
	}
	
	
	//6. Verify if Sum of all Course prices matches with Purchase Amount
	@Test
	public void validateTotalPrice() {
		int sum =0;
		JsonPath jp = new JsonPath(JsonBody.getBody());
		
		int coursecount = jp.getInt("courses.size()");
		
		for(int i=0; i<coursecount; i++)
		{
			int pricevalue = jp.getInt("courses["+i+"].price");
			int copiesvalue = jp.getInt("courses["+i+"].copies");
			
			sum = sum  + pricevalue*copiesvalue;
		}
		
		int totalamount = jp.getInt("dashboard.purchaseAmount");
		
		Assert.assertEquals(sum, totalamount);
	}
	
	
	//1. Print No of courses returned by API
	@Test
	public void noOfCoursesByAPI()
	{
		JsonPath jp = new JsonPath(JsonBody.getBody());
		
		int coursecount = jp.getInt("courses.size()");
		
		System.out.println(coursecount);
	}
	
	//2. Print Purchase Amount
	@Test
	public void getPurchaseAmount()
	{
		JsonPath jp = new JsonPath(JsonBody.getBody());
		
		int purchaseAmount = jp.getInt("dashboard.purchaseAmount");
		
		System.out.println(purchaseAmount);
	}
	
	//3. Print Title of the first course
	@Test
	public void getTitleofFirstCourse()
	{
		JsonPath jp = new JsonPath(JsonBody.getBody());
		
		String firstcourseTitle = jp.getString("courses[0].title");
		
		System.out.println(firstcourseTitle);
	}
	
	//4. Print All course titles and their respective Prices
	@Test
	public void getCourseTitleAndPrice()
	{
		JsonPath jp = new JsonPath(JsonBody.getBody());
		
		String courseTitle = jp.getString("courses.title");
		
		System.out.println(courseTitle);
		
//		int coursePrice = jp.getInt("courses.price()");
		
//		System.out.println(coursePrice);
	}
	
	
}
