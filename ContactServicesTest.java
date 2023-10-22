package Tasks;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ContactServicesTest {
	//Initializes needed variables for all tests
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
	private String under10Char = "123456";
	
	//First we test adding a contact
	@Test
	void addContactTest() {
		//Initializes contact services
		ContactServices testServices = new ContactServices();
		//Adds a contact with variables that meet requirements
		testServices.addContact(goodID,goodFirstName,goodLastName,goodPhone,goodAddress);
		//Assets that all variables equal what they were set to
		assertTrue(testServices.Contacts.get(0).getContactID().equals(goodID),"ID mismatch");
		assertTrue(testServices.Contacts.get(0).getFirstName().equals(goodFirstName),"First name mistmatch");
		assertTrue(testServices.Contacts.get(0).getLastName().equals(goodLastName),"Last name mismatch");
		assertTrue(testServices.Contacts.get(0).getPhone().equals(goodPhone),"Phone mismatch");
		assertTrue(testServices.Contacts.get(0).getAddress().equals(goodAddress),"Address mismatch");
		//Checks that trying to add another contact with same ID throws exception 
		//Makes sure that if ID isn't unique an error is thrown
		assertThrows(IllegalArgumentException.class, () -> {
			testServices.addContact(goodID,goodFirstName, goodLastName, goodPhone, goodAddress);},
				"Using the same ID didn't throw IllegalArgumentException!");
	
	}
	//Here we test update functions
	@Test
	void updateTests() {
		//Initialize services
		ContactServices testServices = new ContactServices();
		//Add a contact with known good variables
		testServices.addContact(goodID,goodFirstName,goodLastName,goodPhone,goodAddress);
		//Each test will attempt under char limit, at char limit,
		//and over char limit expect no exception for under and at char limit
		//except for phone which has exception under char limit
		//expect exception for all over char limits
		testServices.updateFirstName(goodID, under10Char);
		assertTrue(testServices.Contacts.get(0).getFirstName().equals(under10Char),
				"Exact char limit still threw exception for first name");
		
		testServices.updateFirstName(goodID, exactly10Char);
		assertTrue(testServices.Contacts.get(0).getFirstName().equals(exactly10Char),
				"Exact char limit still threw exception for first name");
		
		assertThrows(IllegalArgumentException.class, () -> {
			testServices.updateFirstName(goodID, over10Char);
		},"Over 10 char failed to throw exception for first name");
		
		testServices.updateLastName(goodID, under10Char);
		assertTrue(testServices.Contacts.get(0).getLastName().equals(under10Char),
				"under char limit still threw exception for last name");
		
		testServices.updateLastName(goodID, exactly10Char);
		assertTrue(testServices.Contacts.get(0).getLastName().equals(exactly10Char),
				"Exactly char limit still threw exception for last name");
		
		assertThrows(IllegalArgumentException.class, () -> {
			testServices.updateLastName(goodID, over10Char);
		},"Over 10 char failed to throw exception for last name");
		
		testServices.updatePhone(goodID, exactly10Char);
		assertTrue(testServices.Contacts.get(0).getPhone().equals(exactly10Char),
				"exactly 10 char still threw exception for phone");
		
		assertThrows(IllegalArgumentException.class, () -> {
			testServices.updatePhone(goodID, over10Char);
		},"Over 10 char failed to throw exception for phone");
		
		assertThrows(IllegalArgumentException.class, () -> {
			testServices.updatePhone(goodID, under10Char);
		},"under 10 char failed to throw exception for phone");
		
		testServices.updateAddress(goodID, under10Char);
		assertTrue(testServices.Contacts.get(0).getAddress().equals(under10Char),
				"Under char limit still threw exception for address");
		
		testServices.updateAddress(goodID, exactly30Char);
		assertTrue(testServices.Contacts.get(0).getAddress().equals(exactly30Char),
				"Exact Char limit still threw exception for address");
		
		assertThrows(IllegalArgumentException.class, () -> {
			testServices.updateFirstName(goodID, over30Char);
		},"Over 30 char failed to throw exception for address");
		
		assertThrows(IllegalArgumentException.class, () -> {
			testServices.addContact(goodID,goodFirstName, goodLastName, goodPhone, goodAddress);},
				"Using the same ID didn't throw IllegalArgumentException!");
	}
	//Here we test the delete function
	@Test
	void deleteContactTest() {
		//Initialize contact services
		ContactServices testServices = new ContactServices();
		//Add contact with good inputs
		testServices.addContact(goodID,goodFirstName,goodLastName,goodPhone,goodAddress);
		//Call delete function
		testServices.deleteContact(goodID);
		//Check that contact has been deleted
		assertTrue(testServices.findContact(goodID).equals("Contact not found"),
				"Contact was found");
	}

}
