package com.maddy.studentmanagementservice.model;
import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long studentId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_temp_add_id")
    private TemporaryAddress temporaryAddress;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_perm_add_id")
    private PermanentAddress permanentAddress;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_personalDetailsId")
    private PersonalDetails personalDetails;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_temp_universityDetailId")
    private UniversityDetails universityDetails;

    public Student() {

    }

    public Student(String firstName, String lastName, TemporaryAddress temporaryAddress,
                   PermanentAddress permanentAddress, PersonalDetails personalDetails, UniversityDetails universityDetails) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.temporaryAddress = temporaryAddress;
        this.permanentAddress = permanentAddress;
        this.personalDetails = personalDetails;
        this.universityDetails = universityDetails;
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

    public TemporaryAddress getTemporaryAddress() {
        return temporaryAddress;
    }

    public void setTemporaryAddress(TemporaryAddress temporaryAddress) {
        this.temporaryAddress = temporaryAddress;
    }

    public PermanentAddress getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(PermanentAddress permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public PersonalDetails getPersonalDetails() {
        return personalDetails;
    }

    public void setPersonalDetails(PersonalDetails personalDetails) {
        this.personalDetails = personalDetails;
    }

    public UniversityDetails getUniversityDetails() {
        return universityDetails;
    }

    public void setUniversityDetails(UniversityDetails universityDetails) {
        this.universityDetails = universityDetails;
    }
}
