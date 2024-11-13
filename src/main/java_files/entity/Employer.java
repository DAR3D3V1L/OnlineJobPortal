package entity;
import java.util.Set;

public class Employer {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String contactNumber;
    private String country;
    private String city;
    private String pinCode;
    private String state;
    private String street;

    private Set<String> roles;

    public Employer() {
        super();
    }

    public Employer(int id, String firstName, String lastName, String email, String password, String contactNumber,
                    String country, String city, String pinCode, String state, String street, Set<String> roles) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.contactNumber = contactNumber;
        this.country = country;
        this.city = city;
        this.pinCode = pinCode;
        this.state = state;
        this.street = street;
        this.roles = roles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Employer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
                + ", password=" + password + ", contactNumber=" + contactNumber + ", country=" + country + ", city="
                + city + ", pinCode=" + pinCode + ", state=" + state + ", street=" + street + ", roles=" + roles + "]";
    }
}
