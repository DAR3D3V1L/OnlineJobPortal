package service;

import java.util.List;

import entity.JobCategory;

public interface JobCategoryService {

    JobCategory createJobCategory(JobCategory jobCategory);
    List<JobCategory>getAllJobCategories();

    JobCategory updateJobCategory(int id , JobCategory jobCategory);
    String deleteJobCategoryById(int id);



}
