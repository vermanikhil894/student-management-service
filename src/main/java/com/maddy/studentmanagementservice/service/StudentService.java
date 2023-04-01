package com.maddy.studentmanagementservice.service;

import com.maddy.studentmanagementservice.dto.StudentRequest;
import com.maddy.studentmanagementservice.exception.ResourceNotFoundException;
import com.maddy.studentmanagementservice.model.*;
import com.maddy.studentmanagementservice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;
import java.util.Optional;


@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentUpdateService studentUpdateService;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student retrieveStudent(long id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isEmpty()){
            throw new ResourceNotFoundException("Resource not found for id:" + id);
        }
        return student.get();
    }

    public void deleteStudent(long id) {
         studentRepository.deleteById(id);
    }

    public ResponseEntity<Object> createStudent(StudentRequest studentRequest) {

        TemporaryAddress temporaryAddress = studentUpdateService.getTemporaryAddress(studentRequest);

        PermanentAddress permanentAddress = studentUpdateService.getPermanentAddress(studentRequest);

        int age = studentUpdateService.getAge(studentRequest);

        UniversityDetails universityDetails = studentUpdateService.getUniversityDetails(studentRequest);

        PersonalDetails personalDetails = new PersonalDetails(studentRequest.getGender(), studentRequest.getDateOfBirth(), age);

        Student student = new Student(studentRequest.getFirstName(), studentRequest.getLastName(),
                                    temporaryAddress, permanentAddress,
                                    personalDetails, universityDetails);

        Student savedStudent = studentRepository.save(student);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedStudent.getStudentId())
                .toUri();

        return ResponseEntity.created(location)
                .build();

    }

    public ResponseEntity<Object> updateStudent(StudentRequest studentRequest, long id) {

        Optional<Student> studentOptional = studentRepository.findById(id);

        if (studentOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Student student = studentOptional.get();

        studentUpdateService.updateStudent(studentRequest, student);

        studentRepository.save(student);

        return ResponseEntity.noContent()
                .build();
    }

}
