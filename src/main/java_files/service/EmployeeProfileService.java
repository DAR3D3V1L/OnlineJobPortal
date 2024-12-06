package service;

import java.io.IOException;

import payload.EmployeeProfileDto;
import payload.EmployeeProfileResponse;

public interface EmployeeProfileService {

    EmployeeProfileResponse createEmployeeProfile(EmployeeProfileDto employeeProfileDto , int employeeId) throws IOException;

}
