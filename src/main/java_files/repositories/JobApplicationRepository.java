package repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import entity.JobApplication;
import payload.EmployerApplicationsJobsDto;

public interface JobApplicationRepository extends JpaRepository<JobApplication, Integer> {


    @Query("from JobApplication j where j.employee.id=:employeeId")
    List<JobApplication> findAllApplicationByEmployeeId(@Param("employeeId") int employeeId);


    @Query(
            "SELECT NEW payload.EmployerApplicationsJobsDto(j.companyName, j.logoPath, " +
                    "j.title,j.jobCategory.title, j.jobType,j.employer.firstName, j.country, ja.id,ja.status) " +
                    "FROM Job j " +
                    "JOIN JobApplication ja ON ja.job.id = j.id " +
                    "WHERE j.employer.id =:employerId"
    )
    List<EmployerApplicationsJobsDto> findAllApplicationForEmployer(@Param("employerId") int employerId);



    @Query(
            "SELECT NEW payload.EmployerApplicationsJobsDto(j.companyName, j.logoPath, " +
                    "j.title,j.jobCategory.title, j.jobType,j.employer.firstName, j.country, ja.id,ja.status) " +
                    "FROM Job j " +
                    "JOIN JobApplication ja ON ja.job.id = j.id "

    )
    List<EmployerApplicationsJobsDto> findAllApplication();


}