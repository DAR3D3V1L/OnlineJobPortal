package service;

import payload.WorkExperienceDto;

public interface WorkExperienceService {


    WorkExperienceDto createWorkExperience(WorkExperienceDto workExperience, int employeeId);
}
