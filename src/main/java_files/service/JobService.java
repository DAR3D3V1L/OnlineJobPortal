package service;
import java.io.IOException;
import java.util.List;

import payload.JobDto;
import payload.JobResponse;

public interface JobService {



    String createJob(JobDto jobDto, int employerId) throws IOException;


    List<JobResponse> findByAllJobsByEmployerId(int id);

    List<JobResponse> getAllJobs();

    String deleteJob(int employerId, int jobId);

    JobResponse getJobByJobId(int jobId);


    List<JobResponse> searchJob(String jobCategory, String jobType, String country);
}
