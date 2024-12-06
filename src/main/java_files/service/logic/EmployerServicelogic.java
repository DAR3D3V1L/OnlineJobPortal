package service.logic;

import java.util.List;

import org.springframework.stereotype.Service;

import entity.Employer;
import repositories.EmployerRepository;
import service.EmployerService;

@Service
public class EmployerServicelogic implements EmployerService {

    private EmployerRepository employerRepository;

    public EmployerServicelogic(EmployerRepository employerRepository) {
        this.employerRepository = employerRepository;
    }

    @Override
    public List<Employer> findAllEmployers() {

        return employerRepository.findAll();
    }

    @Override
    public Employer createEmployer(Employer employer) {

        return employerRepository.save(employer);
    }
}
