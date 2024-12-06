package service;

import java.util.List;

import entity.Employer;

public interface EmployerService {



    List<Employer> findAllEmployers();

    Employer createEmployer(Employer employer);
}
