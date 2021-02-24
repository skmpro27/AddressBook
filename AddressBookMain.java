
import java.util.*;

class Contact {
	//variables
	private String firstName, lastName;
	private String address, city, state;
	private String zip;
	private String phoneNum;
	private String email;
	//intiallize variables by constructor
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
	//to add new objects
	static ArrayList<Contact> list = new ArrayList<Contact>();
	//taking input from user
	public static void addContact() {
		String firstName, lastName, address, city, state, zip, phoneNum, email;
		Scanner sc = new Scanner(System.in);
		String check = "y";
		while(check == "y" || check == "Y") {
			System.out.print("Enter First Name: ");
			firstName = sc.nextLine();
			System.out.print("Enter Last Name: ");
                	lastName = sc.nextLine();
			System.out.print("Enter Address: ");
                	address = sc.nextLine();
			System.out.print("Enter City: ");
                	city = sc.nextLine();
			System.out.print("Enter State ");
                	state = sc.nextLine();
			System.out.print("Enter ZIP Code: ");
                	zip = sc.nextLine();
			System.out.print("Enter Phone Number: ");
                	phoneNum = sc.nextLine();
			System.out.print("Enter Email: ");
                	email = sc.nextLine();
			System.out.print("Do you want to add more Contacts(y/n): ");
			check = sc.nextLine();
			System.out.println();

			list.add( new Contact(firstName, lastName, address, city, state, zip, phoneNum, email));
		}
	}

	public static void main(String[] args) {
		addContact();
		System.out.println(list.get(0));
	}
}
