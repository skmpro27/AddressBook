
import java.util.*;

class Contact {
	private String firstName, lastName;
	private String address, city, state;
	private String zip;
	private String phoneNum;
	private String email;

	public Contact(String firstName, String lastName, String address, String city, String state, String zip, String phoneNum, String email) {
        	System.out.println("Welcome to Address Book Program");
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phoneNum = phoneNum;
		this.email = email;
    	}
	public String toString() {
		return "Name: " + firstName + " " + lastName +
		       "\nAddress: " + address + ", " + city + ", " + state +
		       "\nZIP: " + zip + "\nPhone Number: " + phoneNum + "\nEmail: " + email;
	}
}

public class AddressBookMain {

	public static void main(String[] args) {
		ArrayList<Contact> list = new ArrayList<Contact>();
		list.add( new Contact("Shubham", "Kumar", "B-138, NFL Vijaipur Township", "Guna", "Madhya Pradesh", "473111", "9111649077", "kumar.skm03@gmailcom"));
		System.out.println(list.get(0));
	}
}
