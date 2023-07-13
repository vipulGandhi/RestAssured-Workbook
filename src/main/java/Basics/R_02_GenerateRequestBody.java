// Ways to generate POST request body
	// Hash Map [For small set of data]
	// Json dependency
	// POJO (Plain Old Java Object) Class [Mostly Used]
	// External json file

package Basics;

// Static packages
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

public class R_02_GenerateRequestBody
{
	@Test(priority = 1)
	void hashMapRequestBody()
	{
		Map<String, Object> requestHashMap = new HashMap<>();
		requestHashMap.put("name", "Username");
		requestHashMap.put("age", 21);
		requestHashMap.put("workFromOffice", true);
		
		List<String> skillSetList = new ArrayList<>(Arrays.asList("Java", "Pyton"));
		requestHashMap.put("skillSet", skillSetList);
		
		given()
		.contentType("application/json")
		.body(requestHashMap);
		
		JSONObject json = new JSONObject(requestHashMap);
		System.out.println(json);
	}
	
	@Test(priority = 2)
	void jsonRequestBody()
	{
		JSONObject requestJson = new JSONObject();
		requestJson.put("name", "Username");
		requestJson.put("age", 21);
		requestJson.put("workFromOffice", true);
		
		List<String> skillSetList = new ArrayList<>(Arrays.asList("Java", "Pyton"));
		requestJson.put("skillSet", skillSetList);
		
		given()
		.contentType("application/json")
		.body(requestJson.toString());
		
		System.out.println(requestJson);
	}
	
	@Test(priority = 3)
	void pojoRequestBody()
	{
		// Create a POJO class
		
		// Create object of POJO class
		R_02_POJO_PostRequest r_02_POJO_PostRequest = new R_02_POJO_PostRequest();
		r_02_POJO_PostRequest.setName("Username");
		r_02_POJO_PostRequest.setAge(21);
		r_02_POJO_PostRequest.setWorkFromOffice(true);
		
		List<String> skillSetList = new ArrayList<>(Arrays.asList("Java", "Pyton"));
		r_02_POJO_PostRequest.setSkillSet(skillSetList);

		
		given()
		.contentType("application/json")
		// assign class object as json request to body
		.body(r_02_POJO_PostRequest);
	}
	
	@Test(priority = 4)
	void externalJsonRequestBody() throws FileNotFoundException
	{
		// Create .json file inside the project
			// Right click project name
				// Name it (Example requestBody.json) 

		String jsonPathString = System.getProperty("user.dir") + "/src/test/resources/JsonFiles/requestBody.json";
		FileInputStream fileInputStream = new FileInputStream(jsonPathString);
		JSONTokener jsonTokener = new JSONTokener(fileInputStream);
		JSONObject jsonObject = new JSONObject(jsonTokener);
		
		given()
		.contentType("application/json")
		.body(jsonObject.toString());
		
		System.out.println(jsonObject);
	}
}


