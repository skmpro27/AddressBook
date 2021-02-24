
import java.util.*;

class Contact {
	//variables
	public String firstName, lastName;
	public String address, city, state;
	public String zip;
	public String phoneNum;
	public String email;
	//intiallize variables by constructor
	public Contact(String firstName, String lastName, String address, String city, String state, String zip, String phoneNum, String email) {
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

	static Scanner sc = new Scanner(System.in);

	//taking input from user
	public static void addContact() {
		String firstName, lastName, address, city, state, zip, phoneNum, email;
		Scanner sc = new Scanner(System.in);
		String check = "y";
		while(check.equals("y") || check.equals("Y")) {
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
	//to edit paticular contact
	public static String edit() {
		String name1st, name2nd;
		System.out.print("Enter first name: ");
		name1st = sc.nextLine();
		System.out.print("Enter Second name: ");
		name2nd = sc.nextLine();

		for(int i = 0; i < list.size(); i++) {
			if (name1st.equals(list.get(i).firstName) && name2nd.equals(list.get(i).lastName)) {
				System.out.print("Enter First Name: ");
				list.get(i).firstName = sc.nextLine();
				System.out.print("Enter Last Name: ");
                		list.get(i).lastName = sc.nextLine();
				System.out.print("Enter Address: ");
                		list.get(i).address = sc.nextLine();
				System.out.print("Enter City: ");
        	        	list.get(i).city = sc.nextLine();
				System.out.print("Enter State ");
                		list.get(i).state = sc.nextLine();
				System.out.print("Enter ZIP Code: ");
        	        	list.get(i).zip = sc.nextLine();
				System.out.print("Enter Phone Number: ");
                		list.get(i).phoneNum = sc.nextLine();
				System.out.print("Enter Email: ");
	                	list.get(i).email = sc.nextLine();
				System.out.println();
				System.out.println(list.get(i));
				return "Updated";
			}
		}
		return "Name not found";
	}
	//to remove contact
	public static String remove() {
		String name1st, name2nd;
		System.out.print("Enter first name: ");
		name1st = sc.nextLine();
		System.out.print("Enter Second name: ");
		name2nd = sc.nextLine();

		for(int i = 0; i < list.size(); i++) {
			if (name1st.equals(list.get(i).firstName) && name2nd.equals(list.get(i).lastName)) {
				list.remove(i);
				return "Deleted";
			}
		}
		return "Name not found";
	}

	public static void main(String[] args) {
		System.out.println("Welcome to Address Book Program");
		addContact();
		System.out.println(edit());
		System.out.println(remove());
		for(int i = 0; i < list.size(); i++)
			System.out.println(list.get(i));
	}
}
