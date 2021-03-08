
import java.util.function.Consumer;
import java.util.function.Predicate;
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

    ArrayList<Contact> contactList = new ArrayList<Contact>();

    Scanner sc = new Scanner(System.in);

    public boolean checkName() {
        System.out.print("\nEnter First Name: ");
        firstName = sc.nextLine();
        System.out.print("Enter Last Name: ");
        lastName = sc.nextLine();
        for(index = 0; index < contactList.size(); index++) {
            if (firstName.equals(contactList.get(index).getFirstName()) && lastName.equals(contactList.get(index).getLastName()))
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
            contactList.add( new Contact(firstName, lastName, address, city, state, zip, phoneNum, email));
        }
    }

    //to edit particular contact
    public String editContact() {
        System.out.println("\nEdit Contact");
        if (!checkName()) {
            System.out.print("\nEnter First Name: ");
            contactList.get(index).setFirstName(sc.nextLine());
            System.out.print("Enter Last Name: ");
            contactList.get(index).setLastName(sc.nextLine());
            System.out.print("Enter Address: ");
            contactList.get(index).setAddress(sc.nextLine());
            System.out.print("Enter City: ");
            contactList.get(index).setCity(sc.nextLine());
            System.out.print("Enter State ");
            contactList.get(index).setState(sc.nextLine());
            System.out.print("Enter ZIP Code: ");
            contactList.get(index).setZip(sc.nextLine());
            System.out.print("Enter Phone Number: ");
            contactList.get(index).setPhoneNum(sc.nextLine());
            System.out.print("Enter Email: ");
            contactList.get(index).setEmail(sc.nextLine());
            System.out.println();
            System.out.println(contactList.get(index));
            return "Updated";
        }
        return "Name not found";
    }

    //to remove contact
    public String removeContact() {
        System.out.println("\nRemove Contact");
        if (checkName()) {
            contactList.remove(index);
            return "Deleted";
        }
        return "Name not found";
    }

    public void displayContact() {
        for (int i = 0; i < contactList.size(); i++) {
            System.out.println();
            System.out.println(contactList.get(i));
        }
    }

    @Override
    public String toString() {
        return bookName;
    }
}

public class AddressBookMain {

    enum InputType {
        ENTERED_STATE, ENTERED_CITY
    }

    private InputType type;

    private int numBook = 0;
    private String cityState;
    private String firstName;
    private String lastName;
    private String string;

    public Scanner scanner = new Scanner(System.in);

    public Map<String, String> stateDictionary = new HashMap<>();
    public Map<String, String> cityDictionary = new HashMap<>();

    public List<String> cityCount = new ArrayList<>();
    public List<String> stateCount = new ArrayList<>();
    
    public ArrayList<AddressBook> book = new ArrayList<>();

    public void defaultBook() {
        book.add(new AddressBook("default address book"));
        book.add(new AddressBook("Address Book 1"));
        book.add(new AddressBook("Address Book 2"));
    }

    public void defaultContact() {
        book.get(0).contactList.add(new Contact("shubham", "kumar", "NA", "guna", "mp", "NA", "9111649077", "NA"));
        book.get(0).contactList.add(new Contact("rajesh", "kumar", "NA", "guna", "up", "NA", "9111649077", "NA"));
        book.get(1).contactList.add(new Contact("suresh", "kumar", "NA", "guntur", "ap", "NA", "9111649077", "NA"));
        book.get(1).contactList.add(new Contact("shubha", "kumari", "NA", "dhar", "mp", "NA", "9111649077", "NA"));
        book.get(2).contactList.add(new Contact("shub", "tata", "NA", "dhar", "mp", "NA", "9111649077", "NA"));
    }

    public void addAddressBook() {
        System.out.print("Enter name of new Address Book: ");
        String str = scanner.nextLine();
        book.add(new AddressBook(str));
    }

    public void removeAddressBook() {
        if (book.size() > 1) {
            chooseAddressBook();
            book.remove(numBook);
        } else
            System.out.println("Only default Address Book is Available");
    }

    private void chooseAddressBook() {
        System.out.println("Current Address Book: " + book.get(numBook));
        if (book.size() > 1) {
            for (int i = 0; i < book.size(); i++)
                System.out.println(i + ". " + book.get(i));
            System.out.print("Choose number for Address Book: ");
            numBook = Integer.parseInt(scanner.nextLine());
        }
    }

    private void askDetails() {
        System.out.print("Enter " + string + ": ");
        cityState = scanner.nextLine();
        System.out.print("Enter First Name");
        firstName = scanner.nextLine();
        System.out.print("Enter out Last Name");
        lastName = scanner.nextLine();
    }

    private String stateOrCity(Contact contact) {
        switch (type) {
            case ENTERED_CITY:
                return contact.getCity();

            case ENTERED_STATE:
                return contact.getState();

            default:
                return " ";
        }
    }

    private Map<String, String> stateOrCityDictionary() {
        if (InputType.ENTERED_CITY == type)
            return cityDictionary;
        else
            return stateDictionary;
    }

    private List<String> cityOrStateCount() {
        if (InputType.ENTERED_CITY == type)
            return cityCount;
        else
            return stateCount;
    }

    private final Predicate<Contact> isPresentInState = contact -> stateOrCity(contact).equals(cityState) && contact.getFirstName().equals(firstName) && contact.getLastName().equals(lastName);
    private final Consumer<String> displayCount = nameOfPlace -> System.out.println("Number of person in " + nameOfPlace + ": " + cityOrStateCount().stream().filter(n1 -> n1.equals(nameOfPlace)).count());

    private void personStateOrCity() {
        askDetails();
        //to search a person by his name and city or state
        book.forEach(addressBook -> addressBook.contactList.stream()
                .filter(isPresentInState)
                .forEach(System.out::println));
    }

    private void personStateOrCityDictionary() {
        System.out.print("Enter " + string + ": ");
        cityState = scanner.nextLine();
        //to search for persons in city or state and maintain dictionary for the same
        book.forEach(addressBook -> addressBook.contactList.stream()
                .filter(contact -> stateOrCity(contact).equals(cityState))
                .forEach(contact -> stateOrCityDictionary().put(contact.getFirstName() + " " + contact.getLastName(), stateOrCity(contact))));

        stateOrCityDictionary().forEach((key, value) -> System.out.println("Name: " + key));
    }

    private void getCountCityState() {
        //to make a list of city
        book.forEach(addressBook -> addressBook.contactList
               .forEach(contact -> cityOrStateCount().add(stateOrCity(contact))));

        //to display count of state or city
        cityOrStateCount().stream()
                .distinct()
               .forEach(displayCount);
    }

    public void choice() {
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
                    chooseAddressBook();
                    System.out.println(book.get(numBook).editContact());
                    break;

                case "3":
                    chooseAddressBook();
                    System.out.println(book.get(numBook).removeContact());
                    break;

                case "4":
                    chooseAddressBook();
                    book.get(numBook).displayContact();
                    break;

                case "5":
                    addAddressBook();
                    break;

                case "6":
                    removeAddressBook();
                    break;

                case "7":
                    chooseAddressBook();
                    break;

                case "8":
                    string = "State: ";
                    type = InputType.ENTERED_STATE;
                    personStateOrCity();
                    break;

                case "9":
                    string = "City: ";
                    type = InputType.ENTERED_CITY;
                    personStateOrCity();
                    break;

                case "10":
                    string = "State: ";
                    type = InputType.ENTERED_STATE;
                    personStateOrCityDictionary();
                    break;

                case "11":
                    string = "City: ";
                    type = InputType.ENTERED_CITY;
                    personStateOrCityDictionary();
                    break;

                case "12":
                    type = InputType.ENTERED_STATE;
                    getCountCityState();
                    break;

                case "13":
                    type = InputType.ENTERED_CITY;
                    getCountCityState();
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
        } catch (Exception e) {
            System.out.println("Some problem is there");
        }
        choice();
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");
        AddressBookMain bookMain = new AddressBookMain();
        bookMain.defaultBook();
        bookMain.defaultContact();
        bookMain.choice();
    }
}
