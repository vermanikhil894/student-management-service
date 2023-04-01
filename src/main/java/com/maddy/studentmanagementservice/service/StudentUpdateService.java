package com.maddy.studentmanagementservice.service;

import com.maddy.studentmanagementservice.dto.AddressRequest;
import com.maddy.studentmanagementservice.dto.StudentRequest;
import com.maddy.studentmanagementservice.dto.UniversityDetailsRequest;
import com.maddy.studentmanagementservice.model.*;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class StudentUpdateService {

    public PermanentAddress getPermanentAddress (StudentRequest studentRequest) {
        AddressRequest permanentAddressRequest = studentRequest.getPermanentAddress();

        return new PermanentAddress(permanentAddressRequest.getStreetName(), permanentAddressRequest.getCity(),
                permanentAddressRequest.getProvince(), permanentAddressRequest.getCountry(),
                permanentAddressRequest.getPinCode());
    }

    public TemporaryAddress getTemporaryAddress (StudentRequest studentRequest) {
        AddressRequest temporaryAddressRequest = studentRequest.getTemporaryAddress();

        return new TemporaryAddress(temporaryAddressRequest.getStreetName() , temporaryAddressRequest.getCity(),
                temporaryAddressRequest.getProvince(), temporaryAddressRequest.getCountry(),
                temporaryAddressRequest.getPinCode());
    }

    public int getAge (StudentRequest studentRequest){
        long millis=System.currentTimeMillis();
        java.sql.Date date=new java.sql.Date(millis);
        Date dateOfBirth = Date.valueOf(studentRequest.getDateOfBirth());
        return date.compareTo(dateOfBirth);
    }

    public String getStudentStatus (StudentRequest studentRequest) {
        AddressRequest permanentAddressRequest = studentRequest.getPermanentAddress();
        if(permanentAddressRequest.getCountry().equalsIgnoreCase("Canada")) {
            return "Native";
        } else{
            return "International";
        }
    }

    public UniversityDetails getUniversityDetails(StudentRequest studentRequest) {
        UniversityDetailsRequest universityDetailsRequest = studentRequest.getUniversityDetailsRequest();

        return new UniversityDetails(universityDetailsRequest.getEmailId(), universityDetailsRequest.getMobileNumber(),
                universityDetailsRequest.getFeeStatus(), universityDetailsRequest.getTermOfAdmission(),
                universityDetailsRequest.getYearOfAdmission(), universityDetailsRequest.getDegree(), getStudentStatus(studentRequest));
    }

    public void updateStudent (StudentRequest studentRequest, Student student){

        student.setFirstName(studentRequest.getFirstName());
        student.setLastName(studentRequest.getLastName());

        AddressRequest temporaryAddressRequest = studentRequest.getTemporaryAddress();
        AddressRequest permanentAddressRequest = studentRequest.getPermanentAddress();

        TemporaryAddress temporaryAddress = student.getTemporaryAddress();
        temporaryAddress.setStreetName(temporaryAddressRequest.getStreetName());
        temporaryAddress.setCity(temporaryAddressRequest.getCity());
        temporaryAddress.setProvince(temporaryAddressRequest.getProvince());
        temporaryAddress.setCountry(temporaryAddressRequest.getCountry());
        temporaryAddress.setPinCode(temporaryAddressRequest.getPinCode());

        PermanentAddress permanentAddress = student.getPermanentAddress();
        permanentAddress.setStreetName(permanentAddressRequest.getStreetName());
        permanentAddress.setCity(permanentAddressRequest.getCity());
        permanentAddress.setProvince(permanentAddressRequest.getProvince());
        permanentAddress.setCountry(permanentAddressRequest.getCountry());
        permanentAddress.setPinCode(permanentAddressRequest.getPinCode());

        PersonalDetails personalDetails = student.getPersonalDetails();
        personalDetails.setGender(studentRequest.getGender());
        personalDetails.setDateOfBirth(studentRequest.getDateOfBirth());
        personalDetails.setAge(getAge(studentRequest));

        UniversityDetailsRequest universityDetailsRequest = studentRequest.getUniversityDetailsRequest();
        UniversityDetails universityDetails = student.getUniversityDetails();
        universityDetails.setEmailId(universityDetailsRequest.getEmailId());
        universityDetails.setMobileNumber(universityDetailsRequest.getMobileNumber());
        universityDetails.setFeeStatus(universityDetailsRequest.getFeeStatus());
        universityDetails.setTermOfAdmission(universityDetailsRequest.getTermOfAdmission());
        universityDetails.setYearOfAdmission(universityDetailsRequest.getYearOfAdmission());
        universityDetails.setDegree(universityDetailsRequest.getDegree());
        universityDetails.setStudentStatus(getStudentStatus(studentRequest));

    }

}
