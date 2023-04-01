package com.maddy.studentmanagementservice.contoller;

import com.maddy.studentmanagementservice.dto.StudentRequest;
import com.maddy.studentmanagementservice.model.Student;
import com.maddy.studentmanagementservice.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class StudentController {


    @Autowired
    private StudentService studentService;

    //Get all students
    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    //Get student by id
    @GetMapping("/students/{id}")
    public Student retrieveStudent(@PathVariable long id) {
        return studentService.retrieveStudent(id);
    }

    //Delete a student details from database
    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable long id) {
        studentService.deleteStudent(id);
    }

    //Save a student details
    @PostMapping("/students")
    public ResponseEntity<Object> createStudent(@RequestBody @Valid StudentRequest studentRequest) {
        return studentService.createStudent(studentRequest);
    }

    //Modify a student details
    @PutMapping("/students/{id}")
    public ResponseEntity<Object> updateStudent(@RequestBody @Valid StudentRequest studentRequest, @PathVariable long id) {
        return studentService.updateStudent(studentRequest, id);
    }

}
