package service.logic;

import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.Employee;
import entity.Qualification;
import exception.ResourceNotFoundException;
import payload.QualificationDto;
import repositories.EmployeeRepository;
import repositories.QualificationRepository;
import service.QualificationService;

@Service
public class QualificationServicelogic implements QualificationService {


    private QualificationRepository qualificationRepository;
    private ModelMapper modelMapper;
    private EmployeeRepository employeeRepository;

   // @Autowired
    public QualificationServicelogic(QualificationRepository qualificationRepository,
                                    ModelMapper modelMapper,
                                    EmployeeRepository employeeRepository
    ) {
        this.qualificationRepository = qualificationRepository;
        this.modelMapper = modelMapper;
        this.employeeRepository = employeeRepository;
    }


    @Override
    public QualificationDto createQualification(QualificationDto qualificationDto, int employeeId) {

        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "id", employeeId)
        );

        // Set
        Qualification qualification = mapToQualification(qualificationDto);
        qualification.setEmployee(employee);
        // insert
        Qualification savedQualification = qualificationRepository.save(qualification);
        return mapToQualificationDto(savedQualification);
    }

    private Qualification mapToQualification(QualificationDto qualificationDto) {

        return modelMapper.map(qualificationDto, Qualification.class);
    }

    private QualificationDto mapToQualificationDto(Qualification qualification) {
        return modelMapper.map(qualification, QualificationDto.class);
    }

}
