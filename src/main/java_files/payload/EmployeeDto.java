package payload;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {


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
    private List<QualificationDto> qualifications;
    private List<WorkExperienceDto> workExperiences;
    private EmployeeProfileResponse employeeProfile;
    private List<EmployeeSkillDto> employeeSkills;
}
