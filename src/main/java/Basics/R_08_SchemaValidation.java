package Basics;


//Static packages
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;

public class R_08_SchemaValidation
{
	@Test
	void jsonSchemaValidation()
	{
	      RestAssured.baseURI = "https://jsonplaceholder.typicode.com/posts/2";

	      given()
	      .when().get()

	      .then()
	      	.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("Schema/jsonSchema.json"));
	}
}
