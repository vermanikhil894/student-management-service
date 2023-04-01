package com.maddy.studentmanagementservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class StudentRequest {

    @Pattern(regexp = "^[a-zA-Z/]*$",message = "Invalid first name")
    @NotBlank(message = "First Name shouldn't be empty")
    private String firstName;

    @Pattern(regexp = "^[a-zA-Z/]*$",message = "Invalid last name")
    @NotBlank(message = "Last Name shouldn't be empty")
    private String lastName;

    @Pattern(regexp = "(?i)Male|(?i)Female|(?i)Other", message = "Invalid gender provided")
    @NotBlank(message = "Gender shouldn't be empty")
    private String gender;

    @NotNull(message = "Address shouldn't be null or empty")
    private AddressRequest temporaryAddress;

    @NotNull(message = "Address shouldn't be null or empty")
    private AddressRequest permanentAddress;

    @NotBlank(message = "Date of Birth shouldn't be null or empty")
    private String dateOfBirth;

    @NotNull(message = "University Details shouldn't be null or empty")
    private UniversityDetailsRequest universityDetailsRequest;

    public StudentRequest() {
    }

    public StudentRequest(String firstName, String lastName, String gender, AddressRequest temporaryAddress, AddressRequest permanentAddress, String dateOfBirth, UniversityDetailsRequest universityDetailsRequest) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.temporaryAddress = temporaryAddress;
        this.permanentAddress = permanentAddress;
        this.dateOfBirth = dateOfBirth;
        this.universityDetailsRequest = universityDetailsRequest;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public AddressRequest getTemporaryAddress() {
        return temporaryAddress;
    }

    public void setTemporaryAddress(AddressRequest temporaryAddress) {
        this.temporaryAddress = temporaryAddress;
    }

    public AddressRequest getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(AddressRequest permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public UniversityDetailsRequest getUniversityDetailsRequest() {
        return universityDetailsRequest;
    }

    public void setUniversityDetailsRequest(UniversityDetailsRequest universityDetailsRequest) {
        this.universityDetailsRequest = universityDetailsRequest;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
