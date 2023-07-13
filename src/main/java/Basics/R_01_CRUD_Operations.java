// Reference
	// https://reqres.in/

package Basics;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

// Static packages
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class R_01_CRUD_Operations
{
	// Get the user id generated from createUser()
	int userID;
	
	
	@Test(priority = 1)
	void createUser()
	{
		// Create request body
			// Method - 1: Create hash map of json key - value pairs
				// Not recommended
		Map<String, String> requestDataMap = new HashMap<>();
		requestDataMap.put("name", "HelloName");
		requestDataMap.put("job", "Test");
		
		// Capture the response
		Response createUserResponse =
		given()
			.baseUri("https://reqres.in")
			.basePath("/api/users")
			.contentType("application/json")
			//.contentType(ContentType.JSON)
			.body(requestDataMap)
			
		.when()
			.post();

		// Convert response to json path
		JsonPath jsonpath= createUserResponse.jsonPath();
		userID = jsonpath.getInt("id");
	}
	
	@Test(priority = 2)
	// Get Single User
	void getUser()
	{
		given()
			// No parameters
		
		.when()
			.get("https://reqres.in/api/users/2")
			
		// response is received
		// Perform assertions on response
		.then()
			.statusCode(200)
			.body("data.id", equalTo(2));
			// Display response in console
			//.log().all();
	}

	@Test(priority = 3, dependsOnMethods = {"createUser"})
	void updateUser()
	{
		Map<String, String> updateDataMap = new HashMap<>();
		updateDataMap.put("name", "HiName");
		updateDataMap.put("job", "Test");
		
		given()
			.contentType("application/json")
			.body(updateDataMap)
			
		.when()
			.put("https://reqres.in/api/users/"+userID+"")

		.then()
			.statusCode(200)
			.header("Content-Type", "application/json; charset=utf-8");
	}
	
	@Test(priority = 4)
	void deleteUser()
	{
		when()
			.delete("https://reqres.in/api/users/"+userID+"")
			
		.then()
			.statusCode(204);
	}
}
