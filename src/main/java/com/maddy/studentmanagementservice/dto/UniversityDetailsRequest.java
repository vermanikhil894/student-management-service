package com.maddy.studentmanagementservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class UniversityDetailsRequest {

    @Email(message = "Invalid email address")
    private String emailId;

    @Pattern(regexp = "^\\d{10}$",message = "invalid mobile number entered")
    private String mobileNumber;

    @Pattern(regexp = "(?i)Paid|(?i)Unpaid|(?i)Processing" ,message = "Invalid fee status")
    @NotBlank(message = "Fee Status cannot be empty")
    private String feeStatus;

    @Pattern(regexp = "(?i)Fall|(?i)Winter|(?i)Summer", message = "Invalid term of admission")
    @NotBlank(message = "Term of admission shouldn't be empty")
    private String termOfAdmission;

    @Pattern(regexp = "^\\d{4}$",message = "invalid mobile number entered")
    private String yearOfAdmission;

    @Pattern(regexp = "(?i)Graduate|(?i)Undergraduate", message = "Invalid degree provided")
    @NotBlank(message = "Degree shouldn't be empty")
    private String degree;

    public UniversityDetailsRequest() {
    }

    public UniversityDetailsRequest(String emailId, String mobileNumber, String feeStatus, String termOfAdmission, String yearOfAdmission, String degree) {
        this.emailId = emailId;
        this.mobileNumber = mobileNumber;
        this.feeStatus = feeStatus;
        this.termOfAdmission = termOfAdmission;
        this.yearOfAdmission = yearOfAdmission;
        this.degree = degree;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getFeeStatus() {
        return feeStatus;
    }

    public void setFeeStatus(String feeStatus) {
        this.feeStatus = feeStatus;
    }

    public String getTermOfAdmission() {
        return termOfAdmission;
    }

    public void setTermOfAdmission(String termOfAdmission) {
        this.termOfAdmission = termOfAdmission;
    }

    public String getYearOfAdmission() {
        return yearOfAdmission;
    }

    public void setYearOfAdmission(String yearOfAdmission) {
        this.yearOfAdmission = yearOfAdmission;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }
}
