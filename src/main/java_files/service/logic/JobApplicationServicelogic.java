package service.logic;

import static utils.AppConstant.JOB_APPLICATION_STATUS.APPLIED;
import static utils.AppConstant.JOB_APPLICATION_STATUS.CANCELED;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import entity.Employee;
import entity.Job;
import entity.JobApplication;
import exception.JobPortalException;
import exception.ResourceNotFoundException;
import payload.EmployerApplicationsJobsDto;
import payload.JobApplicationDto;
import payload.JobResponse;
import repositories.EmployeeRepository;
import repositories.JobApplicationRepository;
import repositories.JobRepository;
import service.JobApplicationService;

@Service
public class JobApplicationServicelogic implements JobApplicationService {

    private JobApplicationRepository jobApplicationRepository;
    private EmployeeRepository employeeRepository;
    private JobRepository jobRepository;
    private ModelMapper modelMapper;

    public JobApplicationServicelogic(
            JobApplicationRepository jobApplicationRepository,
            EmployeeRepository employeeRepository,
            JobRepository jobRepository,
            ModelMapper modelMapper) {

        this.jobApplicationRepository = jobApplicationRepository;
        this.employeeRepository = employeeRepository;
        this.jobRepository = jobRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public String applyJob(int employeeId, int jobId) {
        Employee employee = checkEmployeeExistence(employeeId);
        Job job = checkJobExistence(jobId);

        JobApplication jobApplication = new JobApplication();
        jobApplication.setEmployee(employee);
        jobApplication.setJob(job);
        jobApplication.setAppliedDate(LocalDateTime.now());
        jobApplication.setStatus(APPLIED.toString());

        jobApplicationRepository.save(jobApplication);
        return "Job Applied Successfully";
    }

    @Override
    public List<JobApplicationDto> getAllApplicationsByEmployee(int employeeId) {
        checkEmployeeExistence(employeeId);
        List<JobApplication> jobApplications = jobApplicationRepository.findAllApplicationByEmployeeId(employeeId);

        return jobApplications.stream().map((jobApp) -> {
            JobApplicationDto jobApplicationDto = new JobApplicationDto();
            jobApplicationDto.setApplicationId(jobApp.getId());
            jobApplicationDto.setStatus(jobApp.getStatus());
            jobApplicationDto.setAppliedDate(jobApp.getAppliedDate());
            jobApplicationDto.setJobResponse(mapToJobDto(jobApp.getJob()));
            return jobApplicationDto;
        }).collect(Collectors.toList());
    }

    @Override
    public String cancelApplication(int employeeId, int jobId, int applicationId) {
        checkEmployeeExistence(employeeId);
        checkJobExistence(jobId);
        JobApplication jobApplication = checkJobApplicationExistence(applicationId);

        jobApplication.setStatus(CANCELED.toString());
        jobApplicationRepository.save(jobApplication);

        return "Job Application Canceled Successfully";
    }

    @Override
    public List<EmployerApplicationsJobsDto> getAllApplicationsByEmployer(int employerId) {
        return jobApplicationRepository.findAllApplicationForEmployer(employerId).stream()
                .map((job) -> {
                    job.setCompanyLogo(Paths.get(job.getCompanyLogo()).getFileName().toString());
                    return job;
                }).collect(Collectors.toList());
    }

    @Override
    public String updateApplicationStatusByEmployer(int applicationId, String status) {
        JobApplication jobApplication = checkJobApplicationExistence(applicationId);

        if (jobApplication.getStatus().equals(CANCELED.toString())) {
            throw new JobPortalException(HttpStatus.BAD_REQUEST,
                    "This Application is Already Canceled, You can't Change it");
        }

        jobApplication.setStatus(status);
        jobApplicationRepository.save(jobApplication);

        return "Application Status Changed Successfully";
    }

    @Override
    public List<EmployerApplicationsJobsDto> getAllApplications() {
        return jobApplicationRepository.findAllApplication();
    }

    private JobResponse mapToJobDto(Job job) {
        JobResponse jobResponse = modelMapper.map(job, JobResponse.class);
        jobResponse.setCompanyLogo(Path.of(job.getLogoPath()).getFileName().toString());
        return jobResponse;
    }

    private Employee checkEmployeeExistence(int employeeId) {
        return employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "id", employeeId)
        );
    }

    private Job checkJobExistence(int jobId) {
        return jobRepository.findById(jobId).orElseThrow(
                () -> new ResourceNotFoundException("Job", "id", jobId)
        );
    }

    private JobApplication checkJobApplicationExistence(int applicationId) {
        return jobApplicationRepository.findById(applicationId).orElseThrow(
                () -> new ResourceNotFoundException("JobApplication", "id", applicationId)
        );
    }
}
