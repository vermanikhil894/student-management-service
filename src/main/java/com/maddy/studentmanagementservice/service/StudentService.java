package com.maddy.studentmanagementservice.service;

import com.maddy.studentmanagementservice.exception.ResourceNotFoundException;
import com.maddy.studentmanagementservice.model.Student;
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

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student retrieveStudent(long id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isEmpty()){
            throw new ResourceNotFoundException("id-" + id);
        }
        return student.get();
    }

    public void deleteStudent(long id) {
         studentRepository.deleteById(id);
    }

    public ResponseEntity<Object> createStudent(Student student) {
        Student savedStudent = studentRepository.save(student);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedStudent.getStudentId())
                .toUri();

        return ResponseEntity.created(location)
                .build();

    }

    public ResponseEntity<Object> updateStudent(Student student, long id) {

        Optional<Student> studentOptional = studentRepository.findById(id);

        if (studentOptional.isEmpty())
            return ResponseEntity.notFound().build();

        student.setStudentId(id);

        studentRepository.save(student);

        return ResponseEntity.noContent()
                .build();
    }
}
