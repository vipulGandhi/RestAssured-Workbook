// Encapsulation concept is used
	// Define getters and setters for every field in request json object

// To generate getters and setters of any variable
	// Select the variable
	// Select Source -> Generate Getters and Setters...

// plain old Java object

// Private variables
// Default public constructor
// Each variable has getter or setter or both

// A POJO should not
	// Extend a class
	// Implements an interface
	// Have any annotation

// @JsonIgnoreProperties [provided by Jackson API]
	// There may be few fields in a Pojo class and which we don’t want to participate in serialization and deserialization process
		// Example:
			// 3 field in POJO class - firstName, lastName, fullName
			// fullName should be derived from firstName and lastName via internal logic
			// fullName should not participate in serialization and deserialization process
				// At class level: @JsonIgnoreProperties({"fullName"})
	// Allow fullName to participate only in serialization
		// At class level: @JsonIgnoreProperties(value = {"fullName"}, allowGetters = true)
	// Allow fullName to participate only in deserialization
		// At class level: @JsonIgnoreProperties(value = {"fullName"}, allowSetters = true)
	// Ignore unknown properties during deserialization process
		// At class level: @JsonIgnoreProperties(ignoreUnknown = true)



package Basics;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

// A few json fields could be optional
// While creating the object of this class:
	// If we will not add a particular field, it will not be reflected in the created JSON Object
//@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class R_02_POJO_PostRequest
{
	// This field is optional
	@JsonInclude(JsonInclude.Include.NON_DEFAULT)
	private String name;
	
	// This field is required
	@JsonInclude(JsonInclude.Include.ALWAYS)
	private int age;
	
	// Value should be Non NULL
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private boolean workFromOffice;
	private List<String> skillSet = new ArrayList<>();
	
	
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	
	public int getAge()
	{
		return age;
	}
	public void setAge(int age)
	{
		this.age = age;
	}
	
	public boolean getWorkFromOffice()
	{
		return workFromOffice;
	}
	public void setWorkFromOffice(boolean workFromOffice)
	{
		this.workFromOffice = workFromOffice;
	}
	public List<String> getSkillSet()
	{
		return skillSet;
	}
	public void setSkillSet(List<String> skillSetList)
	{
		this.skillSet = skillSetList;
	}
	
	
}
