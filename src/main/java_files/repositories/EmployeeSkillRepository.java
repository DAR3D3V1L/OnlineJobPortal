package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.EmployeeSkill;

public interface EmployeeSkillRepository extends JpaRepository<EmployeeSkill, Integer> {
}