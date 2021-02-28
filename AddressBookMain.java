
import java.util.*;

class Contact {

        //variables
        private String firstName, lastName;
        private String address, city, state;
        private String zip;
        private String phoneNum;
        private String email;

	//Default constructor
	public Contact() {

	}

        //initialize variables by constructor
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

	public void setFirstName(String fname) {
        	this.firstName = fname;
	}

	public String getFirstName() {
        	return this.firstName;
    	}

        public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

        public String toString() {
                return "Name: " + firstName + " " + lastName +
                       "\nAddress: " + address + ", " + city + ", " + state +
                       "\nZIP: " + zip + "\nPhone Number: " + phoneNum + "\nEmail: " + email;
        }
}

class AddressBook {

	private static String firstName, lastName, fullName;
	private static String key;
	private static String bookName;

	public static Contact contact = new Contact();

	public AddressBook(String bookName) {
		this.bookName = bookName;
	}

	//to create objects of class contact
        static Map<String,Contact> list = new HashMap<>();

        static Scanner sc = new Scanner(System.in);

	public static boolean checkName() {
		System.out.print("Enter First Name: ");
                firstName = sc.nextLine();
               	System.out.print("Enter Last Name: ");
              	lastName = sc.nextLine();
		fullName = firstName + " " + lastName;
	        for(Map.Entry<String,Contact>ls : list.entrySet()) {
			contact = ls.getValue();
			key = ls.getKey();
                       	if (firstName.equals(contact.getFirstName()) && lastName.equals(contact.getLastName()))
				return true;
		}
		return false;
	}

        //taking input from user
        public static void addContact() {

		System.out.println();
		System.out.println("Add new contact: ");
                String address, city, state, zip, phoneNum, email;
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
		        list.put(fullName, new Contact(firstName, lastName, address, city, state, zip, phoneNum, email));

			System.out.print("Do you want to add more Contacts(y/n): ");
        	        check = sc.nextLine();
                	System.out.println();
		}
        }

        //to edit particular contact
        public static String editContact() {

		System.out.println();
		System.out.println("Edit contact: ");
		if (checkName()) {
                        System.out.println();
                	System.out.print("Enter First Name: ");
                        contact.setFirstName(sc.nextLine());
                        System.out.print("Enter Last Name: ");
                        contact.setLastName(sc.nextLine());
                        System.out.print("Enter Address: ");
                        contact.setAddress(sc.nextLine());
                        System.out.print("Enter City: ");
                        contact.setCity(sc.nextLine());
                        System.out.print("Enter State ");
                        contact.setState(sc.nextLine());
                        System.out.print("Enter ZIP Code: ");
                        contact.setZip(sc.nextLine());
                        System.out.print("Enter Phone Number: ");
                        contact.setPhoneNum(sc.nextLine());
                        System.out.print("Enter Email: ");
                        contact.setEmail(sc.nextLine());
                        System.out.println();
                        System.out.println(contact);
                        return "Updated";
                }
                return "Name not found";
        }

        //to remove contact
        public static String removeContact() {

		System.out.println();
		System.out.println("Remove contact: ");
        	if (checkName()) {
	                list.remove(key);
                	return "Deleted";
                }
                return "Name not found";
        }

	public static void displayContact() {
                for(Map.Entry<String,Contact>ls : list.entrySet()) {
			Contact con = ls.getValue();
                        System.out.println();
                        System.out.println(con);
		}
	}


        public String toString() {
                return bookName;
	}

}

public class AddressBookMain {

	public static int numBook = 0;

	public static ArrayList<AddressBook> book = new ArrayList<>();

	public static void defaultBook() {
		book.add( new AddressBook("default address book"));
	}

	public static void addAddressBook() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter name of new Address Book: ");
		String str = sc.nextLine();
		book.add( new AddressBook(str));
		numBook++;
	}

	public static void removeAddressBook() {
		Scanner sc = new Scanner(System.in);
		if (book.size() > 1) {
			for (int i = 1; i < book.size(); i++)
				System.out.println(i + ". " + book.get(i));
			System.out.print("Choose number to delete: ");
			numBook = sc.nextInt();
			book.remove(numBook);
			numBook = book.size() - 1;
		}
		else
			System.out.println("Only default Address Book is Available");
	}

	public static void choice() {
		Scanner sc = new Scanner(System.in);
		String choose = "y";
		while (choose.equals("y") || choose.equals("y")) {

			System.out.println();
			System.out.println("1. Add Contact");
			System.out.println("2. Edit Contact");
			System.out.println("3. Delete Contact");
			System.out.println("4. Display Contact");
			System.out.println("5. Add Address Book");
			System.out.println("6. Delete Address Book");

			System.out.print("Enter your choice(1-6): ");
			choose = sc.nextLine();
			try {
				switch (choose) {

					case "1":
						book.get(numBook).addContact();
						break;

					case "2":
						book.get(numBook).editContact();
						break;

					case "3":
						book.get(numBook).removeContact();
						break;

					case "4":
						book.get(numBook).displayContact();
						break;

					case "5":
						addAddressBook();
						break;

					case "6":
						removeAddressBook();
						break;

					default:
						System.out.println("Invalid Input");
				}
			}
			catch (Exception e) {
				System.out.println("Invalid input");
			}

			System.out.print("Do you want to do something else(y/n): ");
			choose = sc.nextLine();
		}
	}
        public static void main(String args[]) {
                System.out.println("Welcome to Address Book Program");
		defaultBook();
                choice();
        }
}
