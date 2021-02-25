
import java.util.*;

class Contact {
        //variables
        private String firstName, lastName;
        private String address, city, state;
        private String zip;
        private String phoneNum;
        private String email;
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

public class AddressBookMain {
        //to add new objects
        static ArrayList<Contact> list = new ArrayList<Contact>();

        static Scanner sc = new Scanner(System.in);

        //taking input from user
        public static void addContact() {
                String firstName, lastName, address, city, state, zip, phoneNum, email;
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
        //to edit particular contact
        public static String edit() {
                String name1st, name2nd;
                System.out.print("Enter first name: ");
                name1st = sc.nextLine();
                System.out.print("Enter Second name: ");
                name2nd = sc.nextLine();

                for(int i = 0; i < list.size(); i++) {
                        if (name1st.equals(list.get(i).getFirstName()) && name2nd.equals(list.get(i).getLastName())) {
                                System.out.print("Enter First Name: ");
                                list.get(i).setFirstName(sc.nextLine());
                                System.out.print("Enter Last Name: ");
                                list.get(i).setLastName(sc.nextLine());
                                System.out.print("Enter Address: ");
                                list.get(i).setAddress(sc.nextLine());
                                System.out.print("Enter City: ");
                                list.get(i).setCity(sc.nextLine());
                                System.out.print("Enter State ");
                                list.get(i).setState(sc.nextLine());
                                System.out.print("Enter ZIP Code: ");
                                list.get(i).setZip(sc.nextLine());
                                System.out.print("Enter Phone Number: ");
                                list.get(i).setPhoneNum(sc.nextLine());
                                System.out.print("Enter Email: ");
                                list.get(i).setEmail(sc.nextLine());
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
                        if (name1st.equals(list.get(i).getFirstName()) && name2nd.equals(list.get(i).getLastName())) {
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
