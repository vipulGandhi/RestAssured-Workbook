// How to verify if the file is uploaded successfully
	// When we upload a file, the response contains the link where the file is present
	// When we open the link, the file should be downloaded on the local machine with response code = 200

package Basics;

import org.testng.annotations.Test;

//Static packages
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

public class R_07_FormData_FileUploadAndDownload
{
	@Test
	void fileUpload()
	{
		
		String fileToUploadString = System.getProperty("user.dir") + "/src/test/resources/filesToUpload/uploadText.text";
		File fileToUploadFile01 = new File(fileToUploadString);
		File fileToUploadFile02 = new File(fileToUploadString);
		
		given()
			.contentType("multipart/form-data")
			.multiPart("file01", fileToUploadFile01)
			.multiPart("file02", fileToUploadFile02)
		
		.when()
			.put("url")
			
		.then()
			.statusCode(200);
	}
	
	// Verify if file is uploaded properly
	@Test
	void fileDownload()
	{
		when()
			.put("url of the file from response")
			
		.then()
			.statusCode(200);
	}
}
