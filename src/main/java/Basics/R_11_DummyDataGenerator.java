// Add faker dependency
	// https://github.com/DiUS/java-faker

package Basics;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class R_11_DummyDataGenerator
{
	@Test
	void GenerateDummyData()
	{
		Faker faker = new Faker();
		
		System.out.println(faker.name().fullName());
		System.out.println(faker.name().firstName());
		System.out.println(faker.name().username());
		System.out.println(faker.internet().password(5, 10));
		System.out.println(faker.phoneNumber().cellPhone());
		System.out.println(faker.internet().emailAddress());
		System.out.println(faker.business().creditCardNumber());
		System.out.println(faker.color().name());
	}
}
