
import java.util.*;

class AlreadyExistContactException extends Exception{
    public AlreadyExistContactException(String message) {
        super(message);
    }
}

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

    @Override
    public String toString() {
        return "\nName: " + firstName + " " + lastName +
                "\nAddress: " + address + ", " + city + ", " + state +
                "\nZIP: " + zip + "\nPhone Number: " + phoneNum + "\nEmail: " + email;
    }
}

class AddressBook {

    public String bookName;
    public String firstName;
    public String lastName;
    public int index;

    public AddressBook(String bookName) {
        this.bookName = bookName;
    }

    ArrayList<Contact> list = new ArrayList<Contact>();

    Scanner sc = new Scanner(System.in);

    public boolean checkName() {
        System.out.print("\nEnter First Name: ");
        firstName = sc.nextLine();
        System.out.print("Enter Last Name: ");
        lastName = sc.nextLine();
        for(index = 0; index < list.size(); index++) {
            if (firstName.equals(list.get(index).getFirstName()) && lastName.equals(list.get(index).getLastName()))
                return true;
        }
        return false;
    }


    //taking input from user
    public void addContact() throws AlreadyExistContactException {
        String address = null, city = null, state = null, zip = null, phoneNum = null, email = null;
        String check = "y";
        System.out.println("\nAdd Contact");

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
            } else
                throw new AlreadyExistContactException("Contact name already exist");

            System.out.print("Do you want to add more Contacts(y/n): ");
            check = sc.nextLine();
            list.add( new Contact(firstName, lastName, address, city, state, zip, phoneNum, email));
        }
    }

    //to edit particular contact
    public String editContact() {
        System.out.println("\nEdit Contact");
        if (!checkName()) {
            System.out.print("\nEnter First Name: ");
            list.get(index).setFirstName(sc.nextLine());
            System.out.print("Enter Last Name: ");
            list.get(index).setLastName(sc.nextLine());
            System.out.print("Enter Address: ");
            list.get(index).setAddress(sc.nextLine());
            System.out.print("Enter City: ");
            list.get(index).setCity(sc.nextLine());
            System.out.print("Enter State ");
            list.get(index).setState(sc.nextLine());
            System.out.print("Enter ZIP Code: ");
            list.get(index).setZip(sc.nextLine());
            System.out.print("Enter Phone Number: ");
            list.get(index).setPhoneNum(sc.nextLine());
            System.out.print("Enter Email: ");
            list.get(index).setEmail(sc.nextLine());
            System.out.println();
            System.out.println(list.get(index));
            return "Updated";
        }
        return "Name not found";
    }

    //to remove contact
    public String removeContact() {
        System.out.println("\nRemove Contact");
        if (checkName()) {
            list.remove(index);
            return "Deleted";
        }
        return "Name not found";
    }

    public void displayContact() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println();
            System.out.println(list.get(i));
        }
    }

    @Override
    public String toString() {
        return bookName;
    }
}

public class AddressBookMain {

    public static int numBook = 0;
    private static String city;
    private static String state;
    private static String firstName;
    private static String lastName;

    public static Scanner scanner = new Scanner(System.in);

    public static ArrayList<AddressBook> book = new ArrayList<>();

    public static void defaultBook() {
        book.add(new AddressBook("default address book"));
        book.add(new AddressBook("Address Book 1"));
        book.add(new AddressBook("Address Book 2"));
    }

    public static void defaultContact() {
        book.get(0).list.add(new Contact("shubham", "kumar", "NA", "guna", "mp", "NA", "9111649077", "NA"));
        book.get(0).list.add(new Contact("rajesh", "kumar", "NA", "guna", "up", "NA", "9111649077", "NA"));
        book.get(1).list.add(new Contact("suresh", "kumar", "NA", "guna", "up", "NA", "9111649077", "NA"));
        book.get(1).list.add(new Contact("shubham", "kumar", "NA", "dhar", "mp", "NA", "9111649077", "NA"));
        book.get(2).list.add(new Contact("shubham", "kumar", "NA", "dhar", "mp", "NA", "9111649077", "NA"));
    }

    public static void addAddressBook() {
        System.out.print("Enter name of new Address Book: ");
        String str = scanner.nextLine();
        book.add(new AddressBook(str));
    }

    public static void removeAddressBook() {
        if (book.size() > 1) {
            chooseAddressbook();
            book.remove(numBook);
        } else
            System.out.println("Only default Address Book is Available");
    }

    private static void chooseAddressbook() {
        System.out.println("Current Address Book: " + book.get(numBook));
        if (book.size() > 1) {
            for (int i = 0; i < book.size(); i++)
                System.out.println(i + ". " + book.get(i));
            System.out.print("Choose number for Address Book: ");
            numBook = Integer.parseInt(scanner.nextLine());
        }
    }

    private static void personState() {
        System.out.println("Enter State: ");
        state = scanner.nextLine();
        System.out.println("Enter First Name");
        firstName = scanner.nextLine();
        System.out.println("Enter out Last Name");
        lastName = scanner.nextLine();
        for (int i = 0; i < book.size(); i++)
            for (int j = 0; j < book.get(i).list.size(); j++)
                if (book.get(i).list.get(j).getState().equals(state) && book.get(i).list.get(j).getFirstName().equals(firstName) && book.get(i).list.get(j).getLastName().equals(lastName))
                    System.out.println(book.get(i).list.get(j));
    }

    private static void personCity() {
        System.out.println("Enter city: ");
        city = scanner.nextLine();
        System.out.println("Enter First Name");
        firstName = scanner.nextLine();
        System.out.println("Enter out Last Name");
        lastName = scanner.nextLine();
        for (int i = 0; i < book.size(); i++)
            for (int j = 0; j < book.get(i).list.size(); j++)
                if (book.get(i).list.get(j).getCity().equals(city) && book.get(i).list.get(j).getFirstName().equals(firstName) && book.get(i).list.get(j).getLastName().equals(lastName))
                    System.out.println(book.get(i).list.get(j));
    }

    public static void choice() {
        try {
            System.out.println();
            System.out.println("Current Address Book: " + book.get(numBook));
            System.out.println("1. Add Contact");
            System.out.println("2. Edit Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. Display Contact");
            System.out.println("5. Add Address Book");
            System.out.println("6. Delete Address Book");
            System.out.println("7. Switch Address Book");
            System.out.println("8. Search person by State");
            System.out.println("9. Search person by City");
            System.out.println("10. Exit");

            System.out.print("Enter your choice(1-10): ");
            String choose = scanner.nextLine();
            switch (choose) {

                case "1":
                    book.get(numBook).addContact();
                    break;

                case "2":
                    chooseAddressbook();
                    System.out.println(book.get(numBook).editContact());
                    break;

                case "3":
                    chooseAddressbook();
                    System.out.println(book.get(numBook).removeContact());
                    break;

                case "4":
                    chooseAddressbook();
                    book.get(numBook).displayContact();
                    break;

                case "5":
                    addAddressBook();
                    break;

                case "6":
                    removeAddressBook();
                    break;

                case "7":
                    chooseAddressbook();
                    break;

                case "8":
                    personState();
                    break;

                case "9":
                    personCity();
                    break;

                case "10":
                    System.exit(0);

                default:
                    System.out.println("Invalid Input");
            }
        } catch (AlreadyExistContactException e) {
            System.out.println(e.getMessage());
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Please enter number in given range only");
        }
        choice();
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");
        defaultBook();
        defaultContact();
        choice();
    }
}
