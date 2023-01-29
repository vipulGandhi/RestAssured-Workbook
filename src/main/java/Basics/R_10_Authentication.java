package Basics;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONPropertyIgnore;

public class R_10_Authentication
{
	// Basic Authentication
		// Username and Password
	@Test(priority = 1)
	void BasicAuthentication()
	{
		given()
			.auth().basic("postman", "password")
			
		.when()
			.get("https://postman-echo.com/basic-auth")
			
		.then()
			.statusCode(200);
	}
	
	// Digest Authentication
		// Username and Password
	@Test(priority = 2)
	void DigestAuthentication()
	{
		given()
			.auth().digest("postman", "password")
			
		.when()
			.get("https://postman-echo.com/basic-auth")
			
		.then()
			.statusCode(200);
	}
	
	// Preemptive Authentication
		// Username and Password
	@Test(priority = 3)
	void PreemptiveAuthentication()
	{
		given()
			.auth().preemptive().basic("postman", "password")
			
		.when()
			.get("https://postman-echo.com/basic-auth")
			
		.then()
			.statusCode(200);
	}
	
	// Bearer Authentication
		// User creats it's own token
			// Go to github
				// Settings -> Developer Settings
					// Personal Access Tokens -> Tokens (classic) -> Generate new token -> Generate new token(classic)
	@Test(priority = 4)
	void BearerTokenAuthentication()
	{
		String bearerToken = "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";
		
		given()
			.header("Authorization", "Bearer " + bearerToken)
			
		.when()
			.get("https://api.github.com/user/repos")
			
		.then()
			.statusCode(200);
	}
	
	@Test(priority = 5)
	void OAuth01Authentication()
	{		
		given()
			.auth().oauth("consumerKey", "consumerSecret", "accessToken", "secretToken")
			
		.when()
			.get("some url")
			
		.then()
			.statusCode(200);
	}
	
	@Test(priority = 6)
	void OAuth02Authentication()
	{		
		given()
			// Generate Access Token manually through postman
			.auth().oauth2("Access token")
			
		.when()
			.get("some url")
			
		.then()
			.statusCode(200);
	}
	
	// Api key, value will be added in the request as query param
	@Test(priority = 7)
	void ApiKeyAuthentication()
	{		
		given()
			.queryParam("appid", "API Key here")
			
		.when()
			.get("some url")
			
		.then()
			.statusCode(200);
	}
}
