package Tasks;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContactTest {

	private String goodFirstName = "Jake";
	private String goodLastName = "Testing";
	private String goodPhone = "1112221234";
	private String goodAddress = "Someplace";
	private String goodID = "12345";
	private String nullInput = null;
	private String over10Char = "12345678910";
	private String over30Char = "1234567891011121314151617181920";
	private String exactly10Char = "1234567890";
	private String exactly30Char = "123456789012345678901234567890";
	private String phoneUnder10Char = "123456";
	
	//Here we test that under 10 char Id, first name, and last name work
	//Also tests that exactly 10 char phone number and under 30 char address works
	@Test
	void testClassCreation() {
		Contact testContact = new Contact(goodID, goodFirstName, goodLastName, goodPhone, goodAddress);
		assertTrue(testContact.getContactID().equals(goodID));
		assertTrue(testContact.getFirstName().equals(goodFirstName));
		assertTrue(testContact.getLastName().equals(goodLastName));
		assertTrue(testContact.getPhone().equals(goodPhone));
		assertTrue(testContact.getAddress().equals(goodAddress));
		//Here we check that all variables can take the exact uper limit
		Contact testContactTwo = new Contact(exactly10Char, exactly10Char, exactly10Char, goodPhone, exactly30Char);
		assertTrue(testContactTwo.getContactID().equals(exactly10Char));
		assertTrue(testContactTwo.getFirstName().equals(exactly10Char));
		assertTrue(testContactTwo.getLastName().equals(exactly10Char));
		assertTrue(testContactTwo.getPhone().equals(goodPhone));
		assertTrue(testContactTwo.getAddress().equals(exactly30Char));
		
	}
	//Here we test all errors for bad inputs to the constructor method for each variable
	//Includes too many char for all inputs, null for all, and too few char for phone
	//Every other input is kept to a known working variable
	@Test
	void testClassCreationErrors() {
		 Assertions.assertThrows(IllegalArgumentException.class,() ->{
			Contact noIDContact = new Contact(nullInput, goodFirstName,goodLastName,goodPhone,goodAddress);
			
					
		}, "nullInput Failed to throw Exception for ID"); 
		 
			
		
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			Contact testContact = new Contact(over10Char, goodFirstName, goodLastName, goodPhone, goodAddress);
					
		}, "over10Char Failed to throw Exception for ID");
		
		Assertions.assertThrows(IllegalArgumentException.class,() ->{
			Contact testContact = new Contact(goodID, nullInput,goodLastName,goodPhone,goodAddress);
		
					
		}, "nullInput Failed to throw Exception for first name"); 
		 
			
		
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			Contact testContact = new Contact(goodID, over10Char, goodLastName, goodPhone, goodAddress);
					
		}, "over10Char Failed to throw Exception for first name");
		
		Assertions.assertThrows(IllegalArgumentException.class,() ->{
			Contact noIDContact = new Contact(goodID, goodFirstName,nullInput,goodPhone,goodAddress);
			
					
		}, "nullInput Failed to throw Exception for last name"); 
		 
			
		
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			Contact testContact = new Contact(goodID, goodFirstName, over10Char, goodPhone, goodAddress);
					
		}, "over10Char Failed to throw Exception for last name");
		
		Assertions.assertThrows(IllegalArgumentException.class,() ->{
			Contact noIDContact = new Contact(goodID, goodFirstName,goodLastName,nullInput,goodAddress);
			
					
		}, "nullInput Failed to throw Exception for phone");
		
		Assertions.assertThrows(IllegalArgumentException.class,() ->{
			Contact noIDContact = new Contact(goodID, goodFirstName,goodLastName, phoneUnder10Char,goodAddress);
			
					
		}, "Under 10 characters Failed to throw Exception for phone"); 
		 
			
		
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			Contact testContact = new Contact(goodID, goodFirstName, goodLastName, over10Char, goodAddress);
					
		}, "over10Char Failed to throw Exception for phone");
		
		Assertions.assertThrows(IllegalArgumentException.class,() ->{
			Contact noIDContact = new Contact(goodID, goodFirstName,goodLastName,goodPhone,nullInput);
			
					
		}, "nullInput Failed to throw Exception for address"); 
		 
			
		
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			Contact testContact = new Contact(goodID, goodFirstName, goodLastName, goodPhone, over30Char);
					
		}, "over30Char Failed to throw Exception for address");
		
		
	}
	

}
