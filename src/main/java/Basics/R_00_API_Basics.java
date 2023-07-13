// API 
	// Software interface which allows two applications to communicate with each other

// API vs. Web Services
	// Web services are the part of APIs
	// If API is accessed via web (URL, body(XML/JSON/Plain Text) and HTTP method (GET/POST/PUT/DELETE method), it is called web service
		// Above style of creating the web services is called REST (Rest is an architectural style)
			// It is an architectural style that defines a set of constraints to be used for creating web services or API
			// These web services provide interoperability(Communication) between computer systems on the Internet
			// SOAP is XML based (Very Old)
	// A Web service always needs a web network to operate while APIs don’t always need a web network for operation.
	// Web Service could be in the form of SOAP, REST or XML-RPC
	// API could be in the form of JAR files(Selenium Jar Files), Libraries, dll files etc.

// Advantages of API testing
	// Test for core functionality
		// Test the application without UI
	// Time efficient
	// Language Independent
		// Data is exchanged using XML or JSON
	// Easy GUI integration
		// Eg. Amazon Test
			// Create a User -> Search for a product -> Select the product -> Order the product -> Payment (Do it multiple times)
			// As a prerequisite, API tests will create n number of customers for you

// Protocols used in API testing
	// JMS (Java Messaging service)
	// Rest API
	// HTTP
	// SOAP

// API Test Process
	// Setup -> Execution -> Verification -> Reporting -> Clean-up

// Swagger/ WiKi Page - API documentation template

// Important things to check in API testing
	// Verify if response data is correct or not
		// data type validation	
		// key value validation
		// Keys validation
	// Schema validation
	// Status code
	// Authorization checks (OAuth, Bearer token, Basic auth etc.)
	// Response timeout
	// Error Codes
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
		// Webservices developed with REST are called RESTful Web services
	// REST server host the resources and REST client access the resources by resource URI
	// Uses HTTP Protocol GET/ POST/ PUT/ DELETE calls as the medium of communication between client and server
	// Resources could be in Json/ XML/ PlainText format
	// REST API's are always stateless
		// Session ID, user info etc. are not stored on the server but at some cache location in the database
			// If any server gets corrupted, the user request can be redirected to any other server

// URI vs URL vs URN
	// URL and URN are subtypes of URI
	// URI
		// URI can be a domain name: google.com
		// URI can be a domain name + protocol: https://google.com
	// URL
		// URI should always be domain name + protocol: https://google.com
	// URN
		// Resource name like /maps

// Components of HTTP Request
	// HTTP Method (GET/ PUT/ POST/ DELETE)
	// URI
	// HTTP Version
	// Request Header
	// Request Body
	// Request Cookies
	// Query, Path parameters
	// Authentication data

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

// Monolythic Architecture vs. Microservices
	// Microservices
		// For every business feature, there is a seperate service residing on a different machine

// API Gateway
	// API Gateway Manages:
		// Authentication Logic
		// Authorization Logic
		// SSL Certification to handle https requests from the client side
		// Mechanism to route the client request to the respective microservice
		// Adaptor [No explnations :)]
		// Static HTML pages
		// Caching
			// API gateway keeps the cached data within a threshold time period(eg. 1 hour)
			// If the data is requested within the the threshold time, the cached data is presented to the user
			// After the threshold time
				// The data gets updated on the main server and the old cached data in API gateway gets deleted
				// The request is sent to the main server again from API gateway
			// Router
				// Router takes the client's request (Request also contains client's device info)
				// Based on the device info, router sends the request to the specific microservice
			// Load Balancing
				// If there are multiple copies of similar microservice
				// Distribute the load among the microservices
			// Protocol Adapter
				// Microservice-1 accepts the request via HTTP1
				// Client send the request via HTTP2
				// Protocol Adapter will convert the request to HTTP1 and the response back to HTTP2
			// Monitoring/ Logs/ Dashboard/ Charts/ Request types(Mobile/ Desktop)

// Get
	// Retrieve the resource
// HEAD
	// GET - Response Body
// Put
	// Update a resource
	// Complete payload is sent in the request
	// Create a new resource if requested resource is not available
	// GET request is hit first to check if the resource is available
// Patch
	// Updates some information of a resource
	// Partial payload is sent
// POST
	// Create a resource
// Delete
	// Delete an existing resource
	// If the request passes through a cache and the Request-URI identifies one or more currently cached entities,
		// those entries SHOULD be treated as stale.

// Safe, Unsafe HTTP Methods
	// Safe Methods
		// GET, HEAD and OPTIONS - These methods perform read only operations
		// Safe methods can be cached, pre-fetched without affecting the actual resource
	// Unsafe Methods
		// POST, PUT, Patch

// Idempotent Methods
	// If multiple request to same method has the same state of resource on the server as after first request
	// GET, HEAD, OPTIONS, PUT, DELETE

// Query Parameter
	// Query parameters will start at end of a base URL after a question mark symbol (?)
	// A key-value pair will be as “key=value“. All key-value pairs will be separated with &. 


