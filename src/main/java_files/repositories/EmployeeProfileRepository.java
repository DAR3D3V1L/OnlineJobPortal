package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.EmployeeProfileInfo;

public interface EmployeeProfileRepository extends JpaRepository<EmployeeProfileInfo , Integer> {
}