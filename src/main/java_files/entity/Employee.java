package entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class Employee {

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
    private Date registerDate;
    private List<Qualification> qualifications;
    private List<WorkExperience> workExperiences;
    private EmployeeProfileInfo employeeProfileInfo;
    private List<EmployeeSkill> employeeSkills;
    private Set<EmployeeRole> roles;

    public Employee() {
        super();
    }

    public Employee(int id, String firstName, String lastName, String email, String password, String contactNumber,
                    String country, String city, String pinCode, String state, String street, Date registerDate,
                    List<Qualification> qualifications, List<WorkExperience> workExperiences,
                    EmployeeProfileInfo employeeProfileInfo, List<EmployeeSkill> employeeSkills, Set<EmployeeRole> roles) {
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
        this.registerDate = registerDate;
        this.qualifications = qualifications;
        this.workExperiences = workExperiences;
        this.employeeProfileInfo = employeeProfileInfo;
        this.employeeSkills = employeeSkills;
        this.roles = roles;
    }

    // Getters and Setters

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

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public List<Qualification> getQualifications() {
        return qualifications;
    }

    public void setQualifications(List<Qualification> qualifications) {
        this.qualifications = qualifications;
    }

    public List<WorkExperience> getWorkExperiences() {
        return workExperiences;
    }

    public void setWorkExperiences(List<WorkExperience> workExperiences) {
        this.workExperiences = workExperiences;
    }

    public EmployeeProfileInfo getEmployeeProfileInfo() {
        return employeeProfileInfo;
    }

    public void setEmployeeProfileInfo(EmployeeProfileInfo employeeProfileInfo) {
        this.employeeProfileInfo = employeeProfileInfo;
    }

    public List<EmployeeSkill> getEmployeeSkills() {
        return employeeSkills;
    }

    public void setEmployeeSkills(List<EmployeeSkill> employeeSkills) {
        this.employeeSkills = employeeSkills;
    }

    public Set<EmployeeRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<EmployeeRole> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
                + ", contactNumber=" + contactNumber + ", country=" + country + ", city=" + city + ", pinCode="
                + pinCode + ", state=" + state + ", street=" + street + ", registerDate=" + registerDate
                + ", qualifications=" + qualifications + ", workExperiences=" + workExperiences
                + ", employeeProfileInfo=" + employeeProfileInfo + ", employeeSkills=" + employeeSkills
                + ", roles=" + roles + "]";
    }
}
