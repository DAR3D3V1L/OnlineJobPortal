package repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import entity.Job;
import payload.JobResponse;

public interface JobRepository extends JpaRepository<Job, Integer> {

    @Query("SELECT NEW backend.jobportal.payload.JobResponse(j.id,j.title,j.companyName,j.jobDescription,j.skills," +
            "j.jobType,j.salaryRange,j.experience,j.street,j.city,j.PinCode,j.country,j.logoPath,j.jobCategory.title,j.employer.id) " +
            "FROM Job j ")
    List<JobResponse> findByAllJobs();


    @Query("SELECT NEW backend.jobportal.payload.JobResponse(j.id,j.title,j.companyName,j.jobDescription,j.skills," +
            "j.jobType,j.salaryRange,j.experience,j.street,j.city,j.PinCode,j.country,j.logoPath,j.jobCategory.title,j.employer.id) " +
            "FROM Job j " +
            "WHERE j.employer.id = :employerId")
    List<JobResponse> findByAllJobsByEmployerId(@Param("employerId") int employerId);


    @Query(
            "SELECT NEW backend.jobportal.payload.JobResponse(j.id,j.title,j.companyName,j.jobDescription,j.skills," +
                    "j.jobType,j.salaryRange,j.experience,j.street,j.city,j.PinCode,j.country,j.logoPath,j.jobCategory.title,j.employer.id) " +
                    "FROM Job j " +
                    "where j.jobCategory.title LIKE CONCAT('%',:jobCategory,'%') "
                    + "or j.jobType LIKE CONCAT('%',:jobType,'%')"
                    + "or j.country LIKE CONCAT('%',:country,'%')"
    )
    List<JobResponse> searchJobs(@Param("jobCategory") String jobCategory, @Param("jobType") String jobType, @Param("country") String country);



}
