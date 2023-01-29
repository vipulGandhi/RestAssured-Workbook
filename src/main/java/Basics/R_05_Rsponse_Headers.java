package Basics;

//Static packages
import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class R_05_Rsponse_Headers
{
	@Test(priority = 1)
	void getResponseHeaders_01()
	{
		
		//base URL
		RestAssured.baseURI = "https://www.google.com/";
		
		when()
			.get()
		
		.then()
			// Validate header
			.header("Content-Type", "text/html; charset=ISO-8859-1")
			.header("Content-Encoding", "gzip");
			//.log().headers();
	}
	
	@Test(priority = 2)
	void getResponseHeaders_02()
	{
		Response response =
				
		when()
			.get("https://www.google.com/");
		
		// Get header value
		String headerValueString = response.getHeader("Content-Type");
		System.out.println(headerValueString);
		
		// Get all header values
		Headers headers = response.getHeaders();
		//System.out.println(headers);
		
		for (Header header : headers)
		{
			System.out.println(header.getName() +" :  "+ header.getValue());
		}
	}
}
