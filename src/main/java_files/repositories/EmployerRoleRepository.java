package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.EmployerRole;

public interface EmployerRoleRepository extends JpaRepository<EmployerRole, Integer> {
}