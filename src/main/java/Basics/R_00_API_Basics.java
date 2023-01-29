// API 
	// Software interface which allows two applications to communicate with each other

// API vs. Web Services
	// All Web services are APIs but not all APIs are Web services
	// If an API is accessed over the network (via a URL, body and GET/POST/PUT/DELETE method) it is called a web service
	// A Web service always needs a network to operate while APIs don’t need a network for operation.
	// Web Service could be in the form of SOAP, REST or XML-RPC
	// API could be in the form of JAR files, Libraries etc.

// Components of Web API
	// HTTP for client - server communication
	// XML/ JSON as the communicating language
	// URI as the address for the services
	// Stateless communication

// Advantages of API testing
	// Test for core functionality
	// Time efficient
	// Language Independent

// API Test Environment
	// Setup the database
	// Setup the microservices for every environment (Dev/ Staging/ QA/ Production) etc.
		// Every environment will have a seperate database and server

// API Test Case design principles
	// Initialize the data, services etc.
	// Execute the API over different scenarios
	// Verify the results
	// Generate a report
	// Clean-up (Pre test state)

// Important things to check in API testing
	// Verify if response data is corrent or not
		// data type validation	
		// key value validation
		// Keys validation
	// Schema validation
	// Status code
	// Authorization checks (OAuth, Bearer token, Basic auth etc.)
	// Response timeout
	// Performance, Security Testing

// Types of API testing
	// Unit Testing
	// API functional testing
	// Load/ Performance Testing
	// Security Testing

// API documentation template
	// Swagger

// REST
	// Architecture for developing web services
		// Webservices developed in REST style are called RESTful Web services
	// REST server host the resources/ functionality and REST client access the resources/ functionalities
		// Resources are defined by URI's
	// Uses HTTP Protocol GET/ POST/ PUT/ DELETE calls as the medium of communication between client and server
	// Resources could be in Json/ XML/ PlainText format
	// REST API's are always stateless
		// Session ID, user info etc. are not stored on the server but at some cache location in the database
			// If any server gets corrupted, the user request can be redirected to any other server

// URI vs URL vs URN
	// URI: Uniform Resource Identifier Identifies a complete address of resource
	// URL: Uniform Resource Locator Identifies location of the resource
	// URN: Uniform Resource Name Identifies the name of the resource
	// Example
		// We have address https://www.google.com/folder/page.html where,
			// URI(Uniform Resource Identifier) => https://www.google.com/folder/page.html
			// URL(Uniform Resource Locator) => https://www.google.com/
			// URN(Uniform Resource Name) => /folder/page.html
	// URI => (URL + URN) or URL only or URN only

// Components of HTTP Request
	// HTTP Method (GET/ PUT/ POST/ DELETE)
	// URI
	// HTTP Version
	// Request Header
	// Request Body

// HTTP Calls
	// Get: Get the data [Max. URL length: 2048 characters]
		// HEAD: GET without response body
			// Only gives the header info in the response
	// POST: Post/ Create the data [No upper limit in URL length]
	// PUT: Update the data(Request contains the complete json data with updated info)
	// DELETE: Delete the data
	// PATCH: Update the data(Request contains only the data which needs to be updated)
	// OPTIONS: Tells us which methods (GET/ PUT/ POST/ DELETE) is allowed for this HTTP request

// Caching
	// Get GET data from Cache storage instead of hitting the actual server

// HTTP Status Code [https://www.restapitutorial.com/httpstatuscodes.html]
	// 1xx Informational (Rarely Used)
	// 2xx Success
		// 200 Ok
		// 201 Data successfully created [POST]
		// 204 No response body [DELETE]
	// 3xx Redirectional
		// 301 Application moved permanently/ URL changed
	// 4xx Client Error
		// 400 Bad Request
		// 401 Unuthorized
		// 404 Not Found (Resource not found)
		// 405 Method Not Found [Wrong GET/ POST/ PUT/ DELETE] 
	// 5xx Server Error
		// 500 Internal Server Error
		// 503 Service Down
		


