package service;

import java.util.List;

import entity.Employee;
import payload.EmployeeDto;

public interface EmployeeService {

    Employee createEmployee(Employee employee);
    List<EmployeeDto> getAllEmployees();
    EmployeeDto getEmployeeById(int employeeId);


}
