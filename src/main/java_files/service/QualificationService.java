package service;

import payload.QualificationDto;

public interface QualificationService {

    QualificationDto createQualification(QualificationDto qualification , int employeeId);

}
