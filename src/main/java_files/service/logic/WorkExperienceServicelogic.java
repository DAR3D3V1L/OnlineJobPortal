package service.logic;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import entity.Employee;
import entity.WorkExperience;
import exception.ResourceNotFoundException;
import payload.WorkExperienceDto;
import repositories.EmployeeRepository;
import repositories.WorkExperienceRepository;
import service.WorkExperienceService;

@Service
public class WorkExperienceServicelogic implements WorkExperienceService {

    private EmployeeRepository employeeRepository;
    private WorkExperienceRepository workExperienceRepository;
    private ModelMapper modelMapper;

    public WorkExperienceServicelogic(EmployeeRepository employeeRepository,
                                     WorkExperienceRepository workExperienceRepository,
                                     ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.workExperienceRepository = workExperienceRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public WorkExperienceDto createWorkExperience(WorkExperienceDto workExperienceDto, int employeeId) {


        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "id", employeeId)
        );

        WorkExperience workExperience = mapToEntity(workExperienceDto);
        workExperience.setEmployee(employee);


        WorkExperience savedWorkExperience = workExperienceRepository.save(workExperience);

        return mapToDto(savedWorkExperience);

    }


    private WorkExperience mapToEntity(WorkExperienceDto workExperienceDto) {

        return modelMapper.map(workExperienceDto, WorkExperience.class);
    }

    private WorkExperienceDto mapToDto(WorkExperience workExperience) {
        return modelMapper.map(workExperience, WorkExperienceDto.class);
    }


}
