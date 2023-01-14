import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class AddressBookMain {
    static HashMap<String, AddressBook> addressBookMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        System.out.println("WelCome To AddressBook Program");
        Scanner scanner = new Scanner(System.in);
        int operation;
        System.out.println("WelCome To AddressBook Program");
        do {
            System.out.println("1. ADD Addressbook \n2. Perform Operations into AddressBook \n3 Display all address book \n4 searchAddressBooksDetails \n5 WriteInFile_IO \n6 ReadFileInFile_IO \n7 Write In CSV \n8 Read IN CSV \n9 Exit");
            System.out.println("Enter the Operation Number");
            operation = scanner.nextInt();
            scanner.nextLine();
            switch (operation) {
                case 1:
                    System.out.println("Enter the name of address book");
                    String name1 = scanner.nextLine();
                    AddressBook addressBook = new AddressBook();
                    addressBookMap.put(name1, addressBook);
                    break;
                case 2:
                    System.out.println("Enter the name of address book into which you want to perform the operations");
                    String bookName = scanner.nextLine();
                    AddressBook addressBookToAdd = addressBookMap.get(bookName);
                    addressBookToAdd.choice();
                    break;
                case 3:
                    for (Map.Entry<String, AddressBook> set : addressBookMap.entrySet()) {
                        System.out.println(set.getKey() + "=" + set.getValue());
                    }
                    break;
                case 4:
                    int option;
                    do {
                        System.out.println("1.Search in city");
                        System.out.println("2.Search in state");
                        System.out.println("3.Search person");
                        System.out.println("4.Number of persons in city");
                        System.out.println("5.Number of persons in state");
                        System.out.println("6.Sort the contact list use firstname");
                        System.out.println("7.Sort contact details by  state ");
                        System.out.println("8.Sort contact details by city");
                        System.out.println("9.Sort contact details by  zip code");
                        System.out.println("10.Exit");
                        System.out.print("Enter option : ");
                        Scanner input = new Scanner(System.in);
                        option = input.nextInt();
                        switch (option) {
                            case 1:
                                System.out.print("Enter city name : ");
                                String cityName = input.next();
                                for (AddressBook list : addressBookMap.values()) {
                                    list.contactList.stream().filter(city -> city.getCity().equalsIgnoreCase(cityName)).forEach(x -> System.out.println(x));
                                }
                                break;
                            case 2:
                                System.out.print("Enter State name : ");
                                String stateName = input.next();
                                for (AddressBook list : addressBookMap.values()) {
                                    list.contactList.stream().filter(state -> state.getState().equalsIgnoreCase(stateName)).forEach(x -> System.out.println(x));
                                }
                                break;
                            case 3:
                                System.out.println("Enter Person name : ");
                                String personName = input.next();
                                for (AddressBook list : addressBookMap.values()) {
                                    list.contactList.stream().filter(state -> state.getName().equalsIgnoreCase(personName)).forEach(x -> System.out.println(x));
                                }
                                break;
                            case 4:
                                System.out.println("Enter Person city name to count person : ");
                                String giveName = input.next();
                                for (AddressBook list : addressBookMap.values()) {
                                    Long countPerson = list.contactList.stream().filter(person -> person.getCity().equalsIgnoreCase(giveName)).count();
                                    System.out.println(countPerson);
                                }
                                break;
                            case 5:
                                System.out.println("Enter Person State name to count person : ");
                                String stateNameCount = input.next();//array={10,12}
                                //string refrance:array
                                for (AddressBook list : addressBookMap.values()) {
                                    Long countPerson = list.contactList.stream().filter(person -> person.getState().equalsIgnoreCase(stateNameCount)).count();
                                    System.out.println(countPerson);
                                }
                                break;
                            case 6:
                                List<Contact> personList;
                                for (AddressBook list : addressBookMap.values()) {
                                    personList = list.contactList.stream().sorted((a, b) -> a.getName().compareTo(b.getName())).collect(Collectors.toList());
                                    System.out.println(personList);
                                }
                                break;
                            case 7:
//                               List<Contact> personList1 ;
                                for (AddressBook list : addressBookMap.values()) {
                                    list.contactList.stream().sorted((a, b) -> a.getState().compareTo(b.getState())).forEach(x -> System.out.println(x));
//                                    System.out.println(personList1);
                                }
                                break;
                            case 8:
                                List<Contact> personList2;
                                for (AddressBook list : addressBookMap.values()) {
                                    personList2 = list.contactList.stream().sorted(Comparator.comparing(Contact::getCity)).collect(Collectors.toList());
                                    System.out.println(personList2);
                                }
                                break;
                            case 9:
                                List<Contact> personList3;
                                for (AddressBook list : addressBookMap.values()) {
                                    personList3 = list.contactList.stream().sorted(Comparator.comparing(Contact::getZipCode)).collect(Collectors.toList());
                                    System.out.println(personList3);
                                }
                                break;
                            case 10:
                                System.out.println("Exiting");
                            default:
                                System.out.println("Enter The Wrong Opration Number");
                        }
                    } while (option != 10);
                case 5:
                    String txtPath = "E:\\bridzlabz\\Java\\AddressBookCSVFileReadAndWrite\\src\\main\\java\\AddressBookTXT.txt";
                    AddressBook.writeFile(addressBookMap, txtPath);
                    break;
                case 6:
                    String txtPath1 = "E:\\bridzlabz\\Java\\AddressBookCSVFileReadAndWrite\\src\\main\\java\\AddressBookTXT.txt";
                    AddressBook book=new AddressBook();
                    book.readFile(txtPath1);
                    break;
                case 7:
                    String txtPath3 = "E:\\bridzlabz\\Java\\AddressBookCSVFileReadAndWrite\\src\\main\\java\\AddressBookCsv.csv";
                    AddressBook.writeFileCSV(addressBookMap, txtPath3);
                    break;
                case 8:
                    String txtPath4 = "E:\\bridzlabz\\Java\\AddressBookCSVFileReadAndWrite\\src\\main\\java\\AddressBookCsv.csv";
                    AddressBook.readFileCSV(addressBookMap, txtPath4);
                    break;
                case 9:
                    System.out.println("Existing");
                default:
                    System.out.println("Enter The Wrong Opration Number");
            }
        } while (operation != 9);
        System.out.println();

    }
}
