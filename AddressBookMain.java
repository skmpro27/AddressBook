
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.*;

class AlreadyExistContactException extends Exception{
    public AlreadyExistContactException(String message) {
        super(message);
    }
}

enum InputTypeDictionary {
    ENTERED_CITY {
        @Override
        public Map<String, String> stateOrCityDictionary() {
            return AddressBookMain.cityDictionary;
        }
    },
    ENTERED_STATE {
        @Override
        public Map<String, String> stateOrCityDictionary() {
            return AddressBookMain.stateDictionary;
        }
    };

    public abstract Map<String, String> stateOrCityDictionary();
}

enum InputType {
    ENTERED_CITY {
        @Override
        public String stateOrCity(Contact contact) {
            return contact.getCity();
        }
    },
    ENTERED_STATE {
        @Override
        public String stateOrCity(Contact contact) {
            return contact.getState();
        }
    };
    public abstract String stateOrCity(Contact contact);
}

enum InputTypeCompare {
    SORT_BY_NAME {
        @Override
        public Comparator<Contact> nameOrAddressCompare() {
            return Comparator.comparing(Contact::getFirstName).thenComparing(Contact::getLastName);
        }
    },
    SORT_BY_ADDRESS {
        @Override
        public Comparator<Contact> nameOrAddressCompare(){
            return Comparator.comparing(Contact::getFirstName).thenComparing(Contact::getLastName);
        }
    };
    public abstract Comparator<Contact> nameOrAddressCompare();
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

    private InputType type;
    private InputTypeCompare typeCompare;
    private InputTypeDictionary typeDictionary;

    private int numBook = 0;
    private String cityState;
    private String firstName;
    private String lastName;
    private String string;

    public Scanner scanner = new Scanner(System.in);

    public static Map<String, String> stateDictionary = new HashMap<>();
    public static Map<String, String> cityDictionary = new HashMap<>();

    public List<Contact> allContacts = new ArrayList<>();
    public ArrayList<AddressBook> book = new ArrayList<>();

    public void defaultBook() {
        book.add(new AddressBook("default address book"));
        book.add(new AddressBook("Address Book 1"));
        book.add(new AddressBook("Address Book 2"));
    }

    public void defaultContact() {
        book.get(0).contactList.add(new Contact("shubham", "kumar", "NA", "guna", "mp", "473111", "9111649077", "NA"));
        book.get(0).contactList.add(new Contact("rajesh", "kumar", "NA", "guna", "up", "473001", "9111649077", "NA"));
        book.get(1).contactList.add(new Contact("suresh", "kumar", "NA", "guntur", "ap", "522001", "9111649077", "NA"));
        book.get(1).contactList.add(new Contact("shubham", "verma", "NA", "dhar", "mp", "454001", "9111649077", "NA"));
        book.get(2).contactList.add(new Contact("shub", "tata", "NA", "dhar", "mp", "454001", "9111649077", "NA"));
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
        System.out.print("\nEnter " + string);
        cityState = scanner.nextLine();
        System.out.print("Enter First Name: ");
        firstName = scanner.nextLine();
        System.out.print("Enter out Last Name: ");
        lastName = scanner.nextLine();
    }

    private void reduceToSingleContactList() {
        book.forEach(addressBook -> allContacts.addAll(addressBook.contactList));
    }

    private  void reduceListToNull() {
        allContacts.clear();
    }

    private final Predicate<Contact> isPresentInState = contact -> type.stateOrCity(contact).equals(cityState) && contact.getFirstName().equals(firstName) && contact.getLastName().equals(lastName);
    private final Consumer<String> displayCount = nameOfPlace -> System.out.println("Number of person in " + nameOfPlace + ": " + allContacts.stream().filter(contact -> nameOfPlace.equals(type.stateOrCity(contact))).count());

    private void personStateOrCity() {
        askDetails();
        //to search a person by his name and city or state
        allContacts.stream()
                .filter(isPresentInState)
                .forEach(System.out::println);
    }

    private void personStateOrCityDictionary() {
        System.out.print("\nEnter " + string);
        cityState = scanner.nextLine();
        //to search for persons in city or state and maintain dictionary for the same
        allContacts.stream()
                .filter(contact -> type.stateOrCity(contact).equals(cityState))
                .forEach(contact -> typeDictionary.stateOrCityDictionary().put(contact.getFirstName() + " " + contact.getLastName(), type.stateOrCity(contact)));

       typeDictionary.stateOrCityDictionary().forEach((key, value) -> System.out.println("Name: " + key));
    }

    private void getCountCityState() {
        System.out.println();
        //to make a list of city
        allContacts.stream()
                .map(type::stateOrCity)
                .distinct()
                .forEach(displayCount);
    }

    private void sortByNameOrAddress() {
        System.out.println();
        //sort the contact by name or by city, state or zip
        allContacts.stream()
                .sorted(typeCompare.nameOrAddressCompare())
                .forEach(System.out::println);
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
            System.out.println("14. Sort by Name");
            System.out.println("15. Sort by Address");
            System.out.println("16. Exit");

            System.out.print("Enter your choice(1-16): ");
            String choose = scanner.nextLine();
            reduceToSingleContactList();
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
                    typeDictionary = InputTypeDictionary.ENTERED_STATE;
                    personStateOrCityDictionary();
                    break;

                case "11":
                    string = "City: ";
                    type = InputType.ENTERED_CITY;
                    typeDictionary = InputTypeDictionary.ENTERED_CITY;
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
                    typeCompare = InputTypeCompare.SORT_BY_NAME;
                    sortByNameOrAddress();
                    break;

                case "15":
                    typeCompare = InputTypeCompare.SORT_BY_ADDRESS;
                    sortByNameOrAddress();
                    break;

                case "16":
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
        System.out.println("-------------X-------------\nPress any key to continue: ");
        string = scanner.nextLine();
        reduceListToNull();
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
