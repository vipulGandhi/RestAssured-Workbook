package Basics;

//Static packages
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class R_06_ResponseBody_01
{
	// Method - 01
	@Test
	void validateJsonResponseBody_01()
	{
		//base URI
		RestAssured.baseURI = "https://run.mocky.io/v3";
		
		when()
			.get("/8ec8f4f7-8e68-4f4b-ad18-4f0940d40bb7")
		
		.then()
			.body("Location[2].State", equalTo("New York"));
	}
	
	// Method - 02
	@Test
	void validateJsonResponseBody_02()
	{
		//base URI
		RestAssured.baseURI = "https://run.mocky.io/v3";
		
		Response response =
				
		given()
			.contentType(ContentType.JSON)
		
		.when()
			.get("/8ec8f4f7-8e68-4f4b-ad18-4f0940d40bb7");
		
		
		// To verify response body, Convert response to json path OR json object
		JsonPath jsonpath= response.jsonPath();
		JSONObject jsonObject = new JSONObject(response.asString());
		
		Assert.assertEquals(response.statusCode(), 200);
		Assert.assertEquals(response.header("Content-Type"), "application/json; charset=UTF-8");
		Assert.assertEquals(jsonpath.getString("Location[2].State"), "New York");
		Assert.assertEquals(jsonpath.getString("Items.Price"), "$105");
		Assert.assertEquals(jsonpath.get("Items.Price") instanceof String, true);
		
		Assert.assertEquals(jsonObject.getJSONArray("Location").getJSONObject(2).get("State"), "New York");
		Assert.assertEquals(jsonObject.getJSONObject("Items").get("Item Count"), 3);
		
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
	}
}
