package com.maddy.studentmanagementservice.model;
import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long studentId;

    @Column(name = "first_name")
    public String firstName;

    @Column(name = "last_name")
    public String lastName;

    @Column(name = "email_id")
    public String emailId;

    @Column(name = "term_of_admission")
    public String termOfAdmission;

    @Column(name = "degree")
    public String degree;

    @Column(name = "gender")
    public String gender;

    @Column(name = "country_of_origin")
    public String countryOfOrigin;

    public Student() {

    }

    public Student(String firstName, String lastName, String emailId, String termOfAdmission, String degree, String gender, String countryOfOrigin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.termOfAdmission = termOfAdmission;
        this.degree = degree;
        this.gender = gender;
        this.countryOfOrigin = countryOfOrigin;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
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

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getTermOfAdmission() {
        return termOfAdmission;
    }

    public void setTermOfAdmission(String termOfAdmission) {
        this.termOfAdmission = termOfAdmission;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }
}
