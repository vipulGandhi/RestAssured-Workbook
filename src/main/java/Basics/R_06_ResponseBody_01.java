package Basics;

//Static packages
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.hamcrest.Matchers;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;

public class R_06_ResponseBody_01
{
	
	final String BASE_URI = "https://run.mocky.io";
	final String BASE_PATH = "/v3";
	
	ResponseSpecification responseSpecification = null;
	
	
//	@BeforeClass
//	public void setup()
//	{
//		RestAssured.baseURI = BASE_URI;
//		RestAssured.basePath = BASE_PATH;
//	}
	
	@BeforeClass
	public void setup()
	{
		requestSpecification = RestAssured.given()
				.baseUri(BASE_URI)
				.basePath(BASE_PATH)
				.contentType(ContentType.JSON);
				//.header(null)
		
		// Create a ResponseSpecification 
		// Verify the responses for every @Test
		responseSpecification=  RestAssured.expect();
		responseSpecification.contentType(ContentType.JSON);
		responseSpecification.statusCode(200);
		responseSpecification.time(Matchers.lessThan(5000L));
		responseSpecification.statusLine("HTTP/1.1 200 OK");
		
		
		/*
		// Create a ResponseSpecification using ResponseSpecBuilder
		responseSpecification = new ResponseSpecBuilder()
			.expectStatusCode(200)
		    .expectStatusLine("HTTP/1.1 200 OK")
		    .expectContentType(ContentType.JSON)
		    .expectResponseTime(Matchers.lessThan(5000L))	
		    .build();
		*/
	}
	
	// Method - 01
	@Test
	void validateJsonResponseBody_01()
	{
		given()
			.spec(requestSpecification);
		when()
			.get("/8ec8f4f7-8e68-4f4b-ad18-4f0940d40bb7")
		
		.then()
			.spec(responseSpecification)
			.body("Location[2].State", equalTo("New York"));
	}
	
	// Method - 02
	@Test
	void validateJsonResponseBody_02() throws IOException
	{	
		Response response =
				
		given()
			.spec(requestSpecification)
		
		.when()
			.get("/8ec8f4f7-8e68-4f4b-ad18-4f0940d40bb7");
		
		
		// To verify response body, Convert response to JsonPath OR JSONObject
		JsonPath jsonpath= response.jsonPath();
		//JSONObject jsonObject = new JSONObject(response.asString());
		
		Assert.assertEquals(response.statusCode(), 200);
		Assert.assertEquals(response.header("Content-Type"), "application/json; charset=UTF-8");
		Assert.assertEquals(jsonpath.getString("Location[2].State"), "New York");
		Assert.assertEquals(jsonpath.getString("Items.Price"), "$105");
		Assert.assertEquals(jsonpath.get("Items.Price") instanceof String, true);
		
		//Assert.assertEquals(jsonObject.getJSONArray("Location").getJSONObject(2).get("State"), "New York");
		//Assert.assertEquals(jsonObject.getJSONObject("Items").get("Item Count"), 3);
		
		// Verify if "Indiana" is the value of one of the states
		boolean isIndianaPresent = false;
		List<String> states = jsonpath.getList("Location.State");
		for (String state : states)
		{
			if(state.equalsIgnoreCase("Indiana"))
			{
				isIndianaPresent = true;
				break;
			}
			System.out.println(state);
		}
		Assert.assertEquals(isIndianaPresent, true);
		
		// Get the Response in a JSON File
		// Directly getting a byte array
		byte[] responseAsByteArray = response.asByteArray();
		// Creating a target file
		File targetFileForByteArray = new File("src/main/resources/targetFileForByteArray.json");
		// Writing into files
		Files.write(responseAsByteArray, targetFileForByteArray);
	}
}
