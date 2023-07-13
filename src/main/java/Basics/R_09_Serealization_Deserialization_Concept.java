// Serealization
	// POJO to Json
	// Conversion of a Java object to a byte stream
	// Serialization uses Getter methods of POJO class
// Drserialization
	// Json to POJO
	// Conversion of a byte stream to corresponding Java object
	// Deserialization uses Setter methods of POJO class

// To make a Java object serializable
	// Either its class or any of its superclasses implements either the Serializable interface or its subinterface Externalizable

package Basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.JSONObject;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;



public class R_09_Serealization_Deserialization_Concept
{
	
	@Test(priority = 1)
	void serealization() throws JsonProcessingException
	{
		R_02_POJO_PostRequest r_02_POJO_PostRequest = new R_02_POJO_PostRequest();
		r_02_POJO_PostRequest.setName("Username");
		r_02_POJO_PostRequest.setAge(21);
		r_02_POJO_PostRequest.setWorkFromOffice(true);
		
		List<String> skillSetList = new ArrayList<>(Arrays.asList("Java", "Pyton"));
		r_02_POJO_PostRequest.setSkillSet(skillSetList);
		
		// Serealization
			// Convert java object to json object
			// Pagkage used: Jackson
			// Class: ObjectMapper
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonDataString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(r_02_POJO_PostRequest);
		JSONObject jsonObject = new JSONObject(jsonDataString);
		System.out.println(jsonObject);
		System.out.println(jsonObject.get("skillSet"));
	}
	
	@Test(priority = 2)
	void deserialization() throws JsonMappingException, JsonProcessingException
	{
		// Deserialization
			// Convert JSON object to POJO class object
		
		JSONObject jsonObject = new JSONObject("{\"skillSet\":[\"Java\",\"Pyton\"],\"name\":\"Username\",\"workFromOffice\":true,\"age\":21}");
		String jsonDataString = jsonObject.toString();
		ObjectMapper objectMapper = new ObjectMapper();
		R_02_POJO_PostRequest r_02_POJO_PostRequest = objectMapper.readValue(jsonDataString, R_02_POJO_PostRequest.class);
		
		System.out.println(r_02_POJO_PostRequest.getName());
		System.out.println(r_02_POJO_PostRequest.getAge());
		System.out.println(r_02_POJO_PostRequest.getSkillSet());
		System.out.println(r_02_POJO_PostRequest.getWorkFromOffice());
	}
}
