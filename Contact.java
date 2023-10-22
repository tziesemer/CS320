package Tasks;

public class Contact {
	// Initiated contact variables TZ 19SEP23
	private String contactID;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	//Constructor that ensures that inputs are not null or larger then 10 for all except address where it changes to no larger than 30 TZ 19SEP23
	public Contact(String contactID, String firstName, String lastName, String phone, String address) {
		//Couldn't figure out how to check for uniqueness here so that is handled in the ContactServices class
		if(contactID == null || contactID.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		if(firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid firstName");
		}
		if(lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid lastName");
		}
		if(phone == null || phone.length() != 10) {
			throw new IllegalArgumentException("Invalid Phone Number");
		}
		if(address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid address");
		}
		
		this.contactID = contactID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
		
	}
	
	public String getContactID() {
		return this.contactID;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public String getPhone() {
		return this.phone;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
}
