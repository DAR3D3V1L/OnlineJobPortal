package service;

import payload.EmployeeSkillDto;

public interface EmployeeSkillService {

    EmployeeSkillDto createSkill(EmployeeSkillDto employeeSkillDto, int employeeId);

}
