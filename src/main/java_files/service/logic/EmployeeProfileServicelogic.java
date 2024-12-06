package service.logic;

import static utils.AppConstant.PATH_TO_SAVE_PROFILE_PHOTOS;
import static utils.AppConstant.PATH_TO_SAVE_RESUMES;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import entity.Employee;
import entity.EmployeeProfileInfo;
import exception.ResourceNotFoundException;
import payload.EmployeeProfileDto;
import payload.EmployeeProfileResponse;
import repositories.EmployeeProfileRepository;
import repositories.EmployeeRepository;
import service.EmployeeProfileService;
import utils.SaveToDisk;

@Service
public class EmployeeProfileServicelogic implements EmployeeProfileService {


    private EmployeeRepository employeeRepository;
    private EmployeeProfileRepository employeeProfileRepository;
    private ModelMapper modelMapper;

    public EmployeeProfileServicelogic(EmployeeRepository employeeRepository,
                                      EmployeeProfileRepository employeeProfileRepository,
                                      ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeProfileRepository = employeeProfileRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public EmployeeProfileResponse createEmployeeProfile(EmployeeProfileDto employeeProfileDto, int employeeId)
            throws IOException {

        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "id", employeeId)
        );


        MultipartFile profilePhoto = employeeProfileDto.getPhoto();
        MultipartFile resume = employeeProfileDto.getResume();

        Path profilePhotoFullPath = Paths.get(PATH_TO_SAVE_PROFILE_PHOTOS + profilePhoto.getOriginalFilename());
        Path resumeFullPath = Paths.get(PATH_TO_SAVE_RESUMES + resume.getOriginalFilename());

        SaveToDisk.saveFile(profilePhoto, profilePhotoFullPath);
        SaveToDisk.saveFile(resume, resumeFullPath);


        EmployeeProfileInfo employeeProfile = new EmployeeProfileInfo();

        employeeProfile.setEmployee(employee);
        employeeProfile.setBio(employeeProfileDto.getBio());
        employeeProfile.setGithub(employeeProfileDto.getGithub());
        employeeProfile.setWebsite(employeeProfileDto.getWebsite());
        employeeProfile.setLinkedin(employeeProfileDto.getLinkedin());
        employeeProfile.setPhotoPath(profilePhotoFullPath.toString());
        employeeProfile.setResumePath(resumeFullPath.toString());


        return mapTOResponse(employeeProfileRepository.save(employeeProfile));
    }


    private EmployeeProfileResponse mapTOResponse(EmployeeProfileInfo employeeProfileInfo) {

        return modelMapper.map(employeeProfileInfo, EmployeeProfileResponse.class);
    }


}
