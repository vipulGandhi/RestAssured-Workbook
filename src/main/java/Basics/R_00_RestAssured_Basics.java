// Rest Assured
	// RestAssured is a set of API/ library/ JAR through which we can automate Rest API's
	// RestAssured by default support BDD style of writing the test cases with Gherkin syntax

// given(), when(), then()
	// given()
		// Prerequisite of an API request
		// If we have no prerequisite, we can remove given()
			// Request Body
			// Content type(Form-data/ XML/ Json/ Plain Text etc.)
			// Authentication
			// Query parameters, Path Parameters
			// Headers
			// Cookies
	// when()
		// Request URL
			// GET
			// POST
			// PUT
			// DELETE
	// then()
		// Validations
			// Status code
			// Response Body
			// Header
			// Cookies

// Installation
	// Create maven project - maven-archetype-quickstart (v1.4)
	// Go to Eclipse Marketplace, Install testNG
	// Project dependencies
		// Get RestAssured dependencies from restAssured official documentation
			// https://github.com/rest-assured/rest-assured/wiki/GettingStarted
				// Rest Assured dependency (Includes JsonPath and XmlPath dependencies)
				// JsonPath dependency
		// TestNG
			// https://mvnrepository.com/artifact/org.testng/testng
		// JSON
			// https://mvnrepository.com/artifact/org.json/json
		// ScribeJava APIs
			// https://mvnrepository.com/artifact/com.github.scribejava/scribejava-apis
		// ScribeJava Core
			// https://mvnrepository.com/artifact/com.github.scribejava/scribejava-core

// In every @Test class, import static packages
	// https://github.com/rest-assured/rest-assured/wiki/GettingStarted#static-imports
		// import static io.restassured.RestAssured.*;
		// import static io.restassured.matcher.RestAssuredMatchers.*;
		// import static org.hamcrest.Matchers.*;

// Query Parameters and Path Parameters
	// https://reqres.in/api/users?page=1&id=5 [URI]
		// Domain: https://reqres.in [URL]
		// Path: /api/users [URN]
		// Query: page=1 and id=5

// Serealization vs deserialization
	// Serealization
		// Converting java object to Json object
	// Deserealization
		// Converting json object to java object
	// RestAssured internally manages serealization and deserialization

// Authorization vs Authentication
	// Authorization
		// If the permission/ access is given or not
	// Authentication
		// If the user is valid or not

// Use JsonAssert lobrary to compare 2 Json Objects

// Oauth2.0
	// OAuth 2.0 is for Authorization, not Authentication
	// Terminology
		// Third-Party Application/ Client
			// The client is the application that is attempting to get access to the user's account(Eg. BookMyShow)
			// It needs to get permission from the user before it can do so
		// Resource Server
			// API server used to access the user's information
		// Authorization Server
			// Server that presents the login interface(Eg. Google Login)
		// User/ Resource Owner
			// Person who is giving access to some portion of it's account

	// Flow [https://aaronparecki.com/oauth-2-simplified/] [https://www.youtube.com/watch?v=CPbvxxslDTU]
		// BookMyShow registers with Google to get Google user's information
		// In the registration process, BookMyShow will share a redirect URI to Google
				// Google will redirect the user to this URI if user authorization with Google is successful
		// After registeration, Google will share a Client ID and Client Secret to BookMyShow

		// BookMyShow creates a login link for all the user who want to authorize themselves with google credentials
			// https://authorization-server.com/auth?response_type=code&client_id=CLIENT_ID&redirect_uri=REDIRECT_URI&scope=photos&state=1234zyx
				// response_type=code - BookMyShow expect to receive the authorization code from Google in the response
				// client_id - BookMyShow's registered client's id with Google
				// redirect_uri -Google will redirect the user to this URI if user authorization is successful
				// scope - The scope of user's resources on Google, BookMyShow wish to access
				// state - BookMyShow will generate a random string which it will verify later

		// The user comes to BookMyShow login link and wish to login with Google Credentials
		// User enters valid credentials
		// A prompt is displayed to the user by Google if the user wish to allow or deny access to the specific resource(s) to BookMyShow
		// If the user clicks "Allow," Google redirects the user back to the redirect URI with an authorization code
			// https://example-app.com/cb?code=AUTH_CODE_HERE&state=1234zyx
				// code - Google returns the authorization code in the query string
				// state - The server returns the same state value that BookMyShow passed
					// Compare this state value to ensure it matches the previously shared state value.

		// After getting Authorization code, BookMyshow request google to get the access token to get access to user resources from Google resources server
			// POST https://api.authorization-server.com/token
  				// grant_type=authorization_code&
  				// code=AUTH_CODE_HERE&
  				// redirect_uri=REDIRECT_URI&
  				// client_id=CLIENT_ID&
  				// client_secret=CLIENT_SECRET
		// Google replies with an access token and expiration time
			// { "access_token":"RsT5OjbzRn430zqMLgV3Ia", "expires_in":360 }

		// BookMyShow sends the request to google resource server with the access token
		// Resource server shares the required resources to BookMyShow


// RestAssured Authentications
	// Basic Authentication
	// Digest Authentication
	// Pre-emptive authentication
	// Bearer token authentication
	// OAuth 1.0, 2.0
	// API Key authentication

// Compare 2 Json objects/ Part of Json objects
	// Use JSONassert library


// Reference API's used in this project
	// https://reqres.in/