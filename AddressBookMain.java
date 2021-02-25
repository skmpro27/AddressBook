
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
		this("NA", "NA", "NA", "NA", "NA", "NA", "NA", "NA");
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

public class AddressBookMain {

	private static String firstName, lastName;
	static int key;
	static Contact con = new Contact();
	//to create objects of class contact
        static Map<Integer,Contact> list = new HashMap<>();

        static Scanner sc = new Scanner(System.in);

	public static boolean checkName() {
		System.out.print("Enter First Name: ");
                firstName = sc.nextLine();
               	System.out.print("Enter Last Name: ");
              	lastName = sc.nextLine();
	        for(Map.Entry<Integer,Contact>ls : list.entrySet()) {
			con = ls.getValue();
			key = ls.getKey();
                       	if (firstName.equals(con.getFirstName()) && lastName.equals(con.getLastName())) {
				return true;
			}
		}
		return false;
	}

        //taking input from user
        public static void addContact() {
                String address, city, state, zip, phoneNum, email;
		String check = "y";
		int i = 1;

                while(check.equals("y") || check.equals("Y")) {

	       		if (!checkName()) {
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
		                list.put(i, new Contact(firstName, lastName, address, city, state, zip, phoneNum, email));
				i++;
			}
			else
				System.out.println("Contact already exist");
			System.out.print("Do you want to add more Contacts(y/n): ");
                        check = sc.nextLine();
	                System.out.println();

		}
        }
        //to edit particular contact
        public static String edit() {
		if (checkName()) {
                        System.out.println();
                	System.out.print("Enter First Name: ");
                        con.setFirstName(sc.nextLine());
                        System.out.print("Enter Last Name: ");
                        con.setLastName(sc.nextLine());
                        System.out.print("Enter Address: ");
                        con.setAddress(sc.nextLine());
                        System.out.print("Enter City: ");
                        con.setCity(sc.nextLine());
                        System.out.print("Enter State ");
                        con.setState(sc.nextLine());
                        System.out.print("Enter ZIP Code: ");
                        con.setZip(sc.nextLine());
                        System.out.print("Enter Phone Number: ");
                        con.setPhoneNum(sc.nextLine());
                        System.out.print("Enter Email: ");
                        con.setEmail(sc.nextLine());
                        System.out.println();
                        System.out.println(con);
                        return "Updated";
                }
                return "Name not found";
        }
        //to remove contact
        public static String remove() {

        	if (checkName()) {
	                list.remove(key);
                	return "Deleted";
                }
                return "Name not found";
        }

	public static void display() {
                for(Map.Entry<Integer,Contact>ls : list.entrySet()) {
			Contact con = ls.getValue();
                        System.out.println();
                        System.out.println(con);
		}
	}

        public static void main(String[] args) {
                System.out.println("Welcome to Address Book Program");
                addContact();
                System.out.println(edit());
                System.out.println(remove());
		display();
        }
}
