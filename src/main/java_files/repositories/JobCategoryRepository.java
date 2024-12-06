package repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.JobCategory;

public interface JobCategoryRepository extends JpaRepository<JobCategory, Integer> {

    Optional<JobCategory> findByTitle(String title);
}
