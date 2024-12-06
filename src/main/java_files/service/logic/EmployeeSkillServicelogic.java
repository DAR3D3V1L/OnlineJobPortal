package service.logic;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import entity.Employee;
import entity.EmployeeSkill;
import exception.ResourceNotFoundException;
import payload.EmployeeSkillDto;
import repositories.EmployeeRepository;
import repositories.EmployeeSkillRepository;
import service.EmployeeSkillService;

@Service
public class EmployeeSkillServicelogic implements EmployeeSkillService {

    private EmployeeSkillRepository employeeSkillRepository;
    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;

    public EmployeeSkillServicelogic(EmployeeSkillRepository employeeSkillRepository,
                                    EmployeeRepository employeeRepository,
                                    ModelMapper modelMapper) {
        this.employeeSkillRepository = employeeSkillRepository;
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public EmployeeSkillDto createSkill(EmployeeSkillDto employeeSkillDto, int employeeId) {

        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "id", employeeId)
        );

        EmployeeSkill employeeSkill = mapToEntity(employeeSkillDto);
        employeeSkill.setEmployee(employee);
        EmployeeSkill db = employeeSkillRepository.save(employeeSkill);
        return mapToDto(db);
    }


    private EmployeeSkillDto mapToDto(EmployeeSkill employeeSkill) {

        return modelMapper.map(employeeSkill, EmployeeSkillDto.class);
    }

    private EmployeeSkill mapToEntity(EmployeeSkillDto employeeSkillDto) {

        return modelMapper.map(employeeSkillDto, EmployeeSkill.class);
    }


}
