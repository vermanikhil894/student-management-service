package com.maddy.studentmanagementservice.repository;

import com.maddy.studentmanagementservice.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository <Student, Long> {


}
