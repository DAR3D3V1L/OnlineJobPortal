package service;

import java.util.List;

import payload.EmployerApplicationsJobsDto;
import payload.JobApplicationDto;

public interface JobApplicationService {

    String  applyJob(int employeeId, int jobId);
    List<JobApplicationDto> getAllApplicationsByEmployee(int employeeId);


    String cancelApplication(int employeeId, int jobId ,int applicationId);

    List<EmployerApplicationsJobsDto> getAllApplicationsByEmployer(int employerId);

    String updateApplicationStatusByEmployer(int applicationId,String status);

    List<EmployerApplicationsJobsDto> getAllApplications();
}
