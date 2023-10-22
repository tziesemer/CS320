package Tasks;
import java.util.*;

public class ContactServices {
	//Initialize the Contacts list
	public List<Contact> Contacts = new ArrayList<Contact>();
	
	//function to add contacts to list 
	public void addContact(String contactID, String firstName, String lastName, String phone, String address) {
		//Checks that contact ID is unique
		for(Contact i : Contacts) {
			if(i.getContactID() == contactID) {
				//If the ID is found then exception is thrown
				throw new IllegalArgumentException("contactID is not unique");
			}
			
		}
		//If contact ID is unique than the Contact constructor is called
		Contact newContact = new Contact(contactID, firstName, lastName, phone, address);
		//if Constructor doesn't throw exception then contact is added to list
		Contacts.add(newContact);
	}
	//Search function to find if and where contact is in list
	public String findContact(String contactID) {
		//Iterates through list
		for(int i = 0; i < Contacts.size(); i++) {
			//If contact is found then returns string saying as much
			if(Contacts.get(i).getContactID() == contactID) {
				return "Contact found";
			}
			
		}
		//If contact is not found then returns string to say so
		return "Contact not found";
	}
	//Function to delete contact from list
	public void deleteContact(String contactID) {
		//Iterates through list 
		for(int i = 0; i < Contacts.size(); i++) {
			//If contact is found then removes it from list
			if(Contacts.get(i).getContactID() == contactID) {
				Contacts.remove(i);
			}
		}
	}
	//Update first name function
	public void updateFirstName(String contactID, String firstName) {
		//Checks that new name meets requirements
		if(firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid First Name");
			
		}
		boolean idFound = false;
		//Checks that contact is in the list
		for(Contact i : Contacts) {
			//If found then updates first name
			if(i.getContactID() == contactID) {
				idFound = true;
				i.setFirstName(firstName);
			}
		}
		//If it isn't found then throws exception
		if(idFound == false) {
			throw new NoSuchElementException("contactID not found");
		}
	}
	//Same as first name update but for last name
	public void updateLastName(String contactID, String lastName) {
		if(lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid Last Name");
		}
		boolean idFound = false;
		for(Contact i : Contacts) {
			if(i.getContactID() == contactID) {
				idFound = true;
				i.setLastName(lastName);
			}
		}
		if(idFound == false) {
			throw new NoSuchElementException("contactID not found");
		}
	}
		
	//Same as first and last name update except cannot except under char limit
	public void updatePhone(String contactID, String phone) {
			if(phone == null ||phone.length() != 10) {
				throw new IllegalArgumentException("Invalid phone number");
			}
			boolean idFound = false;
			for(Contact i : Contacts) {
				if(i.getContactID() == contactID) {
					idFound = true;
					i.setPhone(phone);
				}
			}
			if(idFound == false) {
				throw new NoSuchElementException("contactID not found");
			}
	}
	//Same as first and last name except char limit is higher
	public void updateAddress(String contactID, String address) {
			if(address == null || address.length() > 30) {
				throw new IllegalArgumentException("Invalid address");
			}
			boolean idFound = false;
			for(Contact i : Contacts) {
				if(i.getContactID() == contactID) {
					idFound = true;
					i.setAddress(address);
				}
			}
			if(idFound == false) {
				throw new NoSuchElementException("contactID not found");
			}
		}
}
