package Basics;

import org.testng.annotations.Test;

//Static packages
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class R_03_Path_Query_Parameters
{
	@Test
	void pathAndQueryParameters()
	{
		// https://reqres.in/api/users?page=2&id=5
		given()
			.pathParam("usersEndpoint", "users")
			.queryParam("page", 2)
			.queryParam("id", 5)
			
		.when()
			.get("https://reqres.in/api/{usersEndpoint}")
		.then()
			.statusCode(200);
	}
}
