package Basics;

//Static packages
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class R_04_Response_Cookies
{
	@Test(priority = 1)
	void getResponseCookies_01()
	{
		when()
			.get("https://www.google.com/")
		
		.then()
			// Check if cookie is present
			.cookie("AEC");
	}
	
	@Test(priority = 2)
	void getResponseCookies_02()
	{
		Response response =
				
		when()
			.get("https://www.google.com/");
		
		// Get cookie value
		String cookieValueString = response.getCookie("AEC");
		System.out.println(cookieValueString);
		
		// Get all cookies values
		Map<String, String> hasMap = response.getCookies();
		
		// Get HashMap Keys
		System.out.println(hasMap.keySet());
		
		// Get all respective values of HashMap Keys
		for (String iterable_element : hasMap.keySet())
		{
			System.out.println(response.getCookie(iterable_element));
		}
		
	}
}
