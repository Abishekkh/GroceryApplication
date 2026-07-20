package utility;

import com.github.javafaker.Faker;

public class RandomDataUtility {
	
	Faker fak = new Faker();
	
	public String randomUsername()
	{
		return fak.name().username();
	}
	
	public String randomPassword()
	{
		return fak.internet().password();
	}
	
	public String fullname()
	{
		return fak.name().fullName();
	}
	
	public String email()
	{
		return fak.internet().emailAddress();
	}
	
	public String phoneNumber()
	{
		return fak.phoneNumber().cellPhone();
	}
	
	public String address()
	{
		return fak.address().fullAddress();
	}
	
	

}
