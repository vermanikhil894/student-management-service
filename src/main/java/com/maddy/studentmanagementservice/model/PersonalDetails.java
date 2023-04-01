package com.maddy.studentmanagementservice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "personalDetails")
public class PersonalDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "temp_personalDetailsId")
    private long personalDetailsId;

    @Column(name = "gender")
    private String gender;

    @Column(name = "date_of_birth")
    private String dateOfBirth;

    @Column(name = "age")
    private int age;

    public PersonalDetails() {
    }

    public PersonalDetails(String gender, String dateOfBirth, int age) {
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
    }

    public long getPersonalDetailsId() {
        return personalDetailsId;
    }

    public void setPersonalDetailsId(long personalDetailsId) {
        this.personalDetailsId = personalDetailsId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
