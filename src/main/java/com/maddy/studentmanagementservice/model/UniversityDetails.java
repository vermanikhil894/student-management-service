package com.maddy.studentmanagementservice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "universityDetails")
public class UniversityDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "temp_universityDetailId")
    public long universityDetailId;

    @Column(name = "emailId")
    private String emailId;

    @Column(name = "mobileNumber")
    private String mobileNumber;

    @Column(name = "feeStatus")
    private String feeStatus;

    @Column(name = "termOfAdmission")
    private String termOfAdmission;

    @Column(name = "yearOfAdmission")
    private String yearOfAdmission;

    @Column(name = "degree")
    private String degree;

    @Column(name = "student_status")
    private String studentStatus;

    public UniversityDetails() {

    }

    public UniversityDetails(String emailId, String mobileNumber, String feeStatus,
                             String termOfAdmission, String yearOfAdmission, String degree, String studentStatus) {
        this.emailId = emailId;
        this.mobileNumber = mobileNumber;
        this.feeStatus = feeStatus;
        this.termOfAdmission = termOfAdmission;
        this.yearOfAdmission = yearOfAdmission;
        this.degree = degree;
        this.studentStatus = studentStatus;
    }

    public long getUniversityDetailId() {
        return universityDetailId;
    }

    public void setUniversityDetailId(long universityDetailId) {
        this.universityDetailId = universityDetailId;
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

    public String getStudentStatus() {
        return studentStatus;
    }

    public void setStudentStatus(String studentStatus) {
        this.studentStatus = studentStatus;
    }
}
