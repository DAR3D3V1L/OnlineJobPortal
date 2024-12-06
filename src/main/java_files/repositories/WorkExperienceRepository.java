package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.WorkExperience;

public interface WorkExperienceRepository extends JpaRepository<WorkExperience , Integer> {
}
