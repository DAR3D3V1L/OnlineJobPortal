package service.logic;

import java.util.List;

import org.springframework.stereotype.Service;

import entity.JobCategory;
import exception.ResourceNotFoundException;
import repositories.JobCategoryRepository;
import service.JobCategoryService;

@Service
public class JobCategoryServicelogic implements JobCategoryService {


    private JobCategoryRepository jobCategoryRepository;

    public JobCategoryServicelogic(JobCategoryRepository jobCategoryRepository) {
        this.jobCategoryRepository = jobCategoryRepository;
    }

    @Override
    public JobCategory createJobCategory(JobCategory jobCategory) {

        return jobCategoryRepository.save(jobCategory);

    }

    @Override
    public List<JobCategory> getAllJobCategories() {

        return jobCategoryRepository.findAll();

    }

    @Override
    public JobCategory updateJobCategory(int id, JobCategory jobCategory) {
        JobCategory dbJobCategory = isJobCategoryExist(id);

        dbJobCategory.setTitle(jobCategory.getTitle());
        dbJobCategory.setDescription(jobCategory.getDescription());

        return jobCategoryRepository.save(dbJobCategory);
    }

    @Override
    public String deleteJobCategoryById(int id) {


        JobCategory dbJobCategory = isJobCategoryExist(id);

        jobCategoryRepository.delete(dbJobCategory);

        return "Job Category Deleted Successfully";
    }


    private JobCategory isJobCategoryExist(int id) {
        JobCategory dbJobCategory = jobCategoryRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Job Category", "id", id)
        );

        return dbJobCategory;
    }


}
