package repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.Employer;

public interface EmployerRepository extends JpaRepository<Employer, Integer> {

    Optional<Employer> findByEmail(String email);

}