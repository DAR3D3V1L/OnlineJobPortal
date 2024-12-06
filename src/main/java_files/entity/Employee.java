package entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employee")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "contact_num")
    private String contactNumber;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "pin_code")
    private String pinCode;

    @Column(name = "state")
    private String state;

    @Column(name = "street")
    private String street;

    @Column(name = "register_date")
    private Date registerDate;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Qualification> qualifications;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<WorkExperience> workExperiences;


    @OneToOne(mappedBy = "employee")
    private EmployeeProfileInfo employeeProfileInfo;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<EmployeeSkill> employeeSkills;


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "employee")
    private Set<EmployeeRole> roles;


}