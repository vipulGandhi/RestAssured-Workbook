// Encapsulation concept is used
	// Define getters and setters for every field in request json object

// To generate getters and setters of any variable
	// Select the variable
	// Select Source -> Generate Getters and Setters...

// plain old Java object

package Basics;

import java.util.ArrayList;
import java.util.List;

public class R_02_POJO_PostRequest
{
	
	String name;
	int age;
	boolean workFromOffice;
	List<String> skillSet = new ArrayList<>();
	
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
