public class Contact {
    private String name;
    private  String lastName;
    private String address;
    private  String city;
    private String state;
    private String phoneNo;
    private String zipCode;

    public Contact() {
    }

//    public Contact(String name, String lastName, String address, String city, String state, String phoneNo, String zipCode) {
//        this.name = name;
//        this.lastName = lastName;
//        this.address = address;
//        this.city = city;
//        this.state = state;
//        this.phoneNo = phoneNo;
//        this.zipCode = zipCode;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
    String[] getContactStrings() {
        return new String[]{name, lastName, address, city, state, zipCode + "", phoneNo + ""};
    }
}
