
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
    private static String cityState;
    private static String firstName;
    private static String lastName;

    public static Scanner scanner = new Scanner(System.in);

    public static Map<String, String> cityDictionary = new HashMap<>();
    public static Map<String, String> stateDictionary = new HashMap<>();

    public static Map<String, Integer> cityCount = new HashMap<>();
    public static Map<String, Integer> stateCount = new HashMap<>();

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
        book.get(1).list.add(new Contact("shubha", "kumari", "NA", "dhar", "mp", "NA", "9111649077", "NA"));
        book.get(2).list.add(new Contact("shub", "tata", "NA", "dhar", "mp", "NA", "9111649077", "NA"));
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

    private static void askDetails() {
        System.out.println("Enter State: ");
        cityState = scanner.nextLine();
        System.out.println("Enter First Name");
        firstName = scanner.nextLine();
        System.out.println("Enter out Last Name");
        lastName = scanner.nextLine();
    }

    private static void searchPersonState() {
        askDetails();
        for (AddressBook addressBook: book)
            for (Contact contact: addressBook.list)
                if (contact.getState().equals(cityState) && contact.getFirstName().equals(firstName) && contact.getLastName().equals(lastName))
                    System.out.println(contact);
    }

    private static void searchPersonCity() {
        askDetails();
        for (AddressBook addressBook: book)
            for (Contact contact: addressBook.list)
                if (contact.getCity().equals(cityState) && contact.getFirstName().equals(firstName) && contact.getLastName().equals(lastName))
                    System.out.println(contact);
    }

    private static void personCityDictionary() {
        for (AddressBook addressBook: book)
            for (Contact contact: addressBook.list) {
                String name = contact.getFirstName() + " " + contact.getLastName();
                cityDictionary.put(name, contact.getCity());
            }

        System.out.println("Enter City:");
        cityState = scanner.nextLine();
        for (Map.Entry<String, String> ls : cityDictionary.entrySet())
            if (cityState.equals(ls.getValue()))
                System.out.println("Name: " + ls.getKey());
    }

    private static void personStateDictionary() {
        for (AddressBook addressBook: book)
            for (Contact contact: addressBook.list) {
                String name = contact.getFirstName() + " " + contact.getLastName();
                stateDictionary.put(name, contact.getState());
            }

        System.out.println("Enter State:");
        cityState = scanner.nextLine();
        for (Map.Entry<String, String> ls : stateDictionary.entrySet())
            if (cityState.equals(ls.getValue()))
                System.out.println("Name: " + ls.getKey());
    }

    private static void setCityCount() {
        for (AddressBook addressBook: book)
            for (Contact contact: addressBook.list) {
                cityCount.put(contact.getCity(), 0);
            }

        for (Map.Entry<String, Integer> ls : cityCount.entrySet()) {
            int count = 0;
            for (AddressBook addressBook: book)
                for (Contact contact: addressBook.list)
                    if (contact.getCity().equals(ls.getKey())) {
                        count++;
                        cityCount.put(contact.getCity(), count);
                    }
        }

        for (Map.Entry<String, Integer> ls : cityCount.entrySet()) {
            System.out.println("City: " + ls.getKey() + " Number of Person: " + ls.getValue());
        }
    }

    private static void setStateCount() {
        for (AddressBook addressBook: book)
            for (Contact contact: addressBook.list) {
                stateCount.put(contact.getState(), 0);
            }

        for (Map.Entry<String, Integer> ls : stateCount.entrySet()) {
            int count = 0;
            for (AddressBook addressBook: book)
                for (Contact contact: addressBook.list)
                    if (contact.getState().equals(ls.getKey())) {
                        count++;
                        stateCount.put(contact.getState(), count);
                    }
        }

        for (Map.Entry<String, Integer> ls : stateCount.entrySet()) {
            System.out.println("State: " + ls.getKey() + " Number of Person: " + ls.getValue());
        }
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
            System.out.println("10. View persons in State");
            System.out.println("11. View persons in City");
            System.out.println("12. Number of persons in State");
            System.out.println("13. Number of persons in City");
            System.out.println("14. Exit");

            System.out.print("Enter your choice(1-14): ");
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
                    searchPersonState();
                    break;

                case "9":
                    searchPersonCity();
                    break;

                case "10":
                    personStateDictionary();
                    break;

                case "11":
                    personCityDictionary();
                    break;

                case "12":
                    setStateCount();
                    break;

                case "13":
                    setCityCount();
                    break;

                case "14":
                    System.exit(0);

                default:
                    System.out.println("Invalid Input");
            }
        } catch (AlreadyExistContactException e) {
            System.out.println(e.getMessage());
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Please enter number in given range only");
        } catch (NumberFormatException e) {
            System.out.println("Please enter only valid input");
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
