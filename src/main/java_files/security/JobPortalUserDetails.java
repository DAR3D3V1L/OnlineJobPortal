package security;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import entity.Employee;
import entity.EmployeeRole;
import entity.Employer;
import entity.EmployerRole;
import exception.JobPortalException;
import repositories.EmployeeRepository;
import repositories.EmployerRepository;

@Service
public class JobPortalUserDetails implements UserDetailsService {

    private final EmployeeRepository employeeRepository;
    private final EmployerRepository employerRepository;

    // Constructor with Spring automatic dependency injection
    public JobPortalUserDetails(EmployeeRepository employeeRepository, EmployerRepository employerRepository) {
        this.employeeRepository = employeeRepository;
        this.employerRepository = employerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // Checking if the user is an employee
        Optional<Employee> employeeOptional = employeeRepository.findByEmail(username);
        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            List<GrantedAuthority> authorities = new ArrayList<>();
            for (EmployeeRole role : employee.getRoles()) {
                authorities.add(new SimpleGrantedAuthority(role.getName()));
            }
            return new org.springframework.security.core.userdetails.User(employee.getEmail(), employee.getPassword(), authorities);
        }

        // Checking if the user is an employer
        Optional<Employer> employerOptional = employerRepository.findByEmail(username);
        if (employerOptional.isPresent()) {
            Employer employer = employerOptional.get();
            List<GrantedAuthority> authorities = new ArrayList<>();
            for (EmployerRole role : employer.getRoles()) {
                authorities.add(new SimpleGrantedAuthority(role.getName()));
            }
            return new org.springframework.security.core.userdetails.User(employer.getEmail(), employer.getPassword(), authorities);
        }

        // If neither employee nor employer is found
        throw new JobPortalException(HttpStatus.BAD_REQUEST, "Email Not Found");
    }
}
