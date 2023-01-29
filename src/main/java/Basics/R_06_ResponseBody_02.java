package Basics;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class R_06_ResponseBody_02
{
	// Method - 01
	@Test
	void validateJsonResponseBody()
	{
		File jsonArrayFile = new File(System.getProperty("user.dir")+ "/src/test/resources/JsonFiles/SampleJson.json");
		JsonPath jsonPath = JsonPath.from(jsonArrayFile);

		System.out.println("First name is first employee :"+ jsonPath.getString("[0].first_name"));

		System.out.println("All details of first employee : " +jsonPath.getJsonObject("[0]"));
		
		System.out.println("First name of all employees" + jsonPath.getList("first_name"));
		
		System.out.println("First name of all female employees : "+jsonPath.getList("findAll{it.gender == 'Female'}.first_name"));
		
		System.out.println("First name of all female employees : "+jsonPath.getList("findAll{it -> it.gender == 'Female'}.first_name"));
		
		System.out.println("First name of first female employee : "+jsonPath.getString("find{it.gender == 'Female'}.first_name"));

		System.out.println("First name of all employees whose id is 5 or more : " + jsonPath.getList("findAll{it.id >= 5}.first_name"));

		System.out.println("First name of all employees whose id is 5 or more but less than 8 : " + jsonPath.getList("findAll{it.id >= 5 & it.id < 8}.first_name"));
		
		System.out.println("First name of all employees whose id is greater than 9 or gender is female : " + jsonPath.getList("findAll{it.id >= 9 | it.gender == 'Female'}.first_name"));
		
		System.out.println("Total number of employees : " + jsonPath.getString("size()"));
		
	}
}

// Practice for Json path [https://jsonpath.com/]

// URL: https://run.mocky.io/v3/8ec8f4f7-8e68-4f4b-ad18-4f0940d40bb7

//Q. Get 1st two locations
// $.Location[0,1]

//Q. Get all the states
// $.Location[*].State

//Q. Get Item Count
// $.Items.Item Count

//Q. Get all locations from 1st
// $.Location[1:]

//Q. Get all the Location objects where State key is present
// $.Location[?(@.State)]

//Q. Get all the locations where zip code is >=49086
// $.Location[?(@.zip>=49086)]

//Q. Get length of location array
// $.Location.length


