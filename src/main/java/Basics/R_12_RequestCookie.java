package Basics;

import static io.restassured.RestAssured.*;

//Static packages
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.http.Cookie;
import io.restassured.response.Response;

public class R_12_RequestCookie
{
	@Test(priority = 1)
	void sendCookieAsNameValuePair()
	{
		Response response =
				
				given()
				  .baseUri("http://localhost")
				  .basePath("api/users")
				  .cookie("first_name", "John")
				  .get("/2");
	}
	
	@Test(priority = 2)
	// create 2 cookies
		// first_name=John
		// last_name=Watson
	void sendMultipleCookies()
	{
		Response response =
				given()
				  .baseUri("http://localhost")
				  .basePath("api/users")
				  .cookies("first_name", "John", "last_name","Watson")
				  .get("/2");
	}
	
	@Test(priority = 3)
	// send two cookies like below.
		// first_name=William
		// first_name=Bill
	void sendMultiValueCookie()
	{
		Response response = 
				given()
				  .baseUri("http://localhost")
				  .basePath("api/users")
				  .cookie("first_name", "William", "Bill")
				  .get("/2");
	}
	
	@Test(priority = 4)
	void sendCookieAsCookieBuilder()
	{
		Cookie requestCookie = new Cookie.Builder("first_name", "John").setSecured(true).setComment("Example Comment").build();
		
		Response response =
				given()
					.baseUri("http://localhost")
					.basePath("api/users")
					.cookie(requestCookie)
					.get("/2");
	}
}
